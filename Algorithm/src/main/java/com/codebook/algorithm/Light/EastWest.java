package com.codebook.algorithm.Light;

public class EastWest implements Light {

    Color currentColor;

    @Override
    public void red(Intersection intersection) {
        currentColor = Color.RED;
        intersection.setState(this);
    }

    @Override
    public void yellow(Intersection intersection) {
        currentColor = Color.YELLOW;
        intersection.setState(this);
    }

    @Override
    public void green(Intersection intersection) {
        currentColor = Color.GREEN;
        intersection.setState(this);
    }

    @Override
    public Color getColor() {
        return currentColor;
    }

    @Override
    public String toString() {
        return EastWest.class.getSimpleName() + " " + currentColor;
    }
}
