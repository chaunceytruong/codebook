package com.codebook.datastructure.impl;

public class Operator<T extends Comparable<Character>> extends BinaryNode<T> {

    /**
     * @param value
     */
    public Operator(T value) {
	super(value);
    }

    /**
     * @param value
     * @param leftNode
     * @param rightNode
     */
    public Operator(T value, BinaryNode<T> leftNode, BinaryNode<T> rightNode) {
	super(value, leftNode, rightNode);
	
	if (leftNode == null || rightNode == null) {
	    throw new NullPointerException("Operator must have exactly two non-null children.");
	}
	
	if (!(leftNode instanceof Operand) || !(rightNode instanceof Operand)) {
	    throw new IllegalArgumentException("Children of Operator must be of type Operand!");
	}
    }

}
