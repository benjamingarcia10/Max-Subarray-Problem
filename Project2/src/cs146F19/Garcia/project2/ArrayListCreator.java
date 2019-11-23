package cs146F19.Garcia.project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListCreator {
	
	// HELPER METHOD USED IN ALL ALGORITHMS
	// Method to create the array with all lines from the file.
	// GIVEN:
	// 1) First 100 numbers on a line = 1 test case
	// 2) 1 empty line per test case
	public static ArrayList<int[]> createArray(File file) {
		ArrayList<int[]> cases = new ArrayList<>();
		try {
			FileReader fr = new FileReader(file);					// Create FileReader with file passed in function call
			BufferedReader br = new BufferedReader(fr);				// Create BufferedReader based on FileReader
			int[] temp;
			String[] res;											// Array of strings to store each number in a line from the passed in file
			String line = br.readLine();							// Set line = first line of the document
			while (line != null) {									// Loop while there are lines that have not been read
				temp = new int[100];								// Set temp array to size 100 (amount of numbers per test case)
				line = line.trim();									// Remove leading and ending spaces from line
				res = line.split("\\s+");							// Set array of strings to be the line split with regex \s+
				for (int i = 0; i < temp.length; i++)				// Add all elements from string array to the temp array converted to integers
					temp[i] = Integer.parseInt(res[i]);
				cases.add(temp);									// Add the temp array to ArrayList named cases
				br.readLine();										// Read line to skip over empty line in file
				line = br.readLine();								// Set line to next line
			}
			br.close();												// Close buffered reader
			fr.close();												// Close file reader
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cases;												// Return ArrayList holding multiple integer arrays (each array is one test case)
	}
}