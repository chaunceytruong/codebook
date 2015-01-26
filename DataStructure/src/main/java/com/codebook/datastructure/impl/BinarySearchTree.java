package com.codebook.datastructure.impl;

import com.codebook.datastructure.base.AbstractBinaryTree;

/**
 * Implements an unbalanced binary search tree.
 */
public class BinarySearchTree extends AbstractBinaryTree {

	@Override
	protected BinaryNode insert(Comparable value, BinaryNode node) {
		if (node == null) {
			node = new BinaryNode(value, null, null);
		} else if (value.compareTo(node.getValue()) < 0) {
			node.setLeft((insert(value, node.getLeft())));
		} else if (value.compareTo(node.getValue()) > 0) {
			node.setRight(insert(value, node.getRight()));
		} else {
			// Duplicate, do nothing
            System.out.println("Ignoring duplicate item: " + value);
		}
		return node;
	}

	/**
	 * Removes nodes with the specified value from the tree.
	 * 
	 * @param value Target value to look for when removing nodes from the tree.
	 */
	public void remove(Comparable value) {
		mOverallRoot = remove(value, mOverallRoot);
	}

	/**
	 * Helper method to remove from a subtree.
	 * 
	 * @param value the item to remove.
	 * @param node  the node that overallRoots the tree.
     *
	 * @return the new mOverallRoot.
	 */
	private BinaryNode remove(Comparable value, BinaryNode node) {
		if (node == null) {
			// Item not found; do nothing
			return node;
		}
		if (value.compareTo(node.getValue()) < 0) {
			node.setLeft((remove(value, node.getLeft())));
		} else if (value.compareTo(node.getValue()) > 0) {
			node.setRight((remove(value, node.getRight())));
		} else if (node.getLeft() != null && node.getRight() != null) {
			// If two children, replace with either getLeft()/getRight()
			node.setValue(findMin(node.getRight()).getValue());
			node.setRight(remove(node.getValue(), node.getRight()));
		} else {
			// If only one child, replace it with child
			node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
		}
		return node;
	}

	public Comparable findMin() {
		return dataAt(findMin(mOverallRoot));
	}

	/**
	 * Helper method to find the smallest item in a subtree.
	 * 
	 * @param node  the node that overallRoots the tree.
     *
	 * @return node containing the smallest item.
	 */
	private BinaryNode findMin(BinaryNode node) {
		if (node == null) {
			return null;
		} else if (node.getLeft() == null) {
			return node;
		}
		return findMin(node.getLeft());
	}

	public Comparable findMax() {
		return dataAt(findMax(mOverallRoot));
	}

	/**
	 * Helper method to find the largest item in a subtree.
	 * 
	 * @param node  the node that overallRoots the tree.
     *
	 * @return node containing the largest item.
	 */
	protected BinaryNode findMax(BinaryNode node) {
		if (node != null) {
			while (node.getRight() != null) {
				node = node.getRight();
			}
		}
		return node;
	}

	public Comparable find(Comparable value) {
		return dataAt(find(value, mOverallRoot));
	}

	/**
	 * Helper method to find an item in a subtree.
	 * 
	 * @param value is item to search for.
	 * @param node  the node that overallRoots the tree.
     *
	 * @return node containing the matched item.
	 */
	private BinaryNode find(Comparable value, BinaryNode node) {
		if (node == null) {
			return null;
		}
		if (value.compareTo(node.getValue()) < 0) {
			return find(value, node.getLeft());
		} else if (value.compareTo(node.getValue()) > 0) {
			return find(value, node.getRight());
		} else {
			return node; // Match
		}
	}

}
