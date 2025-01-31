package com.coding.practice._0_99;

/*
MEDIUM
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order
and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
*/

import com.coding.practice.util.ListNode;

public class LeetCode_02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            head.next = node;
            head = head.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            head.next = node;
            head = head.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            head.next = node;
            head = head.next;

            l2 = l2.next;
        }

        if (carry == 1) {
            ListNode node = new ListNode(1);
            head.next = node;
        }

        return dummy.next;
    }
}

