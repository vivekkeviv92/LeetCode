package com.coding.practice;

/*
MEDIUM
159. Longest Substring with At Most Two Distinct Characters

Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
*/

import java.util.HashMap;
import java.util.Map;

public class LeetCode_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0, max = Integer.MIN_VALUE;

        for (high = 0; high < s.length(); high++) {
            char c = s.charAt(high);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            while (map.size() > 2) {
                char cLow = s.charAt(low);
                map.put(cLow, map.get(cLow) - 1);
                if (map.get(cLow) == 0) {
                    map.remove(cLow);
                }
                low++;
            }
            max = Math.max(max, high - low + 1);
        }
        return max;
    }
}
