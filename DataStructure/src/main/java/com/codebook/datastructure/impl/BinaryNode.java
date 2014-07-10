package com.codebook.datastructure.impl;

/** 
 * BinaryNode is the basic node structure stored in unbalanced binary search trees
 */
public class BinaryNode<T extends Comparable> {
    private T mData;	// The data in the node
    private BinaryNode<T> mLeft;	// Left child
    private BinaryNode<T> mRight;	// Right child
     
    public BinaryNode(T value) {
        this(value, null, null);
    }
 
    public BinaryNode(T value, BinaryNode<T> leftNode, BinaryNode<T> rightNode) {
	this.mData = value;
	this.mLeft = leftNode;
	this.mRight = rightNode;
    }
    
    public T getData() {
        return this.mData;
    }

    public void setData(T data) {
        this.mData = data;
    }

    public BinaryNode<T> getLeft() {
        return this.mLeft;
    }

    public void setLeft(BinaryNode<T> left) {
        this.mLeft = left;
    }

    public BinaryNode<T> getRight() {
        return this.mRight;
    }

    public void setRight(BinaryNode<T> right) {
        this.mRight = right;
    }
}
