package com.coding.practice;

/*
MEDIUM
REVISE
153. Find Minimum in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
*/

public class LeetCode_153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int next = (mid + 1) % len;
            int prev = (mid - 1 + len) % len;
            if (nums[mid] < nums[next] && nums[mid] < nums[prev]) {
                return nums[mid];
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
