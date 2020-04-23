package com.coding.practice;

/*
CLEVER
MEDIUM
977. Squares of a Sorted Array

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
*/

public class LeetCode_977 {
    // simple solution
/*    class Solution {
        public int[] sortedSquares(int[] A) {
            if (A == null || A.length == 0) {
                return A;
            }
            for (int i = 0; i < A.length; i++) {
                A[i] = A[i] * A[i];
            }
            Arrays.sort(A);
            return A;
        }
    }
*/
    // optimized solution
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int j = 0;
        while (j < len && A[j] < 0) {
            j++;
        }
        int i = j - 1;

        int[] res = new int[len];
        int k = 0;

        while (i >= 0 && j < len) {
            if (A[i] * A[i] < A[j] * A[j]) {
                res[k++] = A[i] * A[i];
                i--;
            } else {
                res[k++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            res[k++] = A[i] * A[i];
            i--;
        }
        while (j < len) {
            res[k++] = A[j] * A[j];
            j++;
        }
        return res;
    }
}
