package com.codebook.datastructure.interfaces;

import java.util.List;

import com.codebook.datastructure.impl.BinaryNode;

/**
 * Interface definition for a Binary Tree.
 */
@SuppressWarnings("rawtypes")
public interface BinaryTree<T extends Comparable> {
    /**
     * Get the top-most node in the Binary Tree.
     * 
     * @return Overall root of the Binary Tree
     */
    public BinaryNode<T> getOverallRoot();

    /**
     * Insert specified value into the Binary Tree.
     * 
     * @param value
     *            The value to be inserted @see Comparable
     */
    public void insert(T value);

    /**
     * Checks to see if the Binary Tree has any nodes.
     * 
     * @return true if there are one or more nodes, false otherwise
     */
    public boolean isEmpty();

    /**
     * Logically make the tree empty (no nodes).
     */
    public void makeEmpty();

    /**
     * Get the numbers of nodes in the tree.
     * 
     * @return The number of nodes in the tree
     */
    public int size();

    /**
     * Get a list of nodes from an in-order Binary Tree traversal.
     * 
     * @return a list containing the sequence of values obtained from an
     *         in-order traversal of your binary tree
     */
    public List<BinaryNode<T>> inOrderList(BinaryNode<T> overallRoot);

    /**
     * Get a list of nodes from a pre-order Binary Tree traversal.
     * 
     * @return a list containing the sequence of values obtained from a
     *         pre-order traversal of your binary tree
     */
    public List<BinaryNode<T>> preOrderList(BinaryNode<T> overallRoot);

    /**
     * Get a list of nodes from a post-order Binary Tree traversal.
     * 
     * @return a list containing the sequence of values obtained from a
     *         post-order traversal of your binary tree
     */
    public List<BinaryNode<T>> postOrderList(BinaryNode<T> overallRoot);

    public enum Traversal {
	BREADTH_FIRST, DEPTH_FIRST, IN_ORDER, PRE_ORDER, POST_ORDER
    }
}
