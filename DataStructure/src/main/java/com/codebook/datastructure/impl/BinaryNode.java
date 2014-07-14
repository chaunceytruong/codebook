package com.codebook.datastructure.impl;

/** 
 * BinaryNode is the basic node structure stored in unbalanced binary search trees
 */
@SuppressWarnings("rawtypes")
public class BinaryNode<T extends Comparable> {
    private T mValue;
    private BinaryNode<T> mLeft;
    private BinaryNode<T> mRight;
     
    public BinaryNode(T value) {
        this(value, null, null);
    }
 
    public BinaryNode(T value, BinaryNode<T> leftNode, BinaryNode<T> rightNode) {
	this.mValue = value;
	this.mLeft = leftNode;
	this.mRight = rightNode;
    }
    
    public T getValue() {
        return this.mValue;
    }

    public void setValue(T data) {
        this.mValue = data;
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
    
    public boolean isLeaf() {
	return this.mLeft == null && this.mRight == null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuffer sb = new StringBuffer();
	sb.append(mValue);
	return sb.toString();
    }
}
