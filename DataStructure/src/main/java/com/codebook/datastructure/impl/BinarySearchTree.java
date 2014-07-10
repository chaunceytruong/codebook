package com.codebook.datastructure.impl;

import com.codebook.datastructure.interfaces.BinaryTree;

/**
 * Implements an unbalanced binary search tree.
 */
public class BinarySearchTree<T extends Comparable> implements BinaryTree<T> {
    /** 
     * The tree overall root.
     */
    private BinaryNode<T> mOverallRoot;
     
    /**
     * Construct an empty Binary Search Tree.
     */
    public BinarySearchTree() {
        mOverallRoot = null;
    }
 
    public BinaryNode<T> getOverallRoot() {
        return mOverallRoot;
    }
 
    @Override
    public void insert(T value) {
        mOverallRoot = insert(value, mOverallRoot);
    }
 
    @Override
    public void remove(T value) {
        mOverallRoot = remove(value, mOverallRoot);
    }
 
    @Override
    public T findMin() {
        return dataAt(findMin(mOverallRoot));
    }
 
    @Override
    public T findMax() {
        return dataAt(findMax(mOverallRoot));
    }
 
    @Override
    public T find(T value) {
        return dataAt(find(value, mOverallRoot));
    }
 
    @Override
    public void makeEmpty() {
        mOverallRoot = null;
    }
 
    @Override
    public boolean isEmpty() {
        return mOverallRoot == null;
    }
 
    @Override
    public void printTree() {
        if(isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(mOverallRoot);
        }
    }
 
    /**
     * Private helper method to get data field.
     * @param node the node.
     * @return the data field or null if node is null.
     */
    private T dataAt(BinaryNode<T> node) {
        return node == null ? null : node.getData();
    }
 
    /**
     * Private helper method to insert into a subtree.
     * @param value the item to insert.
     * @param node the node that overallRoots the tree.
     * @return the new mOverallRoot.
     */
    @SuppressWarnings("unchecked")
    private BinaryNode<T> insert(T value, BinaryNode<T> node) {
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
 
    /**
     * Private helper method to remove from a subtree.
     * @param value the item to remove.
     * @param node the node that overallRoots the tree.
     * @return the new mOverallRoot.
     */
    @SuppressWarnings("unchecked")
    private BinaryNode<T> remove(T value, BinaryNode<T> node) {
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
 
    /**
     * Private helper method to find the smallest item in a subtree.
     * @param node the node that overallRoots the tree.
     * @return node containing the smallest item.
     */
    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if(node == null) {
            return null;
        } else if(node.getLeft() == null) {
            return node;
        }
        return findMin(node.getLeft());
    }
 
    /**
     * Private helper method to find the largest item in a subtree.
     * @param node the node that overallRoots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if(node != null) {
            while(node.getRight() != null) {
                node = node.getRight();
            }
        }
        return node;
    }
 
    /**
     * Private helper method to find an item in a subtree.
     * @param value is item to search for.
     * @param node the node that overallRoots the tree.
     * @return node containing the matched item.
     */
    @SuppressWarnings("unchecked")
    private BinaryNode<T> find(T value, BinaryNode<T> node) {
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
 
    /**
     * Private helper method to print a subtree in sorted order.
     * @param node the node that overallRoots the tree.
     */
    private void printTree(BinaryNode<T> node) {
        if(node != null) {
            printTree(node.getLeft());
            System.out.println(node.getData());
            printTree(node.getRight());
        }
    }
}
