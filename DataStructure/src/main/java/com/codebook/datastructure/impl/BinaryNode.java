package com.codebook.datastructure.impl;

/**
 * Implementation of the basic node structure stored in Binary Trees.
 */
public class BinaryNode {
	protected Comparable mValue;
	protected BinaryNode mLeft;
	protected BinaryNode mRight;

	/**
	 * Constructor accepts a single value with no children nodes.
	 * 
	 * @param value     Node value
	 */
	public BinaryNode(Comparable value) {
		this(value, null, null);
	}

	/**
	 * Constructor accepts a single value with two children nodes.
	 * 
	 * @param value     Node value
	 * @param leftNode  Left child node
	 * @param rightNode Right child node
	 */
	public BinaryNode(Comparable value, BinaryNode leftNode, BinaryNode rightNode) {
        this.mValue = value;
		this.mLeft = leftNode;
		this.mRight = rightNode;
        System.out.println("Created a new BinaryNode with value: " + toString());
	}

	/**
	 * Get the node value.
	 * 
	 * @return The node value
	 */
	public Comparable getValue() {
		return this.mValue;
	}

	/**
	 * Set the node value.
	 */
	public void setValue(Comparable data) {
		this.mValue = data;
	}

	/**
	 * Get the left child of node.
	 * 
	 * @return Left child node
	 */
	public BinaryNode getLeft() {
		return this.mLeft;
	}

	/**
	 * Set the left child.
	 * 
	 * @param left  Node child
	 */
	public void setLeft(BinaryNode left) {
		this.mLeft = left;
	}

	/**
	 * Get the right child of node.
	 * 
	 * @return Right child node
	 */
	public BinaryNode getRight() {
		return this.mRight;
	}

	/**
	 * Set the right child.
	 * 
	 * @param right Node child
	 */
	public void setRight(BinaryNode right) {
		this.mRight = right;
	}

	/**
	 * Check if the node is a leaf node.
	 * 
	 * @return True if node is a leaf (left and right children node are null), false otherwise.
	 */
	public boolean isLeaf() {
		return this.mLeft == null && this.mRight == null;
	}

	@Override
	public String toString() {
        return mValue.toString();
	}
}
