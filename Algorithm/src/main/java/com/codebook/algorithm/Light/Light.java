package com.codebook.algorithm.Light;

public interface Light {
    void red(Intersection intersection);
    void yellow(Intersection intersection);
    void green(Intersection intersection);
    Color getColor();
}
