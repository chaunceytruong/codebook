package com.codebook.algorithm.test;


import com.codebook.algorithm.Zillow;

import org.junit.Assert;
import org.junit.Test;


public class StringToLongTest {

    @Test
    public void testZero_WhereRadixIsDecimal() {
        Assert.assertEquals(0L, Zillow.stringToLong("0"));
    }

    @Test
    public void testPositiveValue_WhereRadixIsDecimal() {
        Assert.assertEquals(473L, Zillow.stringToLong("473"));
    }

    @Test
    public void testNegativeZero_WhereRadixIs10() {
        Assert.assertEquals(0L, Zillow.stringToLong("-0"));
    }

    @Test
    public void testNegativeMaxValue_WhereRadixIsNonDecimalAndNonBinary() {
        Assert.assertEquals(-255L, Zillow.stringToLong("-FF", 16));
    }

    @Test
    public void testPositiveValue_WhereRadixIsMin() {
        Assert.assertEquals(102L, Zillow.stringToLong("1100110", 2));
    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidValue_WhereValueIsNumeric() {
        Assert.assertEquals(-1, Zillow.stringToLong("99", 8));
    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidValue_WhereValueIsNonNumeric() {
        Assert.assertEquals(-1, Zillow.stringToLong("Hazelnut"));
    }

    @Test
    public void testPositiveValue_WhereRadixIsMax() {
        Assert.assertEquals(1356099454469L, Zillow.stringToLong("Hazelnut", 36));
    }

    @Test
    public void testMaxValue_WhereRadixIsDecimal() {
        Assert.assertEquals(Long.MAX_VALUE, Zillow.stringToLong(String.valueOf(Long.MAX_VALUE)));
    }

}
