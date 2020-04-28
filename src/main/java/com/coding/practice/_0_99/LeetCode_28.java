package com.coding.practice._0_99;

/*
EASY
28. Implement strStr()

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/

public class LeetCode_28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        int lenH = haystack.length();
        int lenN = needle.length();

        int i = 0;
        while (i <= lenH - lenN) {
            int j = 0;
            while (j < lenN && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == lenN) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
