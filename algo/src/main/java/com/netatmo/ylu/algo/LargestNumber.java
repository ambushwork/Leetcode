package com.netatmo.ylu.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {

    //wrong solution, failed with case "[34323,3432]"
    public String largestNumber0(int[] nums) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] lens = new int[nums.length];
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int length = String.valueOf(nums[i]).length();//catch length of each number
            maxLength = Math.max(maxLength, length);
            lens[i] = length;
        }
        for (int i = 0; i < nums.length; i++) {
            int cursor = lens[i];
            int newNum = nums[i];

            int lastDig = nums[i] % 10;
            while (cursor < maxLength) {
                newNum *= 10;
                newNum += lastDig;
                cursor++;
            }
            nums[i] = newNum;
            map.put(String.valueOf(newNum), lens[i]);
        }
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = nums.length -1; i >= 0; i--) {
            String num = String.valueOf(nums[i]);
            sb.append(num, 0, map.get(num));
        }
        return sb.toString();

    }

    public String largestNumber(int[] num) {
        if(num == null || num.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[num.length];
        for(int i = 0; i < num.length; i++)
            s_num[i] = String.valueOf(num[i]);

        // Comparator to decide which string should come first in concatenation
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1); // reverse order here, so we can do append() later
            }
        };

        Arrays.sort(s_num, comp);
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: s_num)
            sb.append(s);

        return sb.toString();

    }
}
