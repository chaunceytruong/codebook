package com.codebook.datastructure;

public class TreeDriver {
    public static void main(String[] args) {
        Tree TreeTest1 = new Tree();
        TreeTest1.constructDepth5Tree();
        TreeTest1.printPreorder();
        TreeTest1.visualizeTreeStructure();
    }
}