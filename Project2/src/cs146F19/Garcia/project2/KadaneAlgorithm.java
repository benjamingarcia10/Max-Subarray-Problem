package cs146F19.Garcia.project2;

import java.io.File;
import java.util.ArrayList;

public class KadaneAlgorithm {
	ArrayList<int[]> testCases = new ArrayList<>();				// ArrayList to store all arrays of int for all test cases in a file
	File file;													// File object to read from text file for test cases
	ArrayList<MaxSubArray> multipleRes = new ArrayList<>();		// ArrayList to store MaxSubArray objects if there are multiple (in the case of multiple test cases from a file)
	
	// Solve maximum subarray problem using Kadane's algorithm on a single array
	public MaxSubArray solve(int[] array) {
		return kadane(array);
	}
	
	// Solve maximum subarray problem using Kadane's algorithm on a file containing multiple test cases
	public ArrayList<MaxSubArray> solve(String fileName) {
		file = new File(fileName);									// Create new file object using file name specified in function call
		testCases = ArrayListCreator.createArray(file);				// Create array using data array as the temp array and testCases as the output ArrayList for arrays of test cases
		for (int i = 0; i < testCases.size(); i++)					// For each array in testCases ArrayList, calculate max subarray using Kadane's algorithm
			multipleRes.add(kadane(testCases.get(i)));				// and store the result in an ArrayList of MaxSubArray objects
		return multipleRes;
	}
	
	// Kadane's algorithm to solve maximum subarray problem
	private MaxSubArray kadane(int[] array) {
		int maxSum = 0;												// Variable to store max sum initially set to 0 with no days selected
		int arrive = 0;												// Arrive set to 0 since no days selected initially
		int depart = 0;												// Depart set to 0 since no days selected initially
		int maxTemp = 0;											// Variable to store temp consecutive sum
		int tempArrive = 0;
		
		for (int i = 0; i < array.length; i++) {
			maxTemp += array[i];									// Add element with position i in array to maxTemp
			if (maxTemp < 0) {										// If the previous summation results in maxTemp being negative...
				maxTemp = 0;										// then set maxTemp = 0 and...
				arrive = i+1;										// increment arrive day
			}
			if (maxSum < maxTemp) {									// If the summation of maxTemp results in a higher value than the current maxSum...
				maxSum = maxTemp;									// Set maxSum to be maxTemp and...
				depart = i;											// set depart to current index of array and...
				tempArrive = arrive;								// set tempArrive to the arrive variable being moved by first if loop
			}
		}
		arrive = tempArrive;										// Set arrive to value of tempArrive (calculated by second if loop)
		return new MaxSubArray(maxSum, arrive, depart);				// Set result to a MaxSubArray object which holds the value of max sum, arrival date, and depart date
	}
}
