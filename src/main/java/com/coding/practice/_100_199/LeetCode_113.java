package com.coding.practice._100_199;

/*
MEDIUM
113. Path Sum II
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

import com.coding.practice.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_113 {
    public void pathsumUtil(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(path));
        } else {
            pathsumUtil(root.left, sum - root.val, path, res);
            pathsumUtil(root.right, sum - root.val, path, res);
        }
        path.remove(path.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathsumUtil(root, sum, path, res);

        return res;
    }
}
