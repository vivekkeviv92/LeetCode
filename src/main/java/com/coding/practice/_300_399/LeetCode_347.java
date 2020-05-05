package com.coding.practice._300_399;

/*
MEDIUM
AMAZON
347. Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

import java.util.*;

public class LeetCode_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(e -> e.getValue())));
        for (Map.Entry<Integer, Integer> mapElement : map.entrySet()) {
            heap.add(mapElement);
        }

        for (int i = 1; i <= k; i++) {
            result.add(heap.remove().getKey());
        }
        return result;
    }
}
