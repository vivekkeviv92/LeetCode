package com.coding.practice._100_199;

/*
MEDIUM
143. Reorder List

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

import com.coding.practice.util.ListNode;

import java.util.Stack;

public class LeetCode_143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        int i = 0;
        int size = stack.size();
        cur = head;
        while (i < size / 2) {
            ListNode next = cur.next;
            cur.next = stack.pop();
            cur.next.next = next;
            cur = next;
            i++;
        }
        cur.next = null;
    }
}
