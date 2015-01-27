package com.codebook.datastructure.base;

import com.codebook.datastructure.impl.BinaryNode;
import com.codebook.datastructure.interfaces.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Common base class for a Binary Tree (not to be confused with a Binary Search
 * Tree @see BinarySearchTree)
 */
public abstract class AbstractBinaryTree implements BinaryTree {
	/**
	 * The tree overall root.
	 */
	protected BinaryNode mOverallRoot;

	/**
	 * Construct an empty Binary Search Tree.
	 */
	public AbstractBinaryTree() {
		mOverallRoot = null;
	}

	@Override
	public BinaryNode getOverallRoot() {
		return mOverallRoot;
	}

	@Override
	public void insert(Comparable value) {
		mOverallRoot = insert(value, mOverallRoot);
	}

	/**
	 * Insert value into a sub-tree.
	 * 
	 * @param value the item to insert.
	 * @param node  the node that overallRoots the tree.
	 * @return      the new mOverallRoot.
	 */
	protected BinaryNode insert(Comparable value, BinaryNode node) {
		if (node == null) {
			node = new BinaryNode(value, null, null);
		} else if (node.getLeft() == null) {
			node.setLeft(insert(value, node.getLeft()));
		} else {
			node.setRight(insert(value, node.getRight()));
		}
		return node;
	}

	@Override
	public void makeEmpty() {
		mOverallRoot = null;
	}

	@Override
	public boolean isEmpty() {
		return mOverallRoot == null;
	}

	/**
	 * NUMBER OF NODES (SIZE)
	 * 
	 * @return the total number of nodes in the tree
	 */
	@Override
	public int size() {
		return size(mOverallRoot);
	}

	private int size(BinaryNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + size(root.getLeft()) + size(root.getRight());
		}
	}

	/**
	 * Get data field associated with the specified node.
	 * 
	 * @param node  the node
	 * @return the testdata field or null if node is null.
	 */
	protected Comparable dataAt(BinaryNode node) {
		return node == null ? null : node.getValue();
	}

	/**
	 * @see BinaryTree#getInOrderList(BinaryNode)
	 */
	@Override
	public List<BinaryNode> getInOrderList(BinaryNode overallRoot) {
		List<BinaryNode> inOrderTraversalList = new ArrayList<BinaryNode>();
        getInOrderList(overallRoot, inOrderTraversalList);
		return inOrderTraversalList;
	}

	private void getInOrderList(BinaryNode root, List<BinaryNode> result) {
		if (root != null) {
            getInOrderList(root.getLeft(), result);
			result.add(root);
            getInOrderList(root.getRight(), result);
		}
	}

	@Override
	public List<BinaryNode> getPreOrderList(BinaryNode overallRoot) {
		List<BinaryNode> preOrderTraversalList = new ArrayList<BinaryNode>();
        getPreOrderList(overallRoot, preOrderTraversalList);
		return preOrderTraversalList;
	}

	private void getPreOrderList(BinaryNode root, List<BinaryNode> result) {
		if (root != null) {
			result.add(root);
            getPreOrderList(root.getLeft(), result);
            getPreOrderList(root.getRight(), result);
		}
	}

	@Override
	public List<BinaryNode> getPostOrderList(BinaryNode overallRoot) {
		List<BinaryNode> postOrderTraversalList = new ArrayList<BinaryNode>();
        getPostOrderList(overallRoot, postOrderTraversalList);
		return postOrderTraversalList;
	}

	private void getPostOrderList(BinaryNode root, List<BinaryNode> result) {
		if (root != null) {
            getPostOrderList(root.getLeft(), result);
            getPostOrderList(root.getRight(), result);
			result.add(root);
		}
	}

}
