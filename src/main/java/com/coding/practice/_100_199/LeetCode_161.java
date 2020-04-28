package com.coding.practice._100_199;

/*
MEDIUM
PREMIUM
161. One Edit Distance

Given two strings s and t, determine if they are both one edit distance apart.

Note:

There are 3 possibilities to satisfy one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
*/

public class LeetCode_161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        if (s.length() == t.length()) {
            return isOneEditDistanceEqualLenght(s, t);
        } else {
            return isOneEditDistanceUnequalLenght(s, t);
        }
    }

    boolean isOneEditDistanceEqualLenght(String s, String t) {
        boolean flag = false;
        int len = s.length();
        int index = 0;
        while (index < len) {
            if (s.charAt(index) != t.charAt(index)) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
            index++;
        }
        return true;
    }

    boolean isOneEditDistanceUnequalLenght(String s, String t) {
        if (t.length() > s.length()) {
            String temp = t;
            t = s;
            s = temp;
        }
        if (s.length() - t.length() > 1) {
            return false;
        }
        boolean flag = false;
        int indexS = 0;
        int indexT = 0;
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) != t.charAt(indexT)) {
                if (flag) {
                    return false;
                } else {
                    indexS++;
                    flag = true;
                }
            } else {
                indexS++;
                indexT++;
            }
        }
        return true;
    }
}
