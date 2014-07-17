package com.codebook.datastructure.impl;

/**
 * Implementation of the basic node structure stored in Binary Trees.
 * 
 * @param <T>
 *            Node type
 */
@SuppressWarnings("rawtypes")
public class BinaryNode<T extends Comparable> {
    protected T mValue;
    protected BinaryNode<T> mLeft;
    protected BinaryNode<T> mRight;

    /**
     * Constructor accepts a single value with no child nodes.
     * 
     * @param value
     *            Node value
     */
    public BinaryNode(T value) {
	this(value, null, null);
    }

    /**
     * Constructor accepts a single value with two child nodes.
     * 
     * @param value
     *            Node value
     * @param leftNode
     *            Left child node
     * @param rightNode
     *            Right child node
     */
    public BinaryNode(T value, BinaryNode<T> leftNode,
	    BinaryNode<T> rightNode) {
	this.mValue = value;
	this.mLeft = leftNode;
	this.mRight = rightNode;
    }

    /**
     * Get the node value.
     * 
     * @return The node value
     */
    public T getValue() {
	return this.mValue;
    }

    /**
     * Set the node value.
     */
    public void setValue(T data) {
	this.mValue = data;
    }

    /**
     * Get the left child of node.
     * 
     * @return Left child node
     */
    public BinaryNode<T> getLeft() {
	return this.mLeft;
    }

    /**
     * Set the left child.
     * 
     * @param left
     *            Node child
     */
    public void setLeft(BinaryNode<T> left) {
	this.mLeft = left;
    }

    /**
     * Get the right child of node.
     * 
     * @return Right child node
     */
    public BinaryNode<T> getRight() {
	return this.mRight;
    }

    /**
     * Set the right child.
     * 
     * @param right
     *            Node child
     */
    public void setRight(BinaryNode<T> right) {
	this.mRight = right;
    }

    /**
     * Check if the node is a leaf node.
     * 
     * @return true if node is a leaf (left and right children node are null),
     *         false otherwise
     */
    public boolean isLeaf() {
	return this.mLeft == null && this.mRight == null;
    }

    @Override
    public String toString() {
	StringBuffer sb = new StringBuffer();
	sb.append(mValue);
	return sb.toString();
    }
}
