package com.coding.practice._100_199;

/*
EASY
141. Linked List Cycle

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.

https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.

https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png

Follow up:

Can you solve it using O(1) (i.e. constant) memory?
*/

import com.coding.practice.util.ListNode;

public class LeetCode_141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
