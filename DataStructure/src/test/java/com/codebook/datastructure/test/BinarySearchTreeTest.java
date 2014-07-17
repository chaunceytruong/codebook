package com.codebook.datastructure.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.codebook.datastructure.impl.BinarySearchTree;

public class BinarySearchTreeTest {
    
    @Test
    public void testBasic() {
	BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        final int NUMS = 4000;
        final int GAP = 37;

        for(int i = GAP; i != 0; i = (i + GAP)% NUMS ) {
            tree.insert(new Integer(i));
        }

        for(int i = 1; i < NUMS; i+= 2 ) {
            tree.remove(new Integer(i));
        }
        
        assertEquals("FindMin error!", (tree.findMin()).intValue(), 2);
        assertEquals("FindMax error!", (tree.findMax()).intValue(), NUMS - 2);

        for(int i = 2; i < NUMS; i+=2 ) {
            assertEquals("Find error1!", (tree.find(new Integer(i))).intValue(), i);
        }

        for(int i = 1; i < NUMS; i+=2 ) {
            assertEquals("Find error2!", tree.find(new Integer(i)), null);
        }
    }

}
