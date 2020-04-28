package com.coding.practice;

/*
MEDIUM
384. Shuffle an Array

Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

import java.util.Random;

public class LeetCode_384 {
    int[] orig;
    int[] shuffled;
    Random rand;

    public LeetCode_384(int[] nums) {
        orig = new int[nums.length];
        shuffled = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            orig[i] = nums[i];
            shuffled[i] = nums[i];
        }
        rand = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return orig;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        shuffle(shuffled);
        return shuffled;
    }

    // Utility function to swap two elements A[i] and A[j] in the array
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Function to shuffle an array A[]
    private void shuffle(int[] A) {
        // read array from highest index to lowest
        for (int i = A.length - 1; i >= 1; i--) {
            // generate a random number j such that 0 <= j <= i
            int j = rand.nextInt(i + 1);
            // swap current element with randomly generated index
            swap(A, i, j);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

