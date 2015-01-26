package com.codebook.datastructure.interfaces;

import com.codebook.datastructure.impl.BinaryNode;

import java.util.List;

/**
 * Interface definition for a Binary Tree.
 */
public interface BinaryTree {
	/**
	 * Get the top-most node in the Binary Tree.
	 * 
	 * @return Overall root of the Binary Tree
	 */
	public BinaryNode getOverallRoot();

	/**
	 * Insert specified value into the Binary Tree.
	 * 
	 * @param value
	 *            The value to be inserted @see Comparable
	 */
	public void insert(Comparable value);

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
	public List<BinaryNode> getInOrderList(BinaryNode overallRoot);

	/**
	 * Get a list of nodes from a pre-order Binary Tree traversal.
	 * 
	 * @return a list containing the sequence of values obtained from a
	 *         pre-order traversal of your binary tree
	 */
	public List<BinaryNode> getPreOrderList(BinaryNode overallRoot);

	/**
	 * Get a list of nodes from a post-order Binary Tree traversal.
	 * 
	 * @return a list containing the sequence of values obtained from a
	 *         post-order traversal of your binary tree
	 */
	public List<BinaryNode> getPostOrderList(BinaryNode overallRoot);

	public enum Traversal {
		BREADTH_FIRST, DEPTH_FIRST, IN_ORDER, PRE_ORDER, POST_ORDER
	}
}
