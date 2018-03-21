package com.codebook.datastructure;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> dict;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
        this.dict = new HashMap<>();
    }

    public int get(int key) {
        if (dict.containsKey(key)) {
            Node node = dict.get(key);
            remove(node);
            add(node);
            return dict.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (dict.containsKey(key)) {
            remove(dict.get(key));
        }
        Node node = new Node(key, value);
        add(node);
        dict.put(key, node);
        if (dict.size() > capacity) {
            node = head.next;
            remove(node);
            dict.remove(node.key);
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void add(Node node) {
        Node prev = this.tail.prev;
        prev.next = node;
        this.tail.prev = node;
        node.prev = prev;
        node.next = this.tail;
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}


