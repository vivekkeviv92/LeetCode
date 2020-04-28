package com.coding.practice._100_199;

/*
TODO
MEDIUM
114. Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/

import com.coding.practice.util.TreeNode;

public class LeetCode_114 {
    public void flatten(TreeNode root) {

        // Handle the null scenario
        if (root == null) {
            return;
        }

        TreeNode node = root;

        while (node != null) {

            // If the node has a left child
            if (node.left != null) {

                // Find the rightmost node
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // rewire the connections
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            // move on to the right side of the tree
            node = node.right;
        }
    }
}
