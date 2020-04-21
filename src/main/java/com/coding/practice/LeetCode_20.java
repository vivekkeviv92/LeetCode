package com.coding.practice;

/*
EASY
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

import java.util.Stack;

public class LeetCode_20 {
    public boolean isOpeningParentheses(char c) {
        if (c == '{' || c == '[' || c == '(') {
            return true;
        }
        return false;
    }

    public boolean isClosingParentheses(char c) {
        if (c == '}' || c == ']' || c == ')') {
            return true;
        }
        return false;
    }

    public boolean validate(char openP, char closeP) {
        if (openP == '{' && closeP == '}') {
            return true;
        } else if (openP == '[' && closeP == ']') {
            return true;
        } else if (openP == '(' && closeP == ')') {
            return true;
        }
        return false;
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isOpeningParentheses(c)) {
                stack.push(c);
            } else if (isClosingParentheses(c)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char openP = stack.pop();
                    if (validate(openP, c) == false) {
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
