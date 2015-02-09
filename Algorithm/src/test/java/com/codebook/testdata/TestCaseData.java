package com.codebook.testdata;


public class TestCaseData {

    public static class Arrays {

        public static int[] newEmptyArray() {
            return new int[0];
        }

        public static int[] newSortedArray() {
            return new int[] { 0, 1, 2, 3, 4, 5 };
        }

        public static int[] newReverseSortedArray() {
            return new int[] { 5, 4, 3, 2, 1, 0 };
        }

        public static int[] newUnsortedArrayWithDuplicates() {
            return new int[] { 2, 6, 2, 4, 1, 8 };
        }

        public static int[] newArrayWithAllDuplicates() {
            return new int[] { 2, 2, 2, 2, 2, 2 };
        }

        public static int[] newUnsortedArrayWithNegatives() {
            return new int[] { -2, 6, 2, -4, 1, 8 };
        }
    }
}
