package com.codebook.datastructure.test;

import com.codebook.datastructure.impl.BinarySearchTree;
import com.codebook.datastructure.utils.BinarySearchTreeUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BinarySearchTreeTest {
	BinarySearchTree mBinarySearchTree;

	@Before
	public void setUp() {
		mBinarySearchTree = new BinarySearchTree();
	}

	@After
	public void tearDown() {
		mBinarySearchTree = null;
	}

	@Test
	public void testEmpty() {
		assertTrue(mBinarySearchTree.isEmpty());
	}

	@Test
	public void testInsert_ShouldMakeTreeNonEmpty() {
		mBinarySearchTree.insert(1);
		assertFalse(mBinarySearchTree.isEmpty());
	}

	@Test
	public void testInsert_DuplicateValueShouldNotBeInserted() {
		mBinarySearchTree.insert(1);
		mBinarySearchTree.insert(1);
		int expectedSize = 1;
		int actualSize = mBinarySearchTree.size();
		assertEquals(expectedSize, actualSize);
        BinarySearchTreeUtils.print(mBinarySearchTree.getOverallRoot());
	}

	@Test
	public void testFindMax_ExtremelyLargeNumbers() {
		mBinarySearchTree.insert(1082132608);
		mBinarySearchTree.insert(1082132607);
		mBinarySearchTree.insert(1082132606);
		int expectedMax = 1082132608;
		Comparable actualMax = mBinarySearchTree.findMax();
		assertEquals(expectedMax, actualMax);
        BinarySearchTreeUtils.print(mBinarySearchTree.getOverallRoot());
	}

	@Test
	public void testSimple() {
		BinarySearchTree tree = new BinarySearchTree();
		final int NUMS = 4000;
		final int GAP = 37;

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
			tree.insert(new Integer(i));
		}

		for (int i = 1; i < NUMS; i += 2) {
			tree.remove(i);
		}

		assertEquals("FindMin error!", tree.findMin(), 2);
		assertEquals("FindMax error!", tree.findMax(), NUMS - 2);

		for (int i = 2; i < NUMS; i += 2) {
			assertEquals("Find error1!", tree.find(i), i);
		}

		for (int i = 1; i < NUMS; i += 2) {
			assertEquals("Find error2!", tree.find(i), null);
		}
    }
}
