package com.coding.practice;

/*
MEDIUM
64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum
of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/

public class LeetCode_64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] DP = new int[grid.length][grid[0].length];
        DP[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            DP[0][i] = DP[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            DP[i][0] = DP[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                DP[i][j] = Math.min(DP[i - 1][j], DP[i][j - 1]) + grid[i][j];
            }
        }
        return DP[grid.length - 1][grid[0].length - 1];
    }
}
