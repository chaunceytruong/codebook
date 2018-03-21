package com.restaurant;

public class Table {
    int id;
    boolean available;
    int seats;

    public Table(int id, boolean available, int seats) {
        this.id = id;
        this.available = available;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", available=" + available +
                ", seats=" + seats +
                '}';
    }
}
