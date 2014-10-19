package com.codebook.algorithm.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codebook.algorithm.EquilbriumIndex;

public class EquilibriumIndexText {

	@Before
	public void setUp() {
		
	}

	@After
	public void tearDown() {
		
	}

	@Test
	public void testSimple() {
		int[] values = new int[] { 1, 2, 3, 2, 1 };
		int expectedindex = 2;
		int actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);
	}

	@Test
	public void testExtremelyLargeNumbers() {
		int[] values = new int[] { 1082132608, 0, 1082132608 };
		int expectedindex = 1;
		int actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);
	}

	@Test
	public void testOverflowEquilibriumIndexDoesNotExist() {
		int[] values = new int[] { 0, 2147483647, 2147483647 };
		int expectedindex = -1;
		int actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);
	}

	@Test
	public void testOverflowEquilibriumIndexExists() {
		int[] values = new int[] { 0, 2147483647, 2147483647, 2147483647 };
		int expectedindex = 2;
		int actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);
	}

	@Test
	public void testOneLarge() {
		int[] values = new int[] { 2, -1, -2, 1, 50 };
		int expectedindex = 4;
		int actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);
	}

	@Test
	public void testSumZero() {
		int[] values = new int[] { 2, -1, -2, 1 };
		int expectedindex = 2;
		int actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);
	}

	@Test
	public void testSingle() {
		int[] values = new int[] { 0 };
		int expectedindex = 0;
		int actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);
	}

	@Test
	public void testEmpty() {
		int[] values = new int[] {};
		int expectedindex = -1;
		int actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);
	}

	@Test
	public void testCominationsOfTwo() {
		int[] values = new int[] { 0, -1 };
		int expectedindex = 1;
		int actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);

		values = new int[] { 0, 1 };
		expectedindex = 1;
		actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);

		values = new int[] { 1, 0 };
		expectedindex = 0;
		actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);

		values = new int[] { 1, -1 };
		expectedindex = -1;
		actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);

		values = new int[] { -1, 0 };
		expectedindex = 0;
		actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);

		values = new int[] { -1, 1 };
		expectedindex = -1;
		actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);
	}

	@Test
	public void testSmallPyramid() {
		int[] values = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -9, -8, -7,
				-6, -5, -4, -3, -2, -1 };
		int expectedindex = 0;
		int actualIndex = EquilbriumIndex.find(values);
		assertEquals(expectedindex, actualIndex);
	}

}
