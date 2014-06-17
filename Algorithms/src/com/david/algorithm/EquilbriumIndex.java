package com.david.algorithm;


public class EquilbriumIndex {
    
    public int find(int[] values) {
	// Calculate total sum
	int totalSum = 0;
	for (int value : values) {
	    totalSum += value;
	}
	
	int leftSum = 0;
	for (int index = 0; index < values.length; index++) {
	    int currentValue = values[index];
	    int rightSum = totalSum - leftSum - currentValue;
	    if (leftSum == rightSum) {
		return index;
	    }
	    leftSum += currentValue;
	}
	
	// Unable to find equilibrium index
	return -1;
    }
}
