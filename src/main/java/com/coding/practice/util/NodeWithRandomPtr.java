package com.coding.practice.util;

public class NodeWithRandomPtr {
    // Definition for a NodeWithRandomPtr.
    public int val;
    public NodeWithRandomPtr next;
    public NodeWithRandomPtr random;

    public NodeWithRandomPtr(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
