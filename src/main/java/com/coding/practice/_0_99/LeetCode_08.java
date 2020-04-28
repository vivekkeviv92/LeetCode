package com.coding.practice._0_99;

/*
MEDIUM
8. String to Integer (atoi)

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Therefore INT_MIN (−231) is returned.
*/

public class LeetCode_08 {
    public int myAtoi(String str) {
        int sign = 1;
        long result = 0;
        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }

        char c = str.charAt(0);
        if (!(Character.isDigit(c) || c != '-' || c != '+')) {
            return 0;
        }

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == '-') {
                if (i != 0) {
                    return (int) result * sign;
                }
                sign = sign * -1;
            } else if (c == '+') {
                if (i != 0) {
                    return (int) result * sign;
                }
            } else if (Character.isDigit(c)) {
                result = result * 10 + (c - '0');
                if (result * sign > Integer.MAX_VALUE) {
                    result = Integer.MAX_VALUE;
                    return (int) result;
                } else if (result * sign < Integer.MIN_VALUE) {
                    result = Integer.MIN_VALUE;
                    return (int) result;
                }
            } else {
                return (int) result * sign;
            }
        }
        return (int) result * sign;
    }
}
