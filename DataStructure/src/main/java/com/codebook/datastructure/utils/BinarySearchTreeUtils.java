package com.codebook.datastructure.utils;


import com.codebook.datastructure.impl.BinaryNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BinarySearchTreeUtils {

    /**
     * Construct a Binary Tree from its pre-order traversal
     *
     * @param preOrderTraversal Pre-order traversal list from which to construct the binary tree.
     *
     * @return BinaryNode Root of re-constructed tree
     */
    public static BinaryNode constructFromPreOrderTraversal(List<Comparable> preOrderTraversal) {
        return constructFromPreOrderTraversal(
                preOrderTraversal,
                0,
                preOrderTraversal.size());
    }

    private static BinaryNode constructFromPreOrderTraversal(List<Comparable> preOrderTraversal,
                                                             int start, int end) {
        // Base case, finished re-constructing tree
        if (start >= end) {
            return null;
        }

        BinaryNode root = null;
        if (preOrderTraversal != null && !preOrderTraversal.isEmpty()) {
            // Store sub-tree root value
            final Comparable rootValue = preOrderTraversal.get(start);

            // Find sub-tree index (first node > current root node)
            final int index = findSubtreeIndex(
                    preOrderTraversal,
                    rootValue,
                    start + 1,
                    end);

            // Recursively construct subtrees
            root = new BinaryNode(
                    rootValue,
                    constructFromPreOrderTraversal(
                            preOrderTraversal,
                            start + 1,
                            index),
                    constructFromPreOrderTraversal(
                            preOrderTraversal,
                            index,
                            end));
        }
        return root;
    }

    /**
     * Find the index of the right subtree (values > current root)
     *
     * @param preOrderTraversal List of values (pre-order traversal).
     * @param rootValue         Sub-tree root value.
     * @param startIndex        Sub-tree start index.
     * @param endIndex          Sub-tree end index.
     * @return Right subtree index
     */
    private static int findSubtreeIndex(List<Comparable> preOrderTraversal, Comparable rootValue,
                                        int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            if (rootValue.compareTo(preOrderTraversal.get(i)) < 0) {
                return i;
            }
        }
        return endIndex;
    }

    /**
     * Finds the lowest common answer between two unique BinaryNodes
     *
     * @param rootNode  Overall root of BinaryTree
     * @param start     Lower bound value
     * @param end       Upper bound value
     *
     * @return Lowest common ancestor, given two nodes that already exist in the tree
     */
    public static BinaryNode getLowestCommonAncestor(BinaryNode rootNode, Comparable start,
                                                     Comparable end) {
        while (rootNode != null) {
            if (rootNode.getValue().compareTo(start) < 0
                    && rootNode.getValue().compareTo(end) < 0) {
                rootNode = rootNode.getRight();
            } else if (rootNode.getValue().compareTo(start) > 0
                    && rootNode.getValue().compareTo(end) > 0) {
                rootNode = rootNode.getLeft();
            } else {
                return rootNode;
            }
        }
        return null;
    }

    public static void print(BinaryNode root) {
        if (root != null) {
            int maxLevel = maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }
    }

    private static void printNodeInternal(List<BinaryNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<BinaryNode> newNodes = new ArrayList<BinaryNode>();
        for (BinaryNode node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(BinaryNode node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    private static boolean isAllElementsNull(List<BinaryNode> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
