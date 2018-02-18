package com.codebook.algorithm;

import java.util.Arrays;
import java.util.Random;

public class NonUniformRandomNumberGenerator {

    int generate(double[] probabilities) throws InvalidProbabilityRangeException {
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
        double lowerRange = probabilities[0] * 100;
        double midRange = lowerRange + probabilities[1] * 100;
        if (uniformRoll >= 0 && uniformRoll < lowerRange) {
            return 6;
        } else if (uniformRoll >= lowerRange && uniformRoll < midRange) {
            return 1;
        }
        return 2;
    }

    class InvalidProbabilityRangeException extends Exception {
        InvalidProbabilityRangeException(String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) throws InvalidProbabilityRangeException {
        double[] probs = { .25, .5, .25 };
        System.out.println(new NonUniformRandomNumberGenerator().generate(probs));
    }
}
