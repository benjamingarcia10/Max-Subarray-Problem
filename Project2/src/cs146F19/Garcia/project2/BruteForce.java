package cs146F19.Garcia.project2;

import java.io.File;
import java.util.ArrayList;

public class BruteForce {
	ArrayList<int[]> testCases = new ArrayList<>();								// ArrayList to store all arrays of int for all test cases in a file
	File file;																	// File object to read from text file for test cases
	MaxSubArray result;															// Object for result from brute force algorithm (returns max sum, arrival, and depart)	
	ArrayList<MaxSubArray> multipleRes = new ArrayList<>();						// ArrayList to store MaxSubArray objects if there are multiple (in the case of multiple test cases from a file)
	
	// Solve maximum subarray problem using brute force algorithm on a single array
	public MaxSubArray solve(int[] array) {
		return bruteForce(array);
	}
	
	// Solve maximum subarray problem using brute force algorithm on a file containing multiple test cases
	public ArrayList<MaxSubArray> solve(String fileName) {
		file = new File(fileName);												// Create new file object using file name specified in function call
		testCases = ArrayListCreator.createArray(file);							// Create array using data array as the temp array and testCases as the output ArrayList for arrays of test cases
		for (int i = 0; i < testCases.size(); i++)								// For each array in testCases ArrayList, calculate max subarray using brute force algorithm
			multipleRes.add(bruteForce(testCases.get(i)));						// and store the result in an ArrayList of MaxSubArray objects
		return multipleRes;
	}
	
	// Brute force algorithm to solve maximum subarray problem
	private MaxSubArray bruteForce(int[] array) {
		result = new MaxSubArray(0, 0, 0);										// Set initial result to be sum of 0 with no days selected (arrive and depart = 0)
		int max = 0;															// Variable to contain max value from both nested for loops
		int tempSum = 0;														// Variable to contain max value from inner for loop
		for (int arrive = 0; arrive < array.length; arrive++) {					// Pick arrival date
			tempSum = 0;														// Reset tempSum to 0 to prepare for new cycle of inner for loop
			for (int depart = arrive; depart < array.length; depart++) {		// Cycle through departure dates
				tempSum += array[depart];										// tempSum = tempSum + next array element
				if (tempSum > max) {											// If tempSum is greater than max value from both nested for loops, set max value to value of tempSum
					max = tempSum;
					result.setArrive(arrive);									// Set current combination of arrival date and...
					result.setDepart(depart);									// depart date and...
					result.setMax(max);											// its sum value
				}
			}
		}
		return result;															// Return MaxSubArray object which stores values of max sum, arrival date, and depart date
	}
}
