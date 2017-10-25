package com.codebook.algorithm.test;

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
}
