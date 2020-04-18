package com.coding.practice;

/*
MEDIUM
5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

public class LeetCode_05 {
    public boolean isPalin(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        String result = "";
        int[][] DP = new int[len + 1][len + 1];
        int max = 0;
        int index = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    DP[i + 1][j + 1] = DP[i][j] + 1;
                    if (DP[i + 1][j + 1] > max) {
                        index = i;
                        if (isPalin(s.substring(index - DP[i + 1][j + 1] + 1, index + 1))) {
                            max = DP[i + 1][j + 1];
                            result = s.substring(index - DP[i + 1][j + 1] + 1, index + 1);
                        }
                    }
                }
            }
        }
        return result;
    }
}
