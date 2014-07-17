package com.codebook.datastructure.impl;

import com.codebook.datastructure.base.AbstractBinaryTree;

/**
 * Implements an Arithmetic Expression Tree.
 * 
 * @param <T>
 *            Node type
 */
@SuppressWarnings("rawtypes")
public class ArithmeticExpressionTree<T extends Comparable> extends
	AbstractBinaryTree<T> {

    /**
     * Evaluate the expression and return its value. All the work is done in the
     * private recursive method.
     * 
     * @return the value of the expression tree.
     */
    public double evaluate() {
	return mOverallRoot == null ? 0.0 : evaluate(mOverallRoot);
    }

    /**
     * Evaluate the expression: for internal nodes, this amounts to a in-order
     * traversal, in which the processing is doing the actual arithmetic. For
     * isLeaf nodes, it is simply the value of the node.
     * 
     * @param node
     *            Node to perform the next calculation on
     * @return The result after calculating the node.
     */
    private double evaluate(BinaryNode<T> node) {
	// Value to be returned
	double result;

	if (node.isLeaf()) {
	    // Just get the value of the isLeaf
	    result = (Double) node.getValue();

	} else {
	    // We've got work to do, evaluating the expression
	    // Capture the values of the left and right subexpressions

	    double left = evaluate(node.getLeft());
	    char operator = (Character) node.getValue();
	    double right = evaluate(node.getRight());

	    // Do the arithmetic, based on the operator
	    switch (operator) {
	    case '-':
		result = left - right;
		break;
	    case '*':
		result = left * right;
		break;
	    case '/':
		result = left / right;
		break;
	    case '^':
		result = Math.pow(left, right);
		break;
	    case '+':
		result = left + right;
		break;
	    default:
		throw new IllegalArgumentException(
			"Unrecognized operator " + operator + ".");
	    }
	}
	// Return either the leaf's value or the one we just calculated.
	return result;
    }
}
