package com.codebook.datastructure.impl;

/**
 * Implements an Operand which can be used in an Arithmetic Expression Tree.
 * 
 * @param <T>
 *            Node type
 */
public class OperandNode<T extends Comparable<Number>> extends BinaryNode<T> {

	/**
	 * Constructor accepts a single numeric value with no child nodes.
	 * 
	 * @param value
	 *            Operand value. Valid values are bounded by the real domain.
	 */
	public OperandNode(T value) {
		super(value);
	}

	/**
	 * Constructor accepts a single numeric value with two child nodes.
	 * 
	 * @param value
	 *            Operand value. Valid values are bounded by the real domain.
	 * @param leftNode
	 *            Left child node
	 * @param rightNode
	 *            Right child node
	 */
	public OperandNode(T value, BinaryNode<T> leftNode, BinaryNode<T> rightNode) {
		super(value, leftNode, rightNode);
	}

}
