package com.coding.practice._100_199;

/*
MEDIUM
DYNAMIC PROGRAMMING
139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        /*
        if(s.length()==0) {
            return true;
        }
        boolean result = false;
        for(int i=0;i<s.length();i++) {
            if(wordDict.contains(s.substring(0,i+1))){
                result=wordBreak(s.substring(i+1), wordDict) || result;
            }
        }
        return result;
        */

        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
