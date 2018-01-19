package com.codebook.algorithm;

import com.codebook.algorithm.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testIsBalancedWithBalancedExpressions() {
        Assert.assertTrue(StringUtils.isBalanced("{[()]}"));
        Assert.assertTrue(StringUtils.isBalanced("{{[[(())]]}}"));
    }

    @Test
    public void testIsBalancedWithUnBalancedExpressions() {
        Assert.assertFalse(StringUtils.isBalanced("{[(])}"));
    }

    @Test
    public void testEmptyString() {
        Assert.assertTrue(StringUtils.isBalanced(""));
    }

    @Test
    public void testRansomNote() {
        Assert.assertTrue(StringUtils.ransomNote("give me one grand today night", "give one grand today"));
    }

    @Test
    public void testRemoveDuplicates() {
        Assert.assertEquals("ab", StringUtils.removeDuplicates("abababab"));
    }
}
