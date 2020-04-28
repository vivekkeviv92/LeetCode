package com.coding.practice;

/*
MEDIUM
678. Valid Parenthesis String

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True

Example 2:
Input: "(*)"
Output: True

Example 3:
Input: "(*))"
Output: True

Note:
The string size will be in the range [1, 100].
*/

import java.util.Stack;

public class LeetCode_678 {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                s1.push(i);
            } else if (c == '*') {
                s2.push(i);
            } else {
                if (!s1.isEmpty()) {
                    s1.pop();
                } else if (!s2.isEmpty()) {
                    s2.pop();
                } else {
                    return false;
                }
            }
        }
        // Now we have ( in s1 and * in s2
        // to match correctly value of s2.pop() should be greater than s1.pop()
        // as ) comes after (
        while (!s1.isEmpty() && !s2.isEmpty()) {
            Integer val = s2.pop();
            if (s1.peek() < val) {
                s1.pop();
            }

        }
        return s1.isEmpty();
    }
}
