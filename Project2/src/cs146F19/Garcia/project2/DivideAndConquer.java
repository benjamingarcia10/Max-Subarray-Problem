package cs146F19.Garcia.project2;

import java.io.File;
import java.util.ArrayList;

public class DivideAndConquer {
	ArrayList<int[]> testCases = new ArrayList<>();								// ArrayList to store all arrays of int for all test cases in a file
	File file;																	// File object to read from text file for test cases
	ArrayList<MaxSubArray> multipleRes = new ArrayList<>();						// ArrayList to store MaxSubArray objects if there are multiple (in the case of multiple test cases from a file)
	
	// Solve maximum subarray problem using Divide and Conquer algorithm on a single array
	public MaxSubArray solve(int[] array) {
		return dCAlgorithm(array, 0, array.length-1);
	}
	
	// Solve maximum subarray problem using Divide and Conquer algorithm on a file containing multiple test cases
	public ArrayList<MaxSubArray> solve(String fileName) {
		file = new File(fileName);																// Create new file object using file name specified in function call
		testCases = ArrayListCreator.createArray(file);											// Create array using data array as the temp array and testCases as the output ArrayList for arrays of test cases
		for (int i = 0; i < testCases.size(); i++)												// For each array in testCases ArrayList, calculate max subarray using Divide and Conquer algorithm
			multipleRes.add(dCAlgorithm(testCases.get(i), 0, testCases.get(i).length-1));		// and store the result in an ArrayList of MaxSubArray objects
		return multipleRes;
	}
	
	// Divide and Conquer Algorithm
	private MaxSubArray dCAlgorithm(int[] array, int l, int r) {
		if (l == r)																					// Base Case: if left most element is the right most element...
			return new MaxSubArray(array[l], l, r);													// Return MaxSubArray object with max as element in array at left index and arrive = left index, depart = right index
		int mid = (l+r)/2;																			// Find midpoint
																									// 3 cases:
		MaxSubArray leftMax = dCAlgorithm(array, l, mid);											// 1) Maximum subarray sum is completely in the left half of the array
		MaxSubArray rightMax = dCAlgorithm(array, mid + 1, r);										// 2) Maximum subarray sum is completely in the right half of the array
		MaxSubArray crossMax = maxCrossingSum(array, l, mid, r);									// 3) Maximum subarray sum crosses across the midpoint of the array
		
		if (leftMax.getMax() >= rightMax.getMax() && leftMax.getMax() >= crossMax.getMax())			// Case 1 return
			return leftMax;
		else if (rightMax.getMax() >= leftMax.getMax() && rightMax.getMax() >= crossMax.getMax())	// Case 2 return
			return rightMax;
		else if (crossMax.getMax() >= leftMax.getMax() && crossMax.getMax() >= rightMax.getMax())	// Case 3 return
			return crossMax;
		return new MaxSubArray(0, 0, 0);															// No days selected if all cases result in negative
	}
	
	private MaxSubArray maxCrossingSum(int[] array, int l, int mid, int r) {
		// Left side of array
		int sum = 0;																			// Variable to hold entire sum of left side of array
		int leftSum = 0;																		// Variable to hold max left sum
		int leftMaxIndex = mid;																	// Variable to hold the max index for left part of crossing array
		for (int i = mid; i >= l; i--) {														// For every element from mid point all the way to the left:
			sum += array[i];																	// sum = sum + element of array at position i
			if (sum > leftSum) {																// If sum > leftSum
				leftSum = sum;																	// Set max left sum to value of sum
				leftMaxIndex = i;																// Set max index for left part of crossing array to be current index
			}
		}
		
		// Right side of array
		sum = 0;																				// Reset variable to 0, variable to hold entire sum of right side of array
		int rightSum = 0;																		// Variable to hold max right sum
		int rightMaxIndex = mid + 1;															// Variable to hold the max index for right part of crossing array
		for (int i = mid + 1; i<= r; i++) {														// For every element from mid point + 1 all the way to the right:
			sum += array[i];																	// sum = sum + element of array at position i
			if (sum > rightSum) {																// If sum > rightSum
				rightSum = sum;																	// Set max right sum to value of sum
				rightMaxIndex = i;																// Set max index for right part of crossing array to be current index
			}
		}
		return new MaxSubArray((leftSum + rightSum), leftMaxIndex, rightMaxIndex);				// Return MaxSubArray object with max sum as leftSum + rightSum, arrive to be leftMaxIndex, and depart to be rightMaxIndex
	}
}
