package com.david.algorithm.test;

import static org.junit.Assert.*;

import com.david.algorithm.EquilbriumIndex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EquilibriumIndexText {
    EquilbriumIndex mEquilbriumIndex;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	mEquilbriumIndex = new EquilbriumIndex();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	mEquilbriumIndex = null;
    }

    @Test
    public void testSimple() {
	int[] values = new int[] { 1, 2, 3, 2, 1};
	int expectedindex = 2;
	int actualIndex = mEquilbriumIndex.find(values);
	assertEquals(expectedindex, actualIndex);
    }

}
