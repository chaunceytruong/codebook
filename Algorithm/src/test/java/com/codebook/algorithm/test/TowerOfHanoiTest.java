package com.codebook.algorithm.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codebook.algorithm.TowerOfHanoi;
import com.codebook.algorithm.TowerOfHanoi.Tower;

public class TowerOfHanoiTest {
    Tower mTowerA;
    Tower mTowerB;
    Tower mTowerC;
    
    @Before
    public void setUp() {
	mTowerA = new Tower(1);
	mTowerB = new Tower(2);
	mTowerC = new Tower(3);
	mTowerA.insertDisk(3);
	mTowerA.insertDisk(2);
	mTowerA.insertDisk(1);
    }
    
    @After
    public void tearDown() {
	mTowerA = null;
	mTowerB = null;
	mTowerC = null;
    }
    
    @Test
    public void testMoveDisks_FromTowerAToC() {
	TowerOfHanoi.moveDisks(3, mTowerA, mTowerC, mTowerB);
	assertEquals(0, mTowerA.size());
	assertEquals(0, mTowerB.size());
	assertEquals(3, mTowerC.size());
    }
}
