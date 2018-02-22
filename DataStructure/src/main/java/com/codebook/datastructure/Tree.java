package com.codebook.datastructure;

import com.codebook.datastructure.impl.BinaryNode;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.lang.*;

public class Tree
{
    private Node root;

    // create and empty tree?
    public Tree() {
        root = null;
    }

    public Tree(int rootData) {
        root = createNode(rootData, null);
    }

    public static class Node {
        private Integer data;
        private Node parent;
        private List<Node> children;

        public void printTree(OutputStreamWriter out) throws IOException {
            Node right = children.get(1);
            Node left = children.get(0);
            if (right != null) {
                right.printTree(out, true, "  ");
            }
            printNodeValue(out);
            if (left != null) {
                left.printTree(out, false, "  ");
            }
        }

        private void printNodeValue(OutputStreamWriter out) throws IOException {
            if (data == null) {
                out.write("<null>");
            } else {
                out.write(data.toString());
            }
            out.write('\n');
            out.flush();
        }

        // use string and not stringbuffer on purpose as we need to change the indent at each recursion
        private void printTree(OutputStreamWriter out, boolean isRight, String indent) throws IOException {
            Node right = children.get(1);
            Node left = children.get(0);
            if (right != null) {
                right.printTree(out, true, indent + (isRight ? "        " : " |      "));
            }
            out.write(indent);
            if (isRight) {
                out.write(" /");
            } else {
                out.write(" \\");
            }
            out.write("---- ");
            printNodeValue(out);
            if (left != null) {
                left.printTree(out, false, indent + (isRight ? " |      " : "        "));
            }
        }
    }

    /** PART A) Assuming the data structure of a tree above. First, write a function that creates a random tree of depth 5,
     *  and each node can have 0-2 children. For simplicity, let's assume the data-type T is just an integer.
     */

    public void construct5depthTree() {
        // create a list of random numbers
        Random rand = new Random();
        while (insert(rand.nextInt()) < 5);

//        insert(10);
//        insert(3);
//        insert(11);
//        insert(5);
//        insert(4);
//        insert(12);
//        insert(9);
    }

    void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null) {
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }
            System.out.print("NULL");
            return;
        }

        // Increase distance between levels
        space += 10;

        // Process right child first
        print2DUtil(root.children.get(1), space);

        // Print current node after space
        // count
        System.out.println();
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.printf("%d\n", root.data);

        // Process left child
        print2DUtil(root.children.get(0), space);
    }

    // create a new node
    private Node createNode(int newData, Node parent){
        Node newNode = new Node();
        newNode.data = newData;
        newNode.parent = parent;
        newNode.children = new ArrayList<Node>();
        newNode.children.add(0, null);
        newNode.children.add(1, null);
        return  newNode;
    }

    /**
     * insert
     * @param data
     * @return the depth of the inserted node
     */
    private int insert(int data) {
        // empty tree
        if (root == null) {
            root = createNode(data, null);
            System.out.println("root insert: " + data);
            return 0;
        }
        Node parent = null;
        Node current = root;
        int depth = 0;

        while (current != null) {
            parent = current;
            if (data <= current.data) {
                current = current.children.get(0);
                depth += 1;
            }
            else {
                current = current.children.get(1);
                depth += 1;
            }
        }
        if (data <= parent.data) {
            parent.children.remove(0);
            parent.children.add(0, createNode(data, parent));
            System.out.println("insert: " + data + " depth: " + depth);
            return depth;
        } else {
            parent.children.remove(1);
            parent.children.add(1, createNode(data, parent));
            System.out.println("insert: " + data + " depth: " + depth);
            return depth;
        }
    }

    public void visualizeTreeStructure() {
        if (root != null) {
            try {
                root.printTree(new OutputStreamWriter(System.out));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printPreorder(){
        System.out.print("preorder: ");
        printPreorderHelper(root);
        System.out.println();
    }

    private void printPreorderHelper(Node node){
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorderHelper(node.children.get(0));
        printPreorderHelper(node.children.get(1));
    }

}