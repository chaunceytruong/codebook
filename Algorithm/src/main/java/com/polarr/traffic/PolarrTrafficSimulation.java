package com.polarr.traffic;

import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PolarrTrafficSimulation implements TrafficSimulation {

    // ================================================================================
    // Properties
    // ================================================================================

    private Queue<Vehicle> vehicles;
    private Queue<Vehicle> backedUpNorthSouthVehicles;
    private Queue<Vehicle> backedUpEastWestVehicles;

    private Intersection intersection;

    private Light NorthSouthLight;
    private Light EastWestLight;

    private boolean isRunning;
    private long startTime;

    ScheduledExecutorService service;

    // ================================================================================
    // Constructors
    // ================================================================================

    public PolarrTrafficSimulation() {
        startTime = System.currentTimeMillis();
        vehicles = new ArrayDeque<>();
        backedUpEastWestVehicles = new ArrayDeque<>();
        backedUpNorthSouthVehicles = new ArrayDeque<>();
        intersection = new Intersection();
        NorthSouthLight = new NorthSouthLight();
        EastWestLight = new EastWestLight();
        service = Executors.newScheduledThreadPool(1);
    }

    // ================================================================================
    // Public Methods
    // ================================================================================

    public static void main(String[] args) {
        TrafficSimulation simulation = new PolarrTrafficSimulation();
        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle(1, Direction.East),
                new Vehicle(2, Direction.North),
                new Vehicle(3, Direction.West),
                new Vehicle(4, Direction.East),
                new Vehicle(5, Direction.South),
                new Vehicle(6, Direction.North),
                new Vehicle(7, Direction.East),
                new Vehicle(8, Direction.South)
        );
        List<Integer> delayTimes = Arrays.asList(0, 1, 5, 10, 13, 16, 16, 21);
        simulation.init(vehicles, delayTimes);
        simulation.start();
    }

    @Override
    public void init(@NotNull List<Vehicle> vehicles, @NotNull List<Integer> delays) throws IllegalArgumentException {
        if (vehicles.size() != delays.size()) {
            throw new IllegalArgumentException("# of vehicles != # of delays");
        }
        for (int delay : delays) {
            if (delay < 0) {
                throw new IllegalArgumentException("Delay times must be non-negative!");
            }
        }
        for (int i = 0; i < vehicles.size(); i++) {
            service.schedule(new AddVehicleToIntersection(vehicles.get(i)), delays.get(i), TimeUnit.SECONDS);
        }

        // Initialize the intersection with the North/South green light.
        NorthSouthLight.green(intersection);
        logMsgWithTime(NorthSouthLight.toString());
    }

    @Override
    public void start() {
        isRunning = true;

        // Kick off the main run loop
        mainLoop();
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    // ================================================================================
    // Private Methods
    // ================================================================================

    private void mainLoop() {
        while (isRunning) {
            if (vehicles.peek() == null) {
                continue;
            }
            Vehicle current = vehicles.remove();

            final Light intersectionLight = intersection.getState();
            Color intersectionLightColor = intersectionLight.getColor();

            if (intersectionLight instanceof com.polarr.traffic.NorthSouthLight && (current.direction == Direction.North || current.direction == Direction.South)) {
                logMsgWithoutTime(current + " drives thru.");
            } else if (intersectionLight instanceof com.polarr.traffic.EastWestLight && (current.direction == Direction.East || current.direction == Direction.West)) {
                logMsgWithoutTime(current + " drives thru.");
            } else {
                /**
                 * As soon as there is car waiting in the east/west direction, there is a 5 seconds delay
                 * before the northSouth light turns yellow. The northSouth light stays yellow for 3
                 * seconds, and then finally turns red for 10 seconds. When the northSouth light is red,
                 * the eastWest light is green for 7 seconds, and then turns yellow for 3 seconds. And
                 * afterwards, the eastWest light becomes red and the northSouth light stays green, until
                 * another car appears in the east/west direction.
                 */
                if (intersectionLight instanceof com.polarr.traffic.NorthSouthLight && (current.direction == Direction.East || current.direction == Direction.West) && intersectionLightColor == Color.GREEN) {
                    service.schedule(new NorthSouthLightTurnsYellow(), 5, TimeUnit.SECONDS);
                    service.schedule(new NorthSouthLightTurnsRed(), 8, TimeUnit.SECONDS);
                    service.schedule(new EastWestLightTurnsGreen(), 8, TimeUnit.SECONDS);
                    service.schedule(new EastWestLightTurnsYellow(), 15, TimeUnit.SECONDS);
                    service.schedule(new NorthSouthLightTurnsGreen(), 18, TimeUnit.SECONDS);
                }
            }
        }
    }

    /**
     * Flush backed up vehicles in the East/West direction.
     */
    private void flushBackedUpEastWestVehicles() {
        while (backedUpEastWestVehicles.peek() != null) {
            logMsgWithoutTime(backedUpEastWestVehicles.remove() + " drives thru.");
        }
    }

    /**
     * Flush backed up vehicles in the North/South direction.
     */
    private void flushBackedUpNorthSouthVehicles() {
        while (backedUpNorthSouthVehicles.peek() != null) {
            logMsgWithoutTime(backedUpNorthSouthVehicles.remove() + " drives thru.");
        }
    }

    private static Direction getRandomDirection(Random random) {
        switch (random.nextInt(4)) {
            case 0:
                return Direction.North;
            case 1:
                return Direction.South;
            case 2:
                return Direction.East;
            case 3:
                return Direction.West;
        }
        return Direction.North;
    }

    /**
     * Log message without timestamp.
     *
     * @param msg message to log.
     */
    private void logMsgWithoutTime(String msg) {
        System.out.println("     " + msg);
    }

    /**
     * Log message with timestamp.
     *
     * @param msg message to log.
     */
    private void logMsgWithTime(String msg) {
        int currentTime = ((int) ((System.currentTimeMillis() - startTime) / 1000));
        int min = currentTime / 60;
        int sec = currentTime % 60;
        System.out.println(min + ":" + ((sec < 10) ? ("0" + sec) : sec) + " " + msg);
    }

    // ================================================================================
    // Inner Classes
    // ================================================================================

    private class NorthSouthLightTurnsGreen implements Runnable {
        @Override
        public void run() {
            EastWestLight.red(intersection);
            logMsgWithTime(EastWestLight.toString());
            NorthSouthLight.green(intersection);
            logMsgWithTime(NorthSouthLight.toString());
            flushBackedUpNorthSouthVehicles();
        }
    }

    private class NorthSouthLightTurnsYellow implements Runnable {
        @Override
        public void run() {
            NorthSouthLight.yellow(intersection);
            logMsgWithTime(NorthSouthLight.toString());
            flushBackedUpNorthSouthVehicles();
        }
    }

    private class NorthSouthLightTurnsRed implements Runnable {
        @Override
        public void run() {
            NorthSouthLight.red(intersection);
            logMsgWithTime(NorthSouthLight.toString());
        }
    }

    private class EastWestLightTurnsGreen implements Runnable {
        @Override
        public void run() {
            EastWestLight.green(intersection);
            logMsgWithTime(EastWestLight.toString());
            flushBackedUpEastWestVehicles();
        }
    }

    private class EastWestLightTurnsYellow implements Runnable {
        @Override
        public void run() {
            EastWestLight.yellow(intersection);
            logMsgWithTime(EastWestLight.toString());
            flushBackedUpEastWestVehicles();
        }
    }

    private class AddVehicleToIntersection implements Runnable {

        Vehicle vehicle;

        AddVehicleToIntersection(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        @Override
        public void run() {
            logMsgWithTime(String.format("%s appears at intersection.", vehicle.toString()));

            final Light intersectionLight = intersection.getState();
            if (intersectionLight instanceof com.polarr.traffic.NorthSouthLight && (vehicle.direction == Direction.North || vehicle.direction == Direction.South)) {
                logMsgWithoutTime(vehicle + " drives thru.");
            } else if (intersectionLight instanceof com.polarr.traffic.EastWestLight && (vehicle.direction == Direction.East || vehicle.direction == Direction.West)) {
                logMsgWithoutTime(vehicle + " drives thru.");
            } else if (intersectionLight instanceof com.polarr.traffic.NorthSouthLight && (vehicle.direction == Direction.East || vehicle.direction == Direction.West)) {
                backedUpEastWestVehicles.add(vehicle);
                vehicles.add(vehicle);
            } else if (intersectionLight instanceof com.polarr.traffic.EastWestLight && (vehicle.direction == Direction.North || vehicle.direction == Direction.South)) {
                backedUpNorthSouthVehicles.add(vehicle);
                vehicles.add(vehicle);
            }
        }
    }

}
