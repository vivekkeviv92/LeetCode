package com.coding.practice._200_299;

/*
MEDIUM
GOOGLE
AMAZON
200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

public class LeetCode_200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    markIslands(i, j, rows, cols, grid);
                }
            }
        }
        return count;
    }

    public boolean isValidIndex(int i, int j, int rows, int cols, char[][] grid) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        return grid[i][j] != '0';
    }

    public void markIslands(int i, int j, int rows, int cols, char[][] grid) {
        if (!isValidIndex(i, j, rows, cols, grid)) {
            return;
        }
        grid[i][j] = '0';
        markIslands(i + 1, j, rows, cols, grid);
        markIslands(i - 1, j, rows, cols, grid);
        markIslands(i, j + 1, rows, cols, grid);
        markIslands(i, j - 1, rows, cols, grid);
    }
}
