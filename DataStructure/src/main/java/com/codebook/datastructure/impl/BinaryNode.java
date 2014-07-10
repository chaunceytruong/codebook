package com.codebook.datastructure.impl;

/** 
 * BinaryNode is the basic node structure stored in unbalanced binary search trees
 */
public class BinaryNode {
    private Comparable mData;	// The data in the node
    private BinaryNode mLeft;	// Left child
    private BinaryNode mRight;	// Right child
     
    public BinaryNode(Comparable value) {
        this(value, null, null);
    }
 
    public BinaryNode(Comparable value, BinaryNode leftNode, BinaryNode rightNode) {
	this.mData = value;
	this.mLeft = leftNode;
	this.mRight = rightNode;
    }
    
    public Comparable getData() {
        return this.mData;
    }

    public void setData(Comparable data) {
        this.mData = data;
    }

    public BinaryNode getLeft() {
        return this.mLeft;
    }

    public void setLeft(BinaryNode left) {
        this.mLeft = left;
    }

    public BinaryNode getRight() {
        return this.mRight;
    }

    public void setRight(BinaryNode right) {
        this.mRight = right;
    }
}
