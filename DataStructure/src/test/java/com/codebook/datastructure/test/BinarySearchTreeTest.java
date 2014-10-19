package com.codebook.datastructure.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codebook.datastructure.impl.BinarySearchTree;

public class BinarySearchTreeTest {
	BinarySearchTree<Integer> mBinarySearchTree;

	@Before
	public void setUp() {
		mBinarySearchTree = new BinarySearchTree<Integer>();
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
	}

	@Test
	public void testFindMax_ExtremelyLargeNumbers() {
		mBinarySearchTree.insert(1082132608);
		mBinarySearchTree.insert(1082132607);
		mBinarySearchTree.insert(1082132606);
		int expectedMax = 1082132608;
		int actualMax = mBinarySearchTree.findMax();
		assertEquals(expectedMax, actualMax);
	}

	@Test
	public void testSimple() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		final int NUMS = 4000;
		final int GAP = 37;

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
			tree.insert(new Integer(i));
		}

		for (int i = 1; i < NUMS; i += 2) {
			tree.remove(new Integer(i));
		}

		assertEquals("FindMin error!", (tree.findMin()).intValue(), 2);
		assertEquals("FindMax error!", (tree.findMax()).intValue(), NUMS - 2);

		for (int i = 2; i < NUMS; i += 2) {
			assertEquals("Find error1!",
					(tree.find(new Integer(i))).intValue(), i);
		}

		for (int i = 1; i < NUMS; i += 2) {
			assertEquals("Find error2!", tree.find(new Integer(i)), null);
		}
	}
}
