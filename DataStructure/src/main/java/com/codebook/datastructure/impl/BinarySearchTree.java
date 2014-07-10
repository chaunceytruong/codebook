package com.codebook.datastructure.impl;

import com.codebook.datastructure.interfaces.BinaryTree;

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 */
public class BinarySearchTree implements BinaryTree {
    /** The tree mOverallRoot. */
    private BinaryNode mOverallRoot;
     
    /**
     * Construct the tree.
     */
    public BinarySearchTree() {
        mOverallRoot = null;
    }
 
    public BinaryNode getOverallRoot() {
        return mOverallRoot;
    }
 
    @Override
    public void insert(Comparable x) {
        mOverallRoot = insert(x, mOverallRoot);
    }
 
    @Override
    public void remove(Comparable x) {
        mOverallRoot = remove(x, mOverallRoot);
    }
 
    @Override
    public Comparable findMin() {
        return dataAt(findMin(mOverallRoot));
    }
 
    @Override
    public Comparable findMax() {
        return dataAt(findMax(mOverallRoot));
    }
 
    @Override
    public Comparable find(Comparable x) {
        return dataAt(find(x, mOverallRoot));
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
        if(isEmpty())
            System.out.println("Empty tree");
        else
            printTree(mOverallRoot);
    }
 
    /**
     * Private helper method to get getData() field.
     * @param node the node.
     * @return the getData() field or null if node is null.
     */
    private Comparable dataAt(BinaryNode node) {
        return node == null ? null : node.getData();
    }
 
    /**
     * Private helper method to insert into a subtree.
     * @param x the item to insert.
     * @param node the node that overallRoots the tree.
     * @return the new mOverallRoot.
     */
    private BinaryNode insert(Comparable x, BinaryNode node) {
        if (node == null) {
            node = new BinaryNode(x, null, null);
        } else if(x.compareTo(node.getData()) < 0) {
            node.setLeft((insert(x, node.getLeft())));
        } else if(x.compareTo(node.getData()) > 0) {
            node.setRight(insert(x, node.getRight()));
        } else {
            ;                                               // Duplicate; do nothing
        }
        return node;
    }
 
    /**
     * Private helper method to remove from a subtree.
     * @param x the item to remove.
     * @param node the node that overallRoots the tree.
     * @return the new mOverallRoot.
     */
    private static BinaryNode remove(Comparable x, BinaryNode node) {
        if(node == null) {
            // Item not found; do nothing
            return node;                                       
        } if (x.compareTo(node.getData()) < 0) {
            node.setLeft((remove(x, node.getLeft())));
        } else if (x.compareTo(node.getData()) > 0) {
            node.setRight((remove(x, node.getRight())));
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
    private static BinaryNode findMin(BinaryNode node) {
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
    private static BinaryNode findMax(BinaryNode node) {
        if(node != null) {
            while(node.getRight() != null) {
                node = node.getRight();
            }
        }
        return node;
    }
 
    /**
     * Private helper method to find an item in a subtree.
     * @param x is item to search for.
     * @param node the node that overallRoots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode find(Comparable x, BinaryNode node) {
        if(node == null) {
            return null;
        } if(x.compareTo(node.getData()) < 0) {
            return find(x, node.getLeft());
        } else if(x.compareTo(node.getData()) > 0) {
            return find(x, node.getRight());
        } else {
            return node;                                       // Match
        }
    }
 
    /**
     * Private helper method to print a subtree in sorted order.
     * @param node the node that overallRoots the tree.
     */
    private void printTree(BinaryNode node) {
        if(node != null) {
            printTree(node.getLeft());
            System.out.println(node.getData());
            printTree(node.getRight());
        }
    }
}
