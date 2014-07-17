package com.codebook.datastructure.impl;


public class Operand<T extends Comparable<Double>> extends BinaryNode<T> {

    /**
     * @param value
     */
    public Operand(T value) {
	super(value);
    }

    /**
     * @param value
     * @param leftNode
     * @param rightNode
     */
    public Operand(T value, BinaryNode<T> leftNode, BinaryNode<T> rightNode) {
	super(value, leftNode, rightNode);
    }
    
}
