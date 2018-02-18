package com.codebook.algorithm;

public class StringToNumber {

    private static int ZERO_ASCII = (int) '0';
    private static int NEGATIVE_ASCII = (int) '-';

    public static int stringToNumber(String numStr) {
        if (numStr == null) {
            throw new NumberFormatException("Can't be null!");
        }

        boolean negative = false;

        int result = 0;

        int i = 0;
        if (!numStr.isEmpty()) {
            char first = numStr.charAt(0);
            if (first == NEGATIVE_ASCII) {
                negative = true;
                i++;
            }
        }

        for (int j = i; j < numStr.length(); j++) {
            result *= 10;
            int tmpAscii = (int) numStr.charAt(j);
            result += tmpAscii - ZERO_ASCII;
            if (tmpAscii - ZERO_ASCII < 0 || tmpAscii - ZERO_ASCII > 9) {
                throw new NumberFormatException("Too much!");
            }
        }

        if (negative && result > 0) {
            result = -result;
        }

        return result;
    }
}
