package com.coding.practice;

/*
MEDIUM
AMAZON
763. Partition Labels

A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_763 {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        process(S, result);
        return result;
    }

    public void process(String S, List<Integer> result) {
        if (S.length() < 1) {
            return;
        }
        int i = 0;
        int right = S.lastIndexOf(S.charAt(0));

        int max = right - 0 + 1;

        while (right < S.length() && i < right) {
            right = Math.max(right, S.lastIndexOf(S.charAt(i)));
            max = Math.max(max, right - 0 + 1);
            i++;
        }
        result.add(max);
        process(S.substring(right + 1), result);
    }
}
