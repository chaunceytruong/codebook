package com.codebook.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class StringToNumberTest {

    @Test
    public void testZero() {
        Assert.assertEquals(0, StringToNumber.stringToNumber("0"));
    }

    @Test
    public void testNormalNumber() {
        Assert.assertEquals(473, StringToNumber.stringToNumber("473"));
    }

    @Test
    public void testNegativeZero() {
        Assert.assertEquals(0, StringToNumber.stringToNumber("-0"));
    }

    @Test
    public void testMaxValue() {
        Assert.assertEquals(2147483647, StringToNumber.stringToNumber("2147483647"));
    }

    @Test
    public void testNegativeMaxValue() {
        Assert.assertEquals(-2147483647, StringToNumber.stringToNumber("-2147483647"));
    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidNumber() {
        StringToNumber.stringToNumber("KONA");
    }

    @Test
    public void testLeadingZeroes() {
        Assert.assertEquals(123, StringToNumber.stringToNumber("00000123"));
    }
}
