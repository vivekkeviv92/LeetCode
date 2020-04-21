package com.coding.practice;

/*
EASY
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

import com.coding.practice.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy= new ListNode(-1);
        ListNode head=dummy;

        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparing(e -> e.val));
        if(l1!=null)
            q.add(l1);
        if(l2!=null)
            q.add(l2);

        while(!q.isEmpty()) {
            ListNode node= q.remove();
            head.next=node;
            head=head.next;
            if(node.next!=null) {
                q.add(node.next);
            }
        }
        return dummy.next;
    }
}
