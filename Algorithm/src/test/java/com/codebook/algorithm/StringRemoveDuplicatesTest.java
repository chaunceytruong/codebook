package com.codebook.algorithm;


import com.codebook.algorithm.StringUtils;

import org.junit.Assert;
import org.junit.Test;

public class StringRemoveDuplicatesTest {

    @Test
    public void testNoDuplicates() {
        Assert.assertEquals("abcd", StringUtils.removeDuplicates("abcd"));
    }

    @Test
    public void testAllDuplicates() {
        Assert.assertEquals("a", StringUtils.removeDuplicates("aaaa"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullString() {
        Assert.assertEquals(null, StringUtils.removeDuplicates(null));
    }

    @Test
    public void testEmptyString() {
        Assert.assertEquals("", StringUtils.removeDuplicates(""));
    }

    @Test
    public void testContinuousDuplicates() {
        Assert.assertEquals("ab", StringUtils.removeDuplicates("aaabbb"));
    }

    @Test
    public void testNonContinuousDuplicates() {
        Assert.assertEquals("ab", StringUtils.removeDuplicates("abababa"));
    }
}
