/**
 * Julian Mayugba
 * Professor A
 * Java Programming Class
 * November 30, 2017
 * ------------------------
 * This program will read two numbers between the range of 0 and 100.  
 * After entering these numbers, the user is presented with a menu to choose what operation to perform.  
 * After each execution cycle, the user is presented with an option to repeat or terminate the program’s execution.  
 */
import java.util.InputMismatchException;

import java.util.Scanner;

public class MethodsProgram {
	/* Final Divider String */
	private final static String divider = "\n====================================\n";
	
	/* Main Method Start */
	public static void main(String[] args) {
		// Variable Declaration 
		char repeatChoice = 0;
		int menuChoice = 0;
		double[] nums = new double[2];
		
		// Scanner Object Creation
		Scanner input = new Scanner(System.in);
		
		// Welcome Message
		System.out.println("Welcome to the Methods Implementation Program.");
		
		// Initial Do While Loop
		do {
			// Do While Loop Menu Selection + Verification
			do {
				try {
					System.out.println(divider);
					System.out.println("Menu:");
					System.out.println("1. Addition");
					System.out.println("2. Subtraction");
					System.out.println("3. Division");
					System.out.println("4. Comparison");
					System.out.println("5. Exit");
					System.out.print("Choice:  ");
					menuChoice = input.nextInt();
					if(menuChoice < 0 || menuChoice > 5) {
						System.out.println("[Error] Invalid Selection");
					}
				} catch (InputMismatchException e) {
					System.out.print(divider);
					System.out.print("[Error] Invalid Selection.");
				}
				input.nextLine();
			}while (menuChoice <= 0);
			// Menu Choice Switch
			switch(menuChoice) {
				case 1:
					// Addition Case
					nums = input();
					addMethod(nums);
					break;
				case 2:
					// Subtraction Case
					nums = input();
					subtractMethod(nums);
					break;
				case 3:
					// Division Case
					nums = input();
					divisionMethod(nums);
					break;
				case 4:
					// Comparison Case
					nums = input();
					compareMethod(nums);
					break;
				case 5:
					// Exit Case
					System.out.println("Exiting Program.");
					System.exit(0);
					break;
				default:
					// Default Case
					System.out.println("Exiting Program.");
					System.exit(0);
					break;
			}
			System.out.println("Would you like to run the program again? Y/N");
			repeatChoice = Character.toUpperCase(input.nextLine().charAt(0));
			
			/* End of Main Method */
		}while(repeatChoice == 'Y');
		System.out.println("Exiting Program.");
	}
	/* Input Method Start */
	private static double[] input() {
		//Double Array size of 2
		double[] nums = new double[2];
		Scanner input = new Scanner(System.in);
		//User Input
		for(int i = 0; i < nums.length; i++) {
			// Catch Input Mismatch
			try {
				System.out.println("Enter a number between 0 and 100.");
				nums[i] = input.nextDouble();
				while(nums[i] < 0.0 || nums[i] > 100.0) {
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
		/* Input Method Ends */
	}
	/* Add Method Start */
	private static void addMethod(double[] nums) {
		double numAdded = nums[0] + nums[1];
		// Display Result
		System.out.println(nums[0] + " + " + nums[1] + " = " + numAdded);
		/* Subtract Method End */
	}
	/* Subtract Method Start */
	private static void subtractMethod(double[] nums) {
		double numSubtracted = nums[0] - nums[1];
		// Display Result
		System.out.println(nums[0] + " - " + nums[1] + " = " + numSubtracted);
		/* Subtract Method End */
	}
	/* Division Method Start */
	private static void divisionMethod(double[] nums) {
		double num1 = nums[0], num2 = nums[1];
		if(num2 == 0) {
			// User Enters Zero for Num2
			System.out.println("[Error] Cannot divide by zero.");
		}else {
			// Display Result
			System.out.println(num1 + " / " + num2 + " = " + num1/num2);
		}
		/* Division Method End */	
	}
	/* Compare Method Start */
	private static void compareMethod(double[] nums) {
		double num1 = nums[0], num2 = nums[1], largestNum = 0;
		if(num1 > num2) {
			// Num 1 Larger Case
			largestNum = num1;
			System.out.println("The larger number is: " + largestNum);
		}else if (num1 < num2) {
			// Num 2 Larger Case
			largestNum = num2;
			System.out.println("The larger number is: " + largestNum);
		}else if (num1 == num2) {
			// Same Number Case
			System.out.println("The numbers are the same.");
		}
		
		/* Compare Method End */
	}
}
