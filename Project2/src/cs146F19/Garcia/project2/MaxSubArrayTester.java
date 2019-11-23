package cs146F19.Garcia.project2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxSubArrayTester {
	
	BruteForce bf;														// BruteForce object to use when testing brute force algorithm
	DivideAndConquer dc;												// DivideAndConquer object to use when testing divide and conquer algorithm
	KadaneAlgorithm ka;													// KadaneAlgorithm object to use when testing Kadane's algorithm
	ArrayList<MaxSubArray> solutions;									// ArrayList to hold solutions of object MaxSubArray when running file with multiple test cases
	
	File file;															// File object to pass in ArrayListCreator to test ArrayList creation method
	ArrayList<int[]> arrays;											// ArrayList of int arrays to store as a result from ArrayList creation
	
	@BeforeEach
	void setUp() {
		bf = new BruteForce();											// Initialize BruteForce object
		dc = new DivideAndConquer();									// Initialize DivideAndConquer object
		ka = new KadaneAlgorithm();										// Initialize KadaneAlgorithm object
		solutions = new ArrayList<>();									// Initialize solutions (clear ArrayList)
	}
	
	// Test brute force algorithm against provided test cases in text file
	@Test
	void testBruteForce() {
		solutions = bf.solve("data\\maxSumtest.txt");					// Set solutions to result of solving MaxSubArrays of all test cases in provided text file using brute force algorithm
		expectedFromTextFile();											// Check solutions for all test cases in provided text file
	}
	
	// Test divide and conquer algorithm against provided test cases in text file
	@Test
	void testDivideAndConquer() {
		solutions = dc.solve("data\\maxSumtest.txt");					// Set solutions to result of solving MaxSubArrays of all test cases in provided text file using divide and conquer algorithm
		expectedFromTextFile();											// Check solutions for all test cases in provided text file
	}
	
	// Test Kadane's algorithm against provided test cases in text file
	@Test
	void testKadane() {
		solutions = ka.solve("data\\maxSumtest.txt");					// Set solutions to result of solving MaxSubArrays of all test cases in provided text file using Kadane's algorithm
		expectedFromTextFile();											// Check solutions for all test cases in provided text file
	}
	
	// Test ArrayListCreator helper file (method used to create the array with all lines from the file)
	@Test
	void testArrayListCreator() {
		file = new File("data\\maxSumtest.txt");						// Initialize File object to path of maxSumtest.txt file (provided)
		arrays = ArrayListCreator.createArray(file);					// Set arrays to the result of function call on static method in ArrayListCreator java class createArray with file object as argument
		assertEquals(10, arrays.size());								// Verify arrays contains 10 test cases
		for (int[] a: arrays)
			assertEquals(100, a.length);								// Verify each array contains 100 elements
	}
	
	void expectedFromTextFile() {
		// Test Case 1 solution from maxSumtest.txt file provided
		assertEquals(239, solutions.get(0).getMax());
		assertEquals(77, solutions.get(0).getArrive());
		assertEquals(97, solutions.get(0).getDepart());
		
		// Test Case 2 solution from maxSumtest.txt file provided
		assertEquals(322, solutions.get(1).getMax());
		assertEquals(50, solutions.get(1).getArrive());
		assertEquals(99, solutions.get(1).getDepart());
		
		// Test Case 3 solution from maxSumtest.txt file provided
		assertEquals(305, solutions.get(2).getMax());
		assertEquals(17, solutions.get(2).getArrive());
		assertEquals(39, solutions.get(2).getDepart());
		
		// Test Case 4 solution from maxSumtest.txt file provided
		assertEquals(271, solutions.get(3).getMax());
		assertEquals(60, solutions.get(3).getArrive());
		assertEquals(98, solutions.get(3).getDepart());
		
		// Test Case 5 solution from maxSumtest.txt file provided
		assertEquals(281, solutions.get(4).getMax());
		assertEquals(54, solutions.get(4).getArrive());
		assertEquals(77, solutions.get(4).getDepart());
		
		// Test Case 6 solution from maxSumtest.txt file provided
		assertEquals(215, solutions.get(5).getMax());
		assertEquals(64, solutions.get(5).getArrive());
		assertEquals(99, solutions.get(5).getDepart());
		
		// Test Case 7 solution from maxSumtest.txt file provided
		assertEquals(207, solutions.get(6).getMax());
		assertEquals(38, solutions.get(6).getArrive());
		assertEquals(86, solutions.get(6).getDepart());
		
		// Test Case 8 solution from maxSumtest.txt file provided
		assertEquals(309, solutions.get(7).getMax());
		assertEquals(3, solutions.get(7).getArrive());
		assertEquals(48, solutions.get(7).getDepart());
		
		// Test Case 9 solution from maxSumtest.txt file provided
		assertEquals(195, solutions.get(8).getMax());
		assertEquals(34, solutions.get(8).getArrive());
		assertEquals(58, solutions.get(8).getDepart());
		
		// Test Case 10 solution from maxSumtest.txt file provided
		assertEquals(390, solutions.get(9).getMax());
		assertEquals(4, solutions.get(9).getArrive());
		assertEquals(45, solutions.get(9).getDepart());
	}
}
