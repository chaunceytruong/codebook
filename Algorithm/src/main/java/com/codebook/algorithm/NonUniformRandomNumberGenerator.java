package com.codebook.algorithm;

import java.util.Arrays;
import java.util.Random;

public class NonUniformRandomNumberGenerator {

    int generate(double[] probabilities, int[] numbers) throws InvalidProbabilityRangeException {
        if (probabilities == null || probabilities.length == 0) {
            throw new InvalidProbabilityRangeException("Probabilities can't be null!");
        }
        double sum = 0.0;
        for (double p : probabilities) {
            sum += p;
        }
        if (sum != 1.0) {
            throw new InvalidProbabilityRangeException("Probabilities don't add up to 1.0!");
        }
        int uniformRoll = new Random().nextInt(100);
        System.out.println("Uniform roll " + uniformRoll);

        int range = 0;
        for (int i = 0; i < probabilities.length; i++) {
            range += probabilities[i] * 100;
            if (uniformRoll < range) {
                return numbers[i];
            }
        }
        // Should never reach this point.
        return -1;
    }

    class InvalidProbabilityRangeException extends Exception {
        InvalidProbabilityRangeException(String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) throws InvalidProbabilityRangeException {
        double[] probs = { 0, 0, .5, .5 };
        int[] numbers = { 6, 7, 1, 2 };
        System.out.println(new NonUniformRandomNumberGenerator().generate(probs, numbers));
    }
}
