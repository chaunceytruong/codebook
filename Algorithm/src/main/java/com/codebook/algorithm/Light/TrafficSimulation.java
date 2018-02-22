package com.codebook.algorithm.Light;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficSimulation {

    private static Queue<Vehicle> vehicles;
    private static Intersection intersection;
    private static boolean isRunning;
    private static final Light NorthSouthLight = new NorthSouth();
    private static final Light EastWestLight = new EastWest();

    private static Queue<Vehicle> backedUpNorthSouthVehicles;
    private static Queue<Vehicle> backedUpEastWestVehicles;

    private static long startTime;

    public static void main(String[] args) {
        init();
        mainTrafficLoop();
    }

    private static void mainTrafficLoop() {
        Light initialLight = NorthSouthLight;
        initialLight.green(intersection);
        logMsgWithTime(NorthSouthLight.toString());
        while (isRunning) {
            if (vehicles.peek() == null) {
                continue;
            }
            Vehicle current = vehicles.remove();

            final Light intersectionLight = intersection.getState();
            Color intersectionLightColor = intersectionLight.getColor();

            if (intersectionLight instanceof NorthSouth && current.direction == Direction.NorthSouth) {
                System.out.println("     " + current + " drives thru.");
            } else if (intersectionLight instanceof EastWest && current.direction == Direction.EastWest) {
                System.out.println("     " + current + " drives thru.");
            } else {
                /**
                 * If prev is NorthSouth GREEN then set NorthSouth YELLOW then set NorthSouth RED then set
                 * EastWest GREEN then set EastWest YELLOW then set EastWest RED then set NorthSouth GREEN
                 */
                ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
                if (intersectionLight instanceof NorthSouth && current.direction == Direction.EastWest && intersectionLightColor == Color.GREEN) {
                    service.schedule(new NorthSouthLightTurnsYellow(), 5, TimeUnit.SECONDS);
                    service.schedule(new NorthSouthLightTurnsRed(), 8, TimeUnit.SECONDS);
                    service.schedule(new EastWestLightTurnsGreen(), 8, TimeUnit.SECONDS);
                    service.schedule(new EastWestLightTurnsYellow(), 15, TimeUnit.SECONDS);
                    service.schedule(new NorthSouthLightTurnsGreen(), 18, TimeUnit.SECONDS);

                }
            }
        }
    }

    private static void init() {
        startTime = System.currentTimeMillis();
        vehicles = new ArrayDeque<>();
        backedUpEastWestVehicles = new ArrayDeque<>();
        backedUpNorthSouthVehicles = new ArrayDeque<>();
        intersection = new Intersection();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(new AddVehicleToIntersection(new Vehicle(1, Direction.EastWest)), 0, TimeUnit.SECONDS);
        service.schedule(new AddVehicleToIntersection(new Vehicle(2, Direction.NorthSouth)), 1, TimeUnit.SECONDS);
        service.schedule(new AddVehicleToIntersection(new Vehicle(3, Direction.EastWest)), 5, TimeUnit.SECONDS);
        service.schedule(new AddVehicleToIntersection(new Vehicle(4, Direction.EastWest)), 10, TimeUnit.SECONDS);
        service.schedule(new AddVehicleToIntersection(new Vehicle(5, Direction.NorthSouth)), 13, TimeUnit.SECONDS);
        service.schedule(new AddVehicleToIntersection(new Vehicle(6, Direction.NorthSouth)), 16, TimeUnit.SECONDS);
        service.schedule(new AddVehicleToIntersection(new Vehicle(7, Direction.EastWest)), 16, TimeUnit.SECONDS);
        service.schedule(new AddVehicleToIntersection(new Vehicle(8, Direction.NorthSouth)), 21, TimeUnit.SECONDS);
        isRunning = true;
    }

    private static void flushBackedUpEastWestVehicles() {
        while (backedUpEastWestVehicles.peek() != null) {
            logMsgWithoutTime(backedUpEastWestVehicles.remove() + " drives thru.");
        }
    }

    private static void flushBackedUpNorthSouthVehicles() {
        while (backedUpNorthSouthVehicles.peek() != null) {
            logMsgWithoutTime(backedUpNorthSouthVehicles.remove() + " drives thru.");
        }
    }

    private static class NorthSouthLightTurnsGreen implements Runnable {
        @Override
        public void run() {
            EastWestLight.red(intersection);
            logMsgWithTime(EastWestLight.toString());
            NorthSouthLight.green(intersection);
            logMsgWithTime(NorthSouthLight.toString());
            flushBackedUpNorthSouthVehicles();
        }
    }

    private static class NorthSouthLightTurnsYellow implements Runnable {
        @Override
        public void run() {
            NorthSouthLight.yellow(intersection);
            logMsgWithTime(NorthSouthLight.toString());
            flushBackedUpNorthSouthVehicles();
        }
    }

    private static class NorthSouthLightTurnsRed implements Runnable {
        @Override
        public void run() {
            NorthSouthLight.red(intersection);
            logMsgWithTime(NorthSouthLight.toString());
        }
    }

    private static class EastWestLightTurnsGreen implements Runnable {
        @Override
        public void run() {
            EastWestLight.green(intersection);
            logMsgWithTime(EastWestLight.toString());
            flushBackedUpEastWestVehicles();
        }
    }

    private static class EastWestLightTurnsYellow implements Runnable {
        @Override
        public void run() {
            EastWestLight.yellow(intersection);
            logMsgWithTime(EastWestLight.toString());
            flushBackedUpEastWestVehicles();
        }
    }

    private static void logMsgWithoutTime(String msg) {
        System.out.println("     " + msg);
    }

    private static void logMsgWithTime(String msg) {
        int currentTime = ((int) ((System.currentTimeMillis() - startTime) / 1000));
        int min = currentTime / 60;
        int sec = currentTime % 60;
        System.out.println(min + ":" + ((sec < 10) ? ("0" + sec) : sec) + " " + msg);
    }

    private static class AddVehicleToIntersection implements Runnable {

        Vehicle vehicle;

        AddVehicleToIntersection(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        @Override
        public void run() {
            logMsgWithTime(String.format("%s appears at intersection.", vehicle.toString()));

            final Light intersectionLight = intersection.getState();
            if (intersectionLight instanceof NorthSouth && vehicle.direction == Direction.NorthSouth) {
                System.out.println("     " + vehicle + " drives thru.");
            } else if (intersectionLight instanceof EastWest && vehicle.direction == Direction.EastWest) {
                System.out.println("     " + vehicle + " drives thru.");
            } else if (intersectionLight instanceof NorthSouth && vehicle.direction == Direction.EastWest ) {
                backedUpEastWestVehicles.add(vehicle);
                vehicles.add(vehicle);
            } else if (intersectionLight instanceof EastWest && vehicle.direction == Direction.NorthSouth) {
                backedUpNorthSouthVehicles.add(vehicle);
                vehicles.add(vehicle);
            }
        }
    }
}
