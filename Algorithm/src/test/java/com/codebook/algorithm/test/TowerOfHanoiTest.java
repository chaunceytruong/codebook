package com.codebook.algorithm.test;

import static org.junit.Assert.assertEquals;

import com.codebook.algorithm.TowerOfHanoi;
import com.codebook.algorithm.TowerOfHanoi.Tower;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TowerOfHanoiTest {
	TowerOfHanoi mTowerOfHanoi;

	@Before
	public void setUp() {
		mTowerOfHanoi = new TowerOfHanoi();
	}

	@After
	public void tearDown() {
		mTowerOfHanoi = null;
	}

	@Test
	public void testMoveDisks_ThreeDisks() {
		Tower originTower = mTowerOfHanoi.getTower(0);
		Tower destinationTower = mTowerOfHanoi.getTower(2);
		Tower bufferTower = mTowerOfHanoi.getTower(1);

		mTowerOfHanoi.moveDisks(3, originTower, destinationTower, bufferTower);

		// Origin and buffer towers should have 0 disks
		assertEquals(0, originTower.size());
		assertEquals(0, bufferTower.size());

		// Destination tower should have all 3 disks
		assertEquals(3, destinationTower.size());
	}

	/**
	 * Test the run-time complexity of this algorithm (2^n). In this case, it
	 * would be 2^20. Should take about 30 seconds to complete.
	 */
	@Test
	public void testMoveDisks_ExtremelyLargeAmountOfDisks() {
		// Reset the tower to 20 with 20 disks on the first tower
		int numDisks = 20;
		mTowerOfHanoi.setTowers(20, numDisks);

		Tower originTower = mTowerOfHanoi.getTower(0);
		Tower destinationTower = mTowerOfHanoi.getTower(19);
		Tower bufferTower = mTowerOfHanoi.getTower(1);

		// Move said disks from tower A to tower C (it really doesn't matter
		// which one, they all work the same)
		mTowerOfHanoi.moveDisks(numDisks, originTower, destinationTower,
				bufferTower);

		// Origin and buffer towers should have 0 disks
		assertEquals(0, originTower.size());
		assertEquals(0, bufferTower.size());

		// Same for all the other towers in-between
		for (int index = 2; index < numDisks - 1; index++) {
			Tower otherBufferTower = mTowerOfHanoi.getTower(index);
			assertEquals(0, otherBufferTower.size());
		}

		// Destination tower should have all 20 disks
		assertEquals(20, destinationTower.size());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testMoreDisksThanTowers() {
		mTowerOfHanoi = new TowerOfHanoi(20, 21);
	}

}
