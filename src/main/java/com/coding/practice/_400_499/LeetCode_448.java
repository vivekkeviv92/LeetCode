package com.coding.practice._400_499;

/*
CLEVER
448. Find All Numbers Disappeared in an Array

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_448 {
    /*
    Algorithm
    Iterate over the input array one element at a time.
    For each element nums[i], mark the element at the corresponding location negative if it's not already marked so i.e. nums[\; nums[i] \;- 1\;] \times -1nums[nums[i]−1]×−1 .
    Now, loop over numbers from 1 \cdots N1⋯N and for each number check if nums[j] is negative. If it is negative, that means we've seen this number somewhere in the array.
    Add all the numbers to the resultant array which don't have their corresponding locations marked as negative in the original array.
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
