package com.restaurant;

public class Waiter {
    int id;
    int sectionId;

    public Waiter(int id, int sectionId) {
        this.id = id;
        this.sectionId = sectionId;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "id=" + id +
                ", sectionId=" + sectionId +
                '}';
    }
}
