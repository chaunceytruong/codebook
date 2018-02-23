package com.polarr.traffic;

public class Intersection {

    private Light state;

    public Intersection() {
        state = null;
    }
    public void setState(Light state) {
        this.state = state;
    }

    public Light getState(){
        return state;
    }
}
