package com.codebook.datastructure.interfaces;

import com.codebook.datastructure.impl.BinaryNode;

import java.util.List;

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
@SuppressWarnings("rawtypes")
public interface BinaryTree<T extends Comparable> {
    void insert(T value);
    void remove(T value);
    T find(T value);
    T findMin();
    T findMax();
    boolean isEmpty();
    void makeEmpty();
    void printTraversal(Traversal traversal);
    
    /**
     * IN-ORDER TRAVERSAL
     * @return a list containing the sequence of values obtained from an in-order traversal
     * of your binary tree
     */
    public List<BinaryNode<T>> inOrderList(BinaryNode<T> overallRoot);
    
    /**
     * PRE-ORDER TRAVERSAL
     * @return a list containing the sequence of values obtained from a pre-order traversal
     * of your binary tree
     */
    public List<BinaryNode<T>> preOrderList(BinaryNode<T> overallRoot);
    
    /**
     * POST-ORDER TRAVERSAL
     * @return a list containing the sequence of values obtained from a post-order traversal
     * of your binary tree
     */
    public List<BinaryNode<T>> postOrderList(BinaryNode<T> overallRoot);
    
    public enum Traversal {
	IN_ORDER, PRE_ORDER, POST_ORDER
    }
}
