package com.coding.practice;

/*
EASY
830. Positions of Large Groups

In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.



Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]


Note:  1 <= S.length <= 1000
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        if (S == null || S.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> res = new ArrayList<>();
        int count = 1;
        int j = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(j) == S.charAt(i)) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    list.add(i - 1);
                    res.add(list);
                }
                j = i;
                count = 1;
            }
            if (i + 1 == S.length() && count >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(j);
                list.add(i);
                res.add(list);
            }
        }
        return res;
    }
}
