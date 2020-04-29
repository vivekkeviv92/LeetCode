package com.coding.practice._100_199;

/*
IMPORTANT
MEDIUM
146. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /// capacity // );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
*/

import com.coding.practice.util.DLLNodeWithKeyVal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode_146 {
    class LRUCache {
        Map<Integer, DLLNodeWithKeyVal> map;
        int size;
        LinkedList<DLLNodeWithKeyVal> list;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new LinkedList<>();
            size = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            DLLNodeWithKeyVal node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.val;
        }

        public void put(int key, int value) {
            DLLNodeWithKeyVal node = new DLLNodeWithKeyVal(key, value);
            if (map.containsKey(key)) {
                DLLNodeWithKeyVal old = map.get(key);
                list.remove(old);
                list.addFirst(node);
                map.put(key, node);
                return;
            }
            if (map.size() < size) {
                map.put(key, node);
            } else {
                DLLNodeWithKeyVal last = list.getLast();
                list.removeLast();
                map.remove(last.key);
                map.put(key, node);
            }
            list.addFirst(node);
        }
    }
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
