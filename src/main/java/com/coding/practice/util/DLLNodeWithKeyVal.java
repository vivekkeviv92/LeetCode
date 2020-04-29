package com.coding.practice.util;

public class DLLNodeWithKeyVal {
    // Definition for a DLLNodeWithKeyVal.
    public int key;
    public int val;
    public DLLNodeWithKeyVal left;
    public DLLNodeWithKeyVal right;

    public DLLNodeWithKeyVal(int key, int val) {
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
