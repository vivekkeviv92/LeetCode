package com.coding.practice;

/*
MEDIUM
92. Reverse Linked List II

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
*/

import com.coding.practice.util.ListNode;

public class LeetCode_92 {

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        int count = 1;
        while (cur != null && count < m) {
            prev = cur;
            cur = cur.next;
            count++;
        }

        ListNode start = cur;

        while (cur != null && count < n) {
            cur = cur.next;
            count++;
        }

        ListNode end = cur;
        ListNode endNext = end.next;
        end.next = null;
        if (prev == null) {
            head = reverse(start);
            start.next = endNext;
        } else {
            prev.next = reverse(start);
            start.next = endNext;
        }
        return head;
    }
}
