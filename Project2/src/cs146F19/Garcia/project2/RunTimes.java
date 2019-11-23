package cs146F19.Garcia.project2;

import java.util.Random;

public class RunTimes {
	BruteForce bf;														// BruteForce object to use when calculating run time on brute force algorithm
	DivideAndConquer dc;												// BruteForce object to use when calculating run time on divide and conquer algorithm
	KadaneAlgorithm ka;													// BruteForce object to use when calculating run time on Kadane's algorithm
	
	int[] temp;															// Temp array used to create random array
	int[] testCase;														// Array used to hold test case being run
	long startTime;														// Start Time of Algorithm
	long endTime;														// End Time of Algorithm
	long runTime;														// Calculated Run Time of Algorithm
	
	public void bfRunTime(int n) {
		startTime = 0;														// Reset startTime = 0
		endTime = 0;														// Reset endTime = 0
		runTime = 0;														// Reset runTime = 0
		bf = new BruteForce();												// Initialize BruteForce object
		for (int i = 1; i <= 50; i++) {										// Do this for 10 cases:
			testCase = randomArray(n);										// 1) Create a random array of size n using randomArray method
			startTime = System.nanoTime();									// 2) Set current time in nano seconds to start time
			bf.solve(testCase);												// 3) Run brute force algorithm
			endTime = System.nanoTime();									// 4) Set current time in nano seconds to end time
			runTime += (endTime - startTime);								// 5) Add run time for that one test case to runTime variable
		}
		System.out.printf("Size n = %d: Runtime = %d\n", n, runTime/50);	// Print average of runTime (runTime/10) of the 10 test cases
	}
	
	public void dcRunTime(int n) {
		startTime = 0;														// Reset startTime = 0
		endTime = 0;														// Reset endTime = 0
		runTime = 0;														// Reset runTime = 0
		dc = new DivideAndConquer();										// Initialize DivideAndConquer object
		for (int i = 1; i <= 50; i++) {										// Do this for 10 cases:
			testCase = randomArray(n);										// 1) Create a random array of size n using randomArray method
			startTime = System.nanoTime();									// 2) Set current time in nano seconds to start time
			dc.solve(testCase);												// 3) Run divide and conquer algorithm
			endTime = System.nanoTime();									// 4) Set current time in nano seconds to end time
			runTime += (endTime - startTime);								// 5) Add run time for that one test case to runTime variable
		}
		System.out.printf("Size n = %d: Runtime = %d\n", n, runTime/50);	// Print average of runTime (runTime/10) of the 10 test cases
	}
	
	public void kaRunTime(int n) {
		startTime = 0;														// Reset startTime = 0
		endTime = 0;														// Reset endTime = 0
		runTime = 0;														// Reset runTime = 0
		ka = new KadaneAlgorithm();											// Initialize KadaneAlgorithm object
		for (int i = 1; i <= 50; i++) {										// Do this for 10 cases:
			testCase = randomArray(n);										// 1) Create a random array of size n using randomArray method
			startTime = System.nanoTime();									// 2) Set current time in nano seconds to start time
			ka.solve(testCase);												// 3) Run Kadane's algorithm
			endTime = System.nanoTime();									// 4) Set current time in nano seconds to end time
			runTime += (endTime - startTime);								// 5) Add run time for that one test case to runTime variable
		}
		System.out.printf("Size n = %d: Runtime = %d\n", n, runTime/50);	// Print average of runTime (runTime/10) of the 10 test cases
	}
	
	// Returns an array of size n with random integers from -100 to 100
	public int[] randomArray(int n) {
		temp = new int[n];												// Initialize temp array to be an array of size n
		Random rand = new Random();										// Create random object with unspecified seed
		for (int i = 0; i < temp.length; i++)							// For every element in temp array:
			temp[i] = rand.nextInt(201) - 100;							// temp[i] = random int from -100 to 100
		return temp;													// Return newly created random array
	}
	
	public static void main(String[] args) {
		RunTimes run = new RunTimes();
		
		System.out.println("Brute Force Algorithm Run Times");
		run.bfRunTime(100);												// Calculate and print brute force algorithm run time for size 100
		run.bfRunTime(200);												// Calculate and print brute force algorithm run time for size 200
		run.bfRunTime(500);												// Calculate and print brute force algorithm run time for size 500
		run.bfRunTime(1000);											// Calculate and print brute force algorithm run time for size 1000
		run.bfRunTime(2000);											// Calculate and print brute force algorithm run time for size 2000
		run.bfRunTime(5000);											// Calculate and print brute force algorithm run time for size 5000
		run.bfRunTime(10000);											// Calculate and print brute force algorithm run time for size 10000
		System.out.println();
		
		System.out.println("Divide and Conquer Algorithm Run Times");
		run.dcRunTime(100);												// Calculate and print divide and conquer algorithm run time for size 100
		run.dcRunTime(200);												// Calculate and print divide and conquer algorithm run time for size 200
		run.dcRunTime(500);												// Calculate and print divide and conquer algorithm run time for size 500
		run.dcRunTime(1000);											// Calculate and print divide and conquer algorithm run time for size 1000
		run.dcRunTime(2000);											// Calculate and print divide and conquer algorithm run time for size 2000
		run.dcRunTime(5000);											// Calculate and print divide and conquer algorithm run time for size 5000
		run.dcRunTime(10000);											// Calculate and print divide and conquer algorithm run time for size 10000
		System.out.println();
		
		System.out.println("Kadane's Algorithm Run Times");
		run.kaRunTime(100);												// Calculate and print Kadane's algorithm run time for size 100
		run.kaRunTime(200);												// Calculate and print Kadane's algorithm run time for size 200
		run.kaRunTime(500);												// Calculate and print Kadane's algorithm run time for size 500
		run.kaRunTime(1000);											// Calculate and print Kadane's algorithm run time for size 1000
		run.kaRunTime(2000);											// Calculate and print Kadane's algorithm run time for size 2000
		run.kaRunTime(5000);											// Calculate and print Kadane's algorithm run time for size 5000
		run.kaRunTime(10000);											// Calculate and print Kadane's algorithm run time for size 10000
	}
}
