package com.codebook.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

    private int[] inputValues = { 0, 1, -1, 9, 10000 };
    private int[] expectedOutput = { 0, 1, 0, 34, 1242044891 };

    private Fibonacci mFibonacci;

    @Before
    public void setUp() throws Exception {
        mFibonacci = new Fibonacci();
    }

    @Test
    public void testRecursive() {
        for (int n = 0; n < inputValues.length; n++) {
            int actual = mFibonacci.recursive(inputValues[n]);
            int expected = expectedOutput[n];
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void testDynamic() {
        for (int n = 0; n < inputValues.length; n++) {
            int actual = mFibonacci.dynamic(inputValues[n]);
            int expected = expectedOutput[n];
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void testSpeed() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 40; i++) {
            mFibonacci.recursive(i);
        }
        System.out.println(String.format("Recursive solution took %d ms to process 40 values", (System.currentTimeMillis() - startTime)));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 25000; i++) {
            mFibonacci.dynamic(i);
        }
        System.out.println(String.format("Dynamic solution took %d ms to process 25000 values", (System.currentTimeMillis() - startTime)));
    }
}
