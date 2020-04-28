package com.coding.practice._0_99;

/*
MEDIUM
57. Insert Interval

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/

import java.util.LinkedList;
import java.util.List;

public class LeetCode_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (newInterval != null && newInterval[1] < interval[0]) {
                merged.add(newInterval);
                merged.add(interval);
                newInterval = null;
            } else if (newInterval != null && newInterval[0] > interval[1]) {
                merged.add(interval);
            } else if (newInterval != null) {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                merged.add(interval);
            }
        }
        if (newInterval != null) {
            merged.add(newInterval);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
