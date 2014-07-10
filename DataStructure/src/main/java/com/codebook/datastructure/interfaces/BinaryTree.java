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
public interface BinaryTree {
    void insert(Comparable value);
    void remove(Comparable value);
    Comparable find(Comparable value);
    Comparable findMin();
    Comparable findMax();
    boolean isEmpty();
    void makeEmpty();
    void printTree();
}
