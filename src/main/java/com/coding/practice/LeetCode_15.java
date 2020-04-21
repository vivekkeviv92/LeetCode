package com.coding.practice;

/*
MEDIUM
15. 3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.*;

public class LeetCode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = -1 * (nums[i] + nums[j]);
                if (map.containsKey(sum)) {
                    int val = map.get(sum);
                    if (val != i && val != j) {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(sum);
                        Collections.sort(res);
                        list.add(res);
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }
}
