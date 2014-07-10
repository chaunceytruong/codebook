package com.codebook.datastructure.impl;

import com.codebook.datastructure.base.AbstractBinaryTree;

/**
 * Implements an unbalanced binary search tree.
 */
@SuppressWarnings("rawtypes")
public class BinarySearchTree<T extends Comparable> extends AbstractBinaryTree<T> {
    
    @Override
    @SuppressWarnings("unchecked")
    protected BinaryNode<T> insert(T value, BinaryNode<T> node) {
        if (node == null) {
            node = new BinaryNode<T>(value, null, null);
        } else if(value.compareTo(node.getData()) < 0) {
            node.setLeft((insert(value, node.getLeft())));
        } else if(value.compareTo(node.getData()) > 0) {
            node.setRight(insert(value, node.getRight()));
        } else {
            // Duplicate; do nothing
        }
        return node;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    protected BinaryNode<T> remove(T value, BinaryNode<T> node) {
        if(node == null) {
            // Item not found; do nothing
            return node;                                       
        } if (value.compareTo(node.getData()) < 0) {
            node.setLeft((remove(value, node.getLeft())));
        } else if (value.compareTo(node.getData()) > 0) {
            node.setRight((remove(value, node.getRight())));
        } else if (node.getLeft() != null && node.getRight() != null) {         
            // If two children, replace with either getLeft()/getRight()
            node.setData(findMin(node.getRight()).getData());
            node.setRight(remove(node.getData(), node.getRight()));
        } else {
            // If only one child, replace it with child
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        }
        return node;
    }

    @Override
    protected BinaryNode<T> findMin(BinaryNode<T> node) {
        if(node == null) {
            return null;
        } else if(node.getLeft() == null) {
            return node;
        }
        return findMin(node.getLeft());
    }

    @Override
    protected BinaryNode<T> findMax(BinaryNode<T> node) {
        if(node != null) {
            while(node.getRight() != null) {
                node = node.getRight();
            }
        }
        return node;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected BinaryNode<T> find(T value, BinaryNode<T> node) {
        if(node == null) {
            return null;
        } if(value.compareTo(node.getData()) < 0) {
            return find(value, node.getLeft());
        } else if(value.compareTo(node.getData()) > 0) {
            return find(value, node.getRight());
        } else {
            return node;                                       // Match
        }
    }
}
