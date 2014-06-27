package com.codebook.algorithm;


public class EquilbriumIndex {
    
    public int find(int[] values) {
	if (values.length == 0) {
	    return -1;
	}
	
	// Calculate total sum
	long totalSum = 0;
	for (int value : values) {
	    totalSum += value;
	}
	
	long leftSum = 0;
	for (int index = 0; index < values.length; index++) {
	    long rightSum = totalSum - leftSum - values[index];
	    if (leftSum == rightSum) {
		return index;
	    }
	    leftSum += values[index];
	}
	
	// Unable to find equilibrium index
	return -1;
    }
}
