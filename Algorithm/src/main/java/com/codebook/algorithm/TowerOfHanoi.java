package com.codebook.algorithm;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Implementation of the the classic problem - Tower of Hanoi.
 *
 */
public class TowerOfHanoi {

    /**
     * Move the top-most disk from one tower to another specified tower.
     * 
     * @param targetTower
     *            Tower to move the top-most disk to
     */
    public static void moveTop(final Tower originTower, final Tower targetTower) {
	int topDisk = originTower.getTopDisk();
	targetTower.insertDisk(topDisk);
	System.out.println(String.format(
		"Move disk %s from tower %s to tower %s", topDisk,
		originTower.index(), targetTower.index()));
    }

    public static void moveDisks(final int numDisks, final Tower originTower,
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
