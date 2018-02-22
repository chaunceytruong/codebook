package com.codebook.algorithm.Light;

public class Vehicle {
    Direction direction;
    int id;

    public Vehicle(int id, Direction direction) {
        this.id = id;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "direction=" + direction +
                ", id=" + id +
                '}';
    }
}
