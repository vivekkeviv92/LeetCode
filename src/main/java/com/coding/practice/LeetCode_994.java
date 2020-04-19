package com.coding.practice;

/*
MEDIUM
AMAZON
994. Rotting Oranges

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:
https://assets.leetcode.com/uploads/2019/02/16/oranges.png
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_994 {
    private static final int ORANGE = 1;
    private static final int ROTTEN = 2;
    private static final int EMPTY = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    public int orangesRotting(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return 0;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == ROTTEN) {
                    q.add(new int[]{row, col});
                }
            }
        }
        q.add(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
        int count = -1;
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            if (row == Integer.MIN_VALUE && col == Integer.MIN_VALUE) {
                count++;
                if (!q.isEmpty()) {
                    q.add(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
                    continue;
                }
            }
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != ORANGE) {
                    continue;
                }
                rooms[r][c] = 2;
                q.add(new int[]{r, c});
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 1) {
                    count = -1;
                    return count;
                }
            }
        }
        return count;
    }
}
