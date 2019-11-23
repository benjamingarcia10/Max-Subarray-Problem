package cs146F19.Garcia.project2;

public class MaxSubArray {
	private int max;				// Stores max sum of sub array
	private int arrive;				// Stores arrival date to achieve max sum
	private int depart;				// Stores depart date to achieve max sum
	
	// Object class to create a new object of MaxSubArray
	// Passes in 3 arguments: max, arrival date, and depart date
	// Stores it in the variables
	// Allows for returning multiple numbers
	public MaxSubArray(int max, int arrive, int depart) {
		this.max = max;
		this.arrive = arrive;
		this.depart = depart;
	}
	
	// Sets max of MaxSubArray object
	public void setMax(int max) {
		this.max = max;
	}
	
	// Sets arrival date of MaxSubArray object
	public void setArrive(int arrive) {
		this.arrive = arrive;
	}
	
	// Sets depart date of MaxSubArray object
	public void setDepart(int depart) {
		this.depart = depart;
	}
	
	// Returns max of MaxSubArray object
	public int getMax() {
		return max;
	}
	
	// Returns arrival date of MaxSubArray object
	public int getArrive() {
		return arrive;
	}
	
	// Returns depart date of MaxSubArray object
	public int getDepart() {
		return depart;
	}
	
	// Override Java's toString method to return a string giving max, arrival date, and depart date variables.
	public String toString() {
		return String.format("The max subarray is %d which is from arriving on day %d and leaving on day %d.", max, arrive, depart);
	}
}
