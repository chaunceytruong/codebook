package com.codebook.datastructure;

import com.codebook.datastructure.impl.BinaryNode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.lang.*;

public class Tree {
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

        /**
         * Print the tree starting at this node.
         *
         * @param out OutputStream to write to.
         * @throws IOException if failed for some reason to write to OutputStream.
         */
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

        /**
         * Helper method to print the node value to the OutputStreamWriter.
         *
         * @param out OutputStreamWriter
         * @throws IOException if failed for some reason to write to OutputStreamWriter.
         */
        private void printNodeValue(OutputStreamWriter out) throws IOException {
            if (data == null) {
                out.write("<null>");
            } else {
                out.write(data.toString());
            }
            out.write('\n');
            out.flush();
        }

        /**
         * Print tree with indents and characters to specify node relationships.
         *
         * @param out     OutputStreamWriter
         * @param isRight true if right node, false otherwise
         * @param indent  string indent for node
         * @throws IOException if failed for some reason to write to OutputStreamWriter.
         */
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

    /**
     * Construct a tree of depth 5 (stops immediately after reaching depth 5 (will not create a full tree).
     */
    public void constructDepth5Tree() {
        Random rand = new Random();
        while (insert(rand.nextInt(100)) < 5) ;
    }

    /**
     * Create a new node and attach it to specified parent.
     *
     * @param data   new node data
     * @param parent parent node
     * @return newly created node
     */
    private Node createNode(int data, Node parent) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.parent = parent;
        newNode.children = new ArrayList<Node>();
        newNode.children.add(0, null);
        newNode.children.add(1, null);
        return newNode;
    }

    /**
     * Insert node into tree.
     *
     * @param data node data.
     * @return the depth of the inserted node
     */
    private int insert(int data) {
        if (root == null) {
            root = createNode(data, null);
            System.out.println("root insert: " + data);
            return 1;
        }
        Node parent = null;
        Node current = root;
        int depth = 1;

        while (current != null) {
            parent = current;
            if (data <= current.data) {
                current = current.children.get(0);
            } else {
                current = current.children.get(1);
            }
            depth += 1;
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

    public void printPreorder() {
        System.out.print("preorder: ");
        printPreorderHelper(root);
        System.out.println();
    }

    private void printPreorderHelper(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorderHelper(node.children.get(0));
        printPreorderHelper(node.children.get(1));
    }

    /**
     * Serialize a tree by preorder traversal and writing nodes to a file.
     *
     * @param fileOutputStream
     * @throws IOException
     */
    public void serializeTree(FileOutputStream fileOutputStream) throws IOException {
        serializeTreeHelper(root, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    private void serializeTreeHelper(Node node, FileOutputStream fileOutputStream) throws IOException {
        if (node == null)
            return;
        String nodeData = node.data + " ";
        fileOutputStream.write(nodeData.getBytes());
        serializeTreeHelper(node.children.get(0), fileOutputStream);
        serializeTreeHelper(node.children.get(1), fileOutputStream);
    }

//    public static void main(String args[]) { // test
//        int[] encrypted = encrypt(value, keyval);
//        for (int i = 0; i < encrypted.length; i++)
//            System.out.printf("%d,", encrypted[i]);
//        System.out.println("");
//        System.out.println(decrypt(encrypted, keyval));
//    }

    private static int[] encrypt(String str, String key) {
        int[] output = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int o = (Integer.valueOf(str.charAt(i)) ^ Integer.valueOf(key.charAt(i % (key.length() - 1)))) + '0';
            output[i] = o;
        }
        return output;
    }

    private static int[] string2Arr(String str) {
        String[] sarr = str.split(",");
        int[] out = new int[sarr.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = Integer.valueOf(sarr[i]);
        }
        return out;
    }

    private static String decrypt(int[] input, String key) {
        String output = "";
        for (int i = 0; i < input.length; i++) {
            output += (char) ((input[i] - 48) ^ (int) key.charAt(i % (key.length() - 1)));
        }
        return output;
    }

}