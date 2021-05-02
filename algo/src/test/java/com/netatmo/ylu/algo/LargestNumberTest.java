package com.netatmo.ylu.algo;


import org.junit.Assert;
import org.junit.Test;

public class LargestNumberTest {

    @Test
    public void testCase1() {
        LargestNumber solution = new LargestNumber();
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String actual = solution.largestNumber(nums);

        String expected = "9534330";
        Assert.assertEquals(expected, actual);
    }
}