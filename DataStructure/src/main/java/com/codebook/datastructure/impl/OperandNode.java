package com.codebook.datastructure.impl;

/**
 * Implements an Operand which can be used in an Arithmetic Expression Tree.
 */
public class OperandNode extends BinaryNode {

	/**
	 * Constructor accepts a single numeric value with no child nodes.
	 * 
	 * @param value Operand value. Valid values are bounded by the real domain.
	 */
	public OperandNode(Comparable value) {
		super(value);
	}

	/**
	 * Constructor accepts a single numeric value with two child nodes.
	 * 
	 * @param value     Operand value. Valid values are bounded by the real domain.
	 * @param leftNode  Left child node
	 * @param rightNode Right child node
	 */
	public OperandNode(Comparable value, BinaryNode leftNode, BinaryNode rightNode) {
		super(value, leftNode, rightNode);
	}

}
