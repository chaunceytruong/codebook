package com.polarr.traffic;

public interface Light {
    void red(Intersection intersection);
    void yellow(Intersection intersection);
    void green(Intersection intersection);
    Color getColor();
}
