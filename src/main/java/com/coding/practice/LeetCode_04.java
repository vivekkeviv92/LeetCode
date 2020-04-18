package com.coding.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
SEVERITY Hard
4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

public class LeetCode_04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        Collections.sort(list);
        int size = list.size();
        if (size % 2 == 1) {
            return list.get(size / 2) / 1.0;
        }
        return (list.get((size / 2) - 1) + list.get(size / 2)) / 2.0;
    }
}
