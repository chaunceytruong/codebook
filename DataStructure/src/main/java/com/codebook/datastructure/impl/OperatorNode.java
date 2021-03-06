package com.codebook.datastructure.impl;

/**
 * Implements an Operator which can be used in an Arithmetic Expression Tree.
 */
public class OperatorNode extends BinaryNode {

	/**
	 * Constructor accepts a single character value with no child nodes.
	 * 
	 * @param value Operator value. Valid values include: +,-,*,/,^
	 */
	public OperatorNode(Comparable value) {
		super(value);
	}

	/**
	 * Constructor accepts a single numeric value with two child nodes.
	 * 
	 * @param value     Operator value. Valid values include: +,-,*,/,^
	 * @param leftNode  Left child node
	 * @param rightNode Right child node
	 * 
	 * @throws NullPointerException     Operator must have exactly two non-null children.
	 * 
	 * @throws IllegalArgumentException Children of Operator must be of type Operand. @see Operand
	 */
	public OperatorNode(Comparable value, BinaryNode leftNode, BinaryNode rightNode) {
		super(value, leftNode, rightNode);

		if (leftNode == null || rightNode == null) {
			throw new NullPointerException(
					"Operator must have exactly two non-null children.");
		}

		if (!(leftNode instanceof OperandNode)
				|| !(rightNode instanceof OperandNode)) {
			throw new IllegalArgumentException(
					"Children of Operator must be of type Operand.");
		}
	}

}
