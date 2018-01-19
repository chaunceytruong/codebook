package com.codebook.algorithm;

import com.codebook.algorithm.SortUtils;
import com.codebook.testdata.TestCaseData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MergeSortTest {

    @Before
    public void setUp() {
        System.out.println("Initializing test...");
    }

    @After
    public void finish() {
        System.out.println("Test finished.\n");
    }

    @Test
    public void testSortEmptyArray() {
        int[] emptyArray = TestCaseData.Arrays.newEmptyArray();
        SortUtils.mergeSort(emptyArray);

        Assert.assertArrayEquals(
                TestCaseData.Arrays.newEmptyArray(),
                emptyArray);
    }

    @Test
    public void testAlreadySortedArray() {
        int[] alreadySortedArray = TestCaseData.Arrays.newSortedArray();
        SortUtils.mergeSort(alreadySortedArray);

        Assert.assertArrayEquals(
                TestCaseData.Arrays.newSortedArray(),
                alreadySortedArray);
    }

    @Test
    public void testReverseSortedArray() {
        int[] reverseSortedArray = TestCaseData.Arrays.newReverseSortedArray();
        SortUtils.mergeSort(reverseSortedArray);

        Assert.assertArrayEquals(
                TestCaseData.Arrays.newSortedArray(),
                reverseSortedArray);
    }

    @Test
    public void testUnsortedArrayWithDuplicates() {
        int[] unsortedArrayWithDuplicates = TestCaseData.Arrays.newUnsortedArrayWithDuplicates();
        SortUtils.mergeSort(unsortedArrayWithDuplicates);

        Assert.assertArrayEquals(
                new int[] { 1, 2, 2, 4, 6, 8 },
                unsortedArrayWithDuplicates);
    }

    @Test
    public void testUnsortedArrayWithNegatives() {
        int[] arrayWithNegatives = TestCaseData.Arrays.newUnsortedArrayWithNegatives();
        SortUtils.mergeSort(arrayWithNegatives);

        Assert.assertArrayEquals(
                new int[] { -4, -2, 1, 2, 6, 8 },
                arrayWithNegatives);
    }

    @Test
    public void testArrayWithAllDuplicates() {
        int[] arrayWithAllDuplicates = TestCaseData.Arrays.newArrayWithAllDuplicates();
        SortUtils.mergeSort(arrayWithAllDuplicates);

        Assert.assertArrayEquals(
                TestCaseData.Arrays.newArrayWithAllDuplicates(),
                arrayWithAllDuplicates);
    }
}
