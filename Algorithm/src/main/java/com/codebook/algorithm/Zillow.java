package com.codebook.algorithm;


import com.sun.javafx.beans.annotations.NonNull;


public class Zillow {

    /**
     * Minimum radix for long is 2.
     */
    private static final int MIN_RADIX = 2;

    /**
     * Maximum radix for long is 36.
     */
    private static final int MAX_RADIX = 36;

    /**
     * Converts the string argument to a signed long in base 10. Characters must be valid digits
     * (base 10) with the exception of the first (can be a '-' to indicate a negative).
     *
     * @param s String argument to convert
     *
     * @return Long value after converting the string argument
     *
     * @throws NumberFormatException if the string argument cannot be converted
     */
    public static long stringToLong(@NonNull String s) throws NumberFormatException {
        return stringToLong(s, 10);
    }

    /**
     * Converts the string argument to a signed long. Characters must be valid digits (within radix)
     * with the exception of the first (can be a '-' to indicate a negative).
     *
     * @param s String argument to convert
     * @param radix Must be greater than @see MIN_RADIX and less than @see MAX_RADIX
     *
     * @return Long value after converting the string argument
     *
     * @throws NumberFormatException if the string argument cannot be converted
     */
    public static long stringToLong(@NonNull String s, int radix) throws NumberFormatException {
        if (s == null || s.isEmpty()) {
            throw new NumberFormatException("String argument cannot be null or empty");
        }

        if (radix < MIN_RADIX || radix > MAX_RADIX) {
            throw new NumberFormatException(String.format("Please specify an appropriate radix " +
                    "value. MIN_RADIX < Radix %s < MAX_RADIX", radix));
        }

        boolean isNegative = false;
        int index = 0;
        int size = s.length();
        long result = 0;

        char first = s.charAt(index);
        if (first < '0' && first != '-') {
            throw new NumberFormatException(String.format("String argument %s is not a valid " +
                    "digit within radix %s", s, radix));
        }

        if (first == '-') {
            isNegative = true;

            if (size == 1) {
                throw new NumberFormatException(String.format("String argument %s is not a valid " +
                        "digit within radix %s", s, radix));
            }

            // Valid negative character, increment index
            index++;
        }

        while (index < size) {
            // digit represents the numeric value of the char within the specified radix
            int digit = Character.digit(s.charAt(index++), radix);
            if (digit == -1) {
                throw new NumberFormatException(String.format("String argument %s is not a valid " +
                        "digit within radix %s", s, radix));
            }
            result *= radix;
            result += digit;
        }

        return isNegative ? -result : result;
    }

    /**
     * Class TrinaryNode defines a node within a TrinaryTree. A TrinaryTree is much like a BinaryTree
     * except that it has 3 children nodes instead of 2. The middle child has an equal data value to
     * its parent.
     */
    public class TrinaryNode {
        public Comparable data;      	// The data in the node
        public TrinaryNode left;         // Left child
        public TrinaryNode right;        // Right child
        public TrinaryNode mid;			// Middle child

        /**
         * Initialize TrinaryNode with specified value and no children nodes.
         * @param value
         */
        public TrinaryNode(@NonNull Comparable value) {
            this(value, null, null, null);
        }

        /**
         * Initialize TrinaryNode with specified value and children nodes.
         * @param value Node value
         * @param leftNode Left child node (data < parent.data)
         * @param midNode Middle child node (data == parent.data)
         * @param rightNode Right child node (data > parent.data)
         */
        public TrinaryNode(Comparable value, TrinaryNode leftNode, TrinaryNode midNode,
                           TrinaryNode rightNode) {
            data = value;
            left = leftNode;
            right = rightNode;
            mid = midNode;
        }
    }

    /**
     * Interface Tree defines the methods common to a tree data structure (please note that some
     * have been removed for the sake of brevity).
     */
    public interface Tree {
        /**
         * Insert item into the tree
         * @param x the item to insert (must implement Comparable)
         */
        public void insert(Comparable x);

        /**
         * Remove from the tree. Nothing is done if x is not found.
         * @param x the item to remove (must implement Comparable)
         */
        public void remove(Comparable x);
    }

    public class TrinaryTree implements Tree {

        /** The tree overallRoot. */
        private TrinaryNode mOverallRoot;

        @Override
        public void insert(Comparable x) {
            mOverallRoot = insert(x, mOverallRoot);
        }

        @Override
        public void remove(Comparable x) {
            mOverallRoot = remove(x, mOverallRoot);
        }

        /**
         * Private helper method to insert into a subtree.
         * @param x the item to insert.
         * @param node the node that overallRoots the tree.
         * @return the new overallRoot.
         */
        private TrinaryNode insert(Comparable x, TrinaryNode node) {
            if (node == null) {
                node = new TrinaryNode(x, null, null, null);
            } else if (x.compareTo(node.data) < 0) {
                node.left = insert(x, node.left);
            } else if (x.compareTo(node.data) > 0) {
                node.right = insert(x, node.right);
            } else {
                node.mid = insert(x, node.mid);
            }
            return node;
        }

        /**
         * Private helper method to remove from a subtree.
         * Please note that the remove implementation will set the node.mid to null.
         *
         * @param x The item to remove.
         * @param node The node that overallRoots the tree.
         *
         * @return The new overallRoot.
         */
        private TrinaryNode remove(Comparable x, TrinaryNode node) {
            if (node == null) {
                return node;	// Item not found; do nothing
            } if (x.compareTo(node.data) < 0) {
                node.left = remove(x, node.left);
            } else if (x.compareTo(node.data) > 0) {
                node.right = remove(x, node.right);
            } else {
                // If two children, replace with right
                if (node.left != null && node.right != null) {
                    node.data = findMin(node.right).data;
                    node.right = remove(node.data, node.right);
                    node.mid = null;

                // If one child, replace with child
                } else {
                    node = (node.left != null) ? node.left : node.right;
                }
            }
            return node;
        }

        /**
         * Private helper method to find the smallest item in a subtree.
         *
         * @param node The node that overallRoots the tree.
         *
         * @return Node containing the smallest item.
         */
        private TrinaryNode findMin(TrinaryNode node) {
            if (node == null) {
                return null;
            } else if (node.left == null) {
                return node;
            }
            return findMin(node.left);
        }

    }
}
