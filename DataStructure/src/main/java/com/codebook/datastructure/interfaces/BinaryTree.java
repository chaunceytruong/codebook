package com.codebook.datastructure.interfaces;

/**
 *******************PUBLIC OPERATIONS*********************
 * void insert(x)	--> Insert x
 * void remove(x)       --> Remove x
 * Comparable find(x)   --> Return item that matches x
 * Comparable findMin() --> Return smallest item
 * Comparable findMax() --> Return largest item
 * boolean isEmpty()    --> Return true if empty; else false
 * void makeEmpty()     --> Remove all items
 * void printTree()     --> Print tree in sorted order
 */
public interface BinaryTree<T extends Comparable> {
    void insert(T value);
    void remove(T value);
    T find(T value);
    T findMin();
    T findMax();
    boolean isEmpty();
    void makeEmpty();
    void printTree();
}
