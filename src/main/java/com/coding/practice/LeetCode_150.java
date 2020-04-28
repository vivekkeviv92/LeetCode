package com.coding.practice;

/*
MEDIUM
150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
*/

import java.util.Stack;

public class LeetCode_150 {
    private static final String OPS = "+-*/";

    public void checkToEval(Stack<String> stack) {
        if (stack.size() < 3) {
            return;
        }
        if (!OPS.contains(stack.peek())) {
            return;
        }
        String op = stack.pop();
        if (OPS.contains(stack.peek())) {
            stack.push(op);
            return;
        }
        String var2 = stack.pop();
        if (OPS.contains(stack.peek())) {
            stack.push(op);
            stack.push(var2);
            return;
        }
        String var1 = stack.pop();
        String result = process(var1, var2, op);
        stack.push(result);
        checkToEval(stack);
    }

    public String process(String var1, String var2, String op) {
        int val1 = Integer.valueOf(var1);
        int val2 = Integer.valueOf(var2);
        int res = 0;
        switch (op) {
            case "+":
                res = val1 + val2;
                break;
            case "-":
                res = val1 - val2;
                break;
            case "*":
                res = val1 * val2;
                break;
            case "/":
                res = val1 / val2;
                break;
        }
        return String.valueOf(res);
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            stack.push(tokens[i]);
            checkToEval(stack);
        }
        return Integer.valueOf(stack.pop());
    }
}
