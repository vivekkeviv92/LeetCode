package com.coding.practice._0_99;

/*
EASY
7. Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

public class LeetCode_07 {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
        }
        x = Math.abs(x);
        long res = 0;
        while (x > 0) {
            int rem = x % 10;
            res = res * 10 + rem;
            x = x / 10;
        }
        res = res * sign;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }
}
