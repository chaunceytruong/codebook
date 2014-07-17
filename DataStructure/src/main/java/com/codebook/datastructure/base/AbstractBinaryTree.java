package com.codebook.datastructure.base;

import com.codebook.datastructure.impl.BinaryNode;
import com.codebook.datastructure.interfaces.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Common base class for a Binary Tree (not to be confused with a Binary Search
 * Tree @see BinarySearchTree)
 * 
 * @param <T>
 *            Node type
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractBinaryTree<T extends Comparable> implements
	BinaryTree<T> {
    /**
     * The tree overall root.
     */
    protected BinaryNode<T> mOverallRoot;

    /**
     * Construct an empty Binary Search Tree.
     */
    public AbstractBinaryTree() {
	mOverallRoot = null;
    }

    @Override
    public BinaryNode<T> getOverallRoot() {
	return mOverallRoot;
    }

    @Override
    public void insert(T value) {
	mOverallRoot = insert(value, mOverallRoot);
    }

    /**
     * Insert value into a sub-tree.
     * 
     * @param value
     *            the item to insert.
     * @param node
     *            the node that overallRoots the tree.
     * @return the new mOverallRoot.
     */
    protected BinaryNode<T> insert(T value, BinaryNode<T> node) {
	if (node == null) {
	    node = new BinaryNode<T>(value, null, null);
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
     * Get data field associated with the specified node.
     *
     * @param node
     *            the node
     * @return the data field or null if node is null.
     */
    protected T dataAt(BinaryNode<T> node) {
	return node == null ? null : node.getValue();
    }

    /**
     * @see BinaryTree#inOrderList(BinaryNode)
     */
    @Override
    public List<BinaryNode<T>> inOrderList(BinaryNode<T> overallRoot) {
	List<BinaryNode<T>> inOrderTraversalList = new ArrayList<
		BinaryNode<T>>();
	inOrderList(overallRoot, inOrderTraversalList);
	return inOrderTraversalList;
    }

    private void inOrderList(BinaryNode<T> root, List<BinaryNode<T>> result) {
	if (root != null) {
	    inOrderList(root.getLeft(), result);
	    result.add(root);
	    inOrderList(root.getRight(), result);
	}
    }

    @Override
    public List<BinaryNode<T>> preOrderList(BinaryNode<T> overallRoot) {
	List<BinaryNode<T>> preOrderTraversalList = new ArrayList<
		BinaryNode<T>>();
	preOrderList(overallRoot, preOrderTraversalList);
	return preOrderTraversalList;
    }

    private void preOrderList(BinaryNode<T> root, List<BinaryNode<T>> result) {
	if (root != null) {
	    result.add(root);
	    preOrderList(root.getLeft(), result);
	    preOrderList(root.getRight(), result);
	}
    }

    @Override
    public List<BinaryNode<T>> postOrderList(BinaryNode<T> overallRoot) {
	List<BinaryNode<T>> postOrderTraversalList = new ArrayList<
		BinaryNode<T>>();
	postOrderList(overallRoot, postOrderTraversalList);
	return postOrderTraversalList;
    }

    private void postOrderList(BinaryNode<T> root, List<BinaryNode<T>> result) {
	if (root != null) {
	    preOrderList(root.getLeft(), result);
	    preOrderList(root.getRight(), result);
	    result.add(root);
	}
    }
}
