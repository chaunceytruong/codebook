package com.polarr.traffic;

import com.sun.istack.internal.NotNull;

import java.util.List;

public interface TrafficSimulation {

    /**
     * Initialize the simulation with specified list of vehicles and the times when they arrive at the intersection (aka delay).
     *
     * @param vehicles vehicles that will arrive at the intersection during the simulation.
     * @param delays times that each vehicle arrives at the intersection. Must be non-negative.
     *
     * @throws IllegalArgumentException # of vehicles must equal # of delays, and delays must be non-negative.
     */
    void init(@NotNull List<Vehicle> vehicles, @NotNull List<Integer> delays) throws IllegalArgumentException;

    void start();

    void stop();
}
