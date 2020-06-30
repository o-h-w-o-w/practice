/**
 * Julian Mayugba
 * Professor A
 * Java Programming Class
 * December 4, 2017
 * 
 * This program will enable the user to enter 10 numbers into an array.
 * The numbers must be between 5 and 1000.
 * After recieving the numbers, this program will:
 * 1. Find the Largest Element in the Array.
 * 2. Find the Smallest Element in the Array.
 * 3. Add all the array elements.
 * 4. Display All.
 */


import java.util.InputMismatchException;
import java.util.Scanner;

public class Dec4 {
	private final static String divider = "=======================================";
	
	/* Start of main Method */
	public static void main(String[] args) {
		// Variable Declaration
		double[] nums = new double[10];
		double largest = 0, smallest = 0, sum = 0;
		
		// Introduction
		System.out.println(divider);
		System.out.println("Welcome.");
		System.out.println("This program will:");
		System.out.println("Find the Largest Element in the Array.");
		System.out.println("Find the Smallest Element in the Array.");
		System.out.println("Add all the array elements.");
		System.out.println("And Display All.");
		System.out.println(divider);
		
		// To input Method
		nums = input();
		
		// To findLargest Method
		largest = findLargest(nums);
		
		// To findSmallest Method
		smallest = findSmallest(nums);
		
		// To addAll Method
		sum = addAll(nums);
		
		// To displayAll Method
		displayAll(nums, largest, smallest, sum);
	}
	/* Start of input Method */
	private static double[] input() {
		double[] nums = new double[10];
		Scanner input = new Scanner(System.in);
		//User Input
		for(int i = 0; i < nums.length; i++) {
			// Catch Input Mismatch
			try {
				System.out.println("Enter a number between 5 and 1000.");
				nums[i] = input.nextDouble();
				while(nums[i] < 5.0 || nums[i] > 1000.0) {
					System.out.println("[Error] Invalid Input.\nPlease try again.");
					nums[i] = input.nextDouble(); 
				}
			} catch (InputMismatchException e){
				System.out.println("[Error] Invalid Input.\nPlease try again.");
				// Decrement 1 on invalid input
				i--;
			}
			// Clear Buffer
			input.nextLine();
		}
		// Return Nums Array
		return nums;
	}
	/* Start of findLargest Method */
	private static double findLargest(double[] input) {
		// Largest Variable Declaration
		double largest = 0;
		// For Loop Largest Check
		for(int i = 0; i < input.length; i++) {
			if(input[i] > largest) {
				largest = input[i];
			}
		}
		// Return Largest Value
		return largest;
	}
	/* Start of findSmallest Method */
	private static double findSmallest(double[] input) {
		// Smallest Variable Declaration
		double smallest = 1001;
		// For Loop Smallest Check
		for(int i = 0; i < input.length; i++) {
			if(input[i] < smallest) {
				smallest = input[i];
			}
		}
		// Return Smallest Value
		return smallest;
	}
	/* Start of addAll Method */
	private static double addAll(double[] input) {
		// Accumulator Variable Declaration
		double sum = 0;
		// For Loop Accumulator
		for(int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		// Return Sum
		return sum;
	}
	/* Start of displayAll Method */
	private static void displayAll(double[] input, double largest, double smallest, double sum) {
		// Display All Array Elements
		System.out.println("Array Elements:");
		for(int i = 0; i < input.length; i++) {
			System.out.printf("|%d| %.2f |", i, input[i]);
		}
		// Display Largest
		System.out.printf("\nLargest Element: %.2f ", largest);
		
		// Display Smallest
		System.out.printf("\nSmallest Element: %.2f ", smallest);
		
		// Display Sum of All Numbers
		System.out.printf("\nSum of all Elements: %.2f ", sum);

	}
}
