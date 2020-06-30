/* Julian Mayugba
 * Professor A
 * October 26, 2017
 * Population Program
 * This program will ask the user to enter a starting amount 
 */

package oct26;

import java.util.Scanner;

public class Population {

	public static void main(String[] args) {
		//Variable Declaration
		int startSize=0,days=0;
		double popIncrease=0;
		//Scanner object
		Scanner input=new Scanner(System.in);
		//Start
		System.out.println("Welcome to the Population Prediction Program");
		//Size Input
		System.out.println("Please enter the starting amount of organisms: ");
		startSize=input.nextInt();
		//Size Input Validation
		while(startSize<2) {
			System.out.println("[Error] Starting amout must be greater or equal to 2\nPlease try again.");
			startSize=input.nextInt();
		}
		//No. Days Input
		System.out.println("Please enter the amount of days to multiply: ");
		days=input.nextInt();
		//No. Days Input Validation
		while(days<1) {
			System.out.println("[Error] Days cannot be less than 1.\nPlease try again.");
			days=input.nextInt();
		}
		//Population Increase Input
		System.out.println("Please enter the average daily population increase as a percentage without %.");
		popIncrease=input.nextDouble();
		//Population Increase Input Validation
		while(popIncrease<0) {
			System.out.println("[Error] Population increase cannot be less than 0.\nPlease try again.");
			popIncrease=input.nextDouble();
		}
		//Closing Scanner
		input.close();
		//Converting percentage to decimal
		popIncrease=popIncrease/100;
		System.out.println(popIncrease);
		//To popCalc Method
		popCalc(startSize,days,popIncrease);
	}
	private static void popCalc(int popSize,int popDays,double popIncrease) {
		//Variable used for accumulating 
		int popHold=popSize;
		System.out.println("Initial Population: "+popSize);
		for(int x=1;x<=popDays;x++) {
			popHold+=(popHold*popIncrease);
			System.out.println("Day: "+x+" Population: "+popHold);
			
		}
	}

}
