/*
/**
 * Julian Mayugba
 * Professor A
 * Java Programming Class
 * November 30, 2017
 * ------------------------
 * This program will read two numbers between the range of 0 and 100.  
 * After entering these numbers, the user is presented with a menu to choose what operation to perform.  
 * After each execution cycle, the user is presented with an option to repeat or terminate the program’s execution.  
 
package nov30;
import java.util.Scanner;

public class Nov30 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice ;
		double[] nums = new double[2];
		boolean runAgain;
		do {
			System.out.println("Welcome to the Methods Implementation Program");
			nums = input();
			System.out.println(1);
			System.out.print("Enter 1 for Additon\nEnter 2 for Subtraction\nEnter 3 for Division\nEnter 4 for Comparison\nEnter -1 to quit.\n");
			choice = input.nextInt();
			switch(choice) {
			case 1:
				// Addition Case
				addMethod(nums);
				break;
			case 2:
				// Subtraction Case
				subtractMethod(nums);
				break;
			case 3:
				// Divide Case
				divideMethod(nums);
				break;
			case 4:
				// Comparison Case
				compareMethod(nums);
				break;
			case -1:
				// Exit Case
				System.out.println("Closing Program");
				System.exit(0);
				break;
			default:
				// Failsafe Exit Case
				System.out.println("[Error] Invalid Input, ");
				System.exit(0);
				break;
			}
			System.out.println("Would you like to run again? Y/N");
			char run = Character.toUpperCase(input.nextLine().charAt(0));
			if(run == 'Y') {
				runAgain = true;
			}else {
				runAgain = false;
			}
		}while(runAgain = true);
		input.close();
	}
	
	private static double[] input() {
		double[] num = new double[2];
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < num.length;i++) {
			System.out.println("Enter a number between 0 and 100.");
			num[i] = input.nextDouble();
			while(num[i] < 0 && num[i] > 100) {
				System.out.println("[Error] Invalid Input.\nPlease try again.");
				num[i] = input.nextDouble();
			}
		}
		input.close();
		return num;
	}
	private static void addMethod(double[] nums) {
		double addedNum = 0;
		for(int i = 0; i < nums.length;i++) {
			addedNum += nums[i];
		}
		System.out.println("The sum is: " + addedNum);
	}
	private static void subtractMethod(double[] nums) {
		double num1 = nums[0], num2 = nums[1], numDifference = num1 - num2;
		System.out.println("The difference is: " + numDifference);
	}
	private static void divideMethod(double[] nums) {
		double num1 = nums[0], num2 = nums[1];
		if(num2 == 0) {
			System.out.println("[Error] Cannot divide by zero. ");
		}
		double dividedNum = num1 / num2;
		System.out.println("The quotient is: " + dividedNum);
	}
	private static void compareMethod(double[] nums) {
		double largestNum = 0, num1 = nums[0], num2 = nums[1];
		if(num1 > num2) {
			largestNum = num1;
			System.out.println("The Larger Number is: " + largestNum);
		}else if(num2 > num1) {
			largestNum = num2;
			System.out.println("The Larger Number is: " + largestNum);
		}else if(num1 == num2) {
			// Equivalent Numbers Case
			System.out.println("The numbers are equivalent.");
		}
	}
}
*/
