package com.codebook.datastructure.base;

import com.codebook.datastructure.impl.BinaryNode;
import com.codebook.datastructure.interfaces.BinaryTree;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("rawtypes")
public abstract class AbstractBinaryTree<T extends Comparable> implements BinaryTree<T> {
    /** 
     * The tree overall root.
     */
    protected BinaryNode<T> mOverallRoot;
    
    /**
     * Construct an empty Binary Search Tree.
     */
    public AbstractBinaryTree() {
        mOverallRoot = null;
    }
 
    public BinaryNode<T> getOverallRoot() {
        return mOverallRoot;
    }
 
    @Override
    public void insert(T value) {
        mOverallRoot = insert(value, mOverallRoot);
    }
 
    /**
     * Helper method to insert value into a subtree.
     * @param value the item to insert.
     * @param node the node that overallRoots the tree.
     * @return the new mOverallRoot.
     */
    protected abstract BinaryNode<T> insert(T value, BinaryNode<T> node);
    
    @Override
    public void remove(T value) {
        mOverallRoot = remove(value, mOverallRoot);
    }
    
    /**
     * Helper method to remove from a subtree.
     * @param value the item to remove.
     * @param node the node that overallRoots the tree.
     * @return the new mOverallRoot.
     */
    protected abstract BinaryNode<T> remove(T value, BinaryNode<T> node);
 
    @Override
    public T findMin() {
        return dataAt(findMin(mOverallRoot));
    }
    
    /**
     * Helper method to find the smallest item in a subtree.
     * @param node the node that overallRoots the tree.
     * @return node containing the smallest item.
     */
    protected abstract BinaryNode<T> findMin(BinaryNode<T> node);
 
    @Override
    public T findMax() {
        return dataAt(findMax(mOverallRoot));
    }
    
    /**
     * Helper method to find the largest item in a subtree.
     * @param node the node that overallRoots the tree.
     * @return node containing the largest item.
     */
    protected abstract BinaryNode<T> findMax(BinaryNode<T> node);
 
    @Override
    public T find(T value) {
        return dataAt(find(value, mOverallRoot));
    }
    
    /**
     * Helper method to find an item in a subtree.
     * @param value is item to search for.
     * @param node the node that overallRoots the tree.
     * @return node containing the matched item.
     */
    protected abstract BinaryNode<T> find(T value, BinaryNode<T> node);
 
    @Override
    public void makeEmpty() {
        mOverallRoot = null;
    }
 
    @Override
    public boolean isEmpty() {
        return mOverallRoot == null;
    }
    
    /**
     * Private helper method to get data field.
     * @param node the node.
     * @return the data field or null if node is null.
     */
    private T dataAt(BinaryNode<T> node) {
        return node == null ? null : node.getData();
    }
    
    @Override
    public void printTraversal(Traversal traversal) {
	System.out.println(String.format("%s traversal\n~~~", traversal));
        if(isEmpty()) {
            System.out.println("Empty tree");
        } else {
            List<BinaryNode<T>> traversalList;
            switch (traversal) {
            	case PRE_ORDER:
            	    traversalList = preOrderList(mOverallRoot);
            	    break;
            	case POST_ORDER:
            	    traversalList = postOrderList(mOverallRoot);
            	    break;
            	case IN_ORDER:
            	default:
            	    traversalList = inOrderList(mOverallRoot);
            }
            System.out.println(traversalList);
        }
        System.out.println("~~~");
    }

    /**
     * TODO(oud): Add Javadoc
     * @see com.codebook.datastructure.interfaces.BinaryTree#inOrderList(com.codebook.datastructure.impl.BinaryNode)
     */
    @Override
    public List<BinaryNode<T>> inOrderList(BinaryNode<T> overallRoot) {
	List<BinaryNode<T>> inOrderTraversalList = new ArrayList<BinaryNode<T>>();
	inOrderList(overallRoot, inOrderTraversalList);
	return inOrderTraversalList;
    }
    
    private void inOrderList(BinaryNode<T> root, List<BinaryNode<T>> result) {
       if(root != null) {
          inOrderList(root.getLeft(), result);
          result.add(root);
          inOrderList(root.getRight(), result);
       }
    }

    /**
     * TODO(oud): Add Javadoc
     * @see com.codebook.datastructure.interfaces.BinaryTree#preOrderList(com.codebook.datastructure.impl.BinaryNode)
     */
    @Override
    public List<BinaryNode<T>> preOrderList(BinaryNode<T> overallRoot) {
	List<BinaryNode<T>> preOrderTraversalList = new ArrayList<BinaryNode<T>>();
	preOrderList(overallRoot, preOrderTraversalList);
	return preOrderTraversalList;
    }
    
    private void preOrderList(BinaryNode<T> root, List<BinaryNode<T>> result) {
	if(root != null) {
	    result.add(root);
	    preOrderList(root.getLeft(), result);
	    preOrderList(root.getRight(), result);
	}
    }

    /**
     * TODO(oud): Add Javadoc
     * @see com.codebook.datastructure.interfaces.BinaryTree#postOrderList(com.codebook.datastructure.impl.BinaryNode)
     */
    @Override
    public List<BinaryNode<T>> postOrderList(BinaryNode<T> overallRoot) {
	List<BinaryNode<T>> postOrderTraversalList = new ArrayList<BinaryNode<T>>();
	postOrderList(overallRoot, postOrderTraversalList);
	return postOrderTraversalList;
    }
    
    private void postOrderList(BinaryNode<T> root, List<BinaryNode<T>> result) {
	if(root != null) {
	    preOrderList(root.getLeft(), result);
	    preOrderList(root.getRight(), result);
	    result.add(root);
	}
    }
}
