package com.codebook.algorithm;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Implementation of the the classic problem - Tower of Hanoi.
 * 
 */
public class TowerOfHanoi {
	private List<TowerOfHanoi.Tower> mTowers;

	/**
	 * Default constructors instantiates a TowerOfHanoi setup with 3 towers and
	 * 3 disks on the first tower.
	 */
	public TowerOfHanoi() {
		this(3, 3);
	}

	/**
	 * Constructors accepts two values that specify the number of towers that
	 * will be used and the number of disks to insert onto the first tower.
	 * 
	 * @param numTowers
	 *            Number of towers
	 * @param numDisks
	 *            Number of disks
	 * @throws IllegalArgumentException
	 *             Cannot instantiate TowerOfHanoi with 0 or less towers/disks
	 */
	public TowerOfHanoi(int numTowers, int numDisks) {
		if (numDisks > numTowers) {
			throw new IllegalArgumentException(
					"Number of disks cannot exceed the number of towers. You can however have more towers than disks.");
		}

		if (numTowers <= 0 || numDisks <= 0) {
			throw new IllegalArgumentException(
					"Cannot instantiate TowerOfHanoi with 0 or less towers/disks.");
		}

		// Instantiate towers and insert disks
		setTowers(numTowers, numDisks);
	}

	/**
	 * Get the tower at the specified index.
	 * 
	 * @param index
	 *            Index to retrieve tower
	 * @return Tower at the specified index
	 * @throws IndexOutOfBoundsException
	 *             If there is no tower at that index
	 */
	public Tower getTower(int index) {
		if (index >= mTowers.size()) {
			throw new IndexOutOfBoundsException(
					"Cannot retrieve a tower from that index.");
		}
		return mTowers.get(index);
	}

	/**
	 * Reset TowerOfHanoi to the specified number of towers and insert disks
	 * onto first tower.
	 * 
	 * @param numTowers
	 *            Number of towers
	 * @param numDisks
	 *            Number of disks
	 * @throws IllegalArgumentException
	 *             Cannot instantiate TowerOfHanoi with 0 or less towers/disks
	 */
	public void setTowers(int numTowers, int numDisks) {
		if (numTowers <= 0 || numDisks <= 0) {
			throw new IllegalArgumentException(
					"Cannot instantiate TowerOfHanoi with 0 or less towers/disks.");
		}

		mTowers = new ArrayList<TowerOfHanoi.Tower>();

		Tower tower = new Tower(0);
		for (int disk = numDisks; disk > 0; disk--) {
			tower.insertDisk(disk);
		}
		mTowers.add(tower);

		for (int index = 1; index < numTowers; index++) {
			tower = new Tower(index);
			mTowers.add(tower);
		}
	}

	/**
	 * Move the top-most disk from one tower to another specified tower.
	 * 
	 * @param targetTower
	 *            Tower to move the top-most disk to
	 */
	public void moveTop(final Tower originTower, final Tower targetTower) {
		int topDisk = originTower.getTopDisk();
		targetTower.insertDisk(topDisk);
		System.out.println(String.format(
				"Move disk %s from tower %s to tower %s", topDisk,
				originTower.index(), targetTower.index()));
	}

	public void moveDisks(final int numDisks, final Tower originTower,
			Tower destinationTower, Tower bufferTower) {
		// Base case
		if (numDisks <= 0) {
			return;
		}

		// Move top n - 1 disks from origin to buffer, using destination as a
		// buffer
		moveDisks(numDisks - 1, originTower, bufferTower, destinationTower);

		// Move top from origin to destination
		moveTop(originTower, destinationTower);

		// Move top n - 1 disks from buffer to destination, using origin as a
		// buffer
		moveDisks(numDisks - 1, bufferTower, destinationTower, originTower);
	}

	public static class Tower {
		/**
		 * Internal stack to maintain the tower's disks
		 */
		private Stack<Integer> mDisks;

		/**
		 * Tower index
		 */
		private int mIndex;

		/**
		 * Constructor accepts a single value that specifies the tower index
		 * 
		 * @param index
		 *            Tower index
		 */
		public Tower(int index) {
			this.mDisks = new Stack<Integer>();
			this.mIndex = index;
		}

		/**
		 * Get the tower index.
		 * 
		 * @return The tower index
		 */
		public int index() {
			return this.mIndex;
		}

		/**
		 * Insert a disk onto tower.
		 * 
		 * @param disk
		 *            Disk to insert onto tower
		 * @throws IllegalArgumentException
		 *             No disk may be placed on top of a smaller disk
		 */
		public void insertDisk(int disk) {
			if (!mDisks.isEmpty() && mDisks.peek() <= disk) {
				throw new IllegalArgumentException(
						"No disk may be placed on top of a smaller disk.");
			}
			this.mDisks.push(disk);
		}

		/**
		 * Get the top-most disk on tower.
		 * 
		 * @return Top-most disk
		 * @throws EmptyStackException
		 */
		public int getTopDisk() {
			return mDisks.pop();
		}

		/**
		 * Get the number of disks on tower.
		 * 
		 * @return Numbers of disks on tower
		 */
		public int size() {
			return mDisks.size();
		}
	}
}
