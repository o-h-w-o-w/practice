
/* Julian Mayugba
 * Professor A
 * October 26, 2017
 * Population Program
 * This program will ask the user to enter a starting amount of organisms
 * + Predict future population size
 * + Print to File
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProject {

	public static void main(String[] args) throws IOException {
		//Variable Declaration
		int startSize=0,days=0,readOrWrite=0;
		double popIncrease=0;
		//Scanner object
		Scanner input=new Scanner(System.in);
		//Start
		System.out.println("Welcome to the Population Prediction Program");
		System.out.println("[Options]\n(1)Read from File\n(2)Write to File\n(3)Quit");
		readOrWrite=input.nextInt();
		while(readOrWrite!=1 && readOrWrite!=2 && readOrWrite!=3) {
			System.out.println("[Error] Invalid Input.\nPlease try again.");
			readOrWrite=input.nextInt();
		}
		switch(readOrWrite) {
		case 1: // read
			System.out.println("Enter File Name: ");
			String fileName = input.next();
			File file = new File(fileName);
			//to display file method
			displayFile(file);
			break;
		case 2: // write
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
			break;
		case 3: // quit
			System.out.println("Exiting Program.");
			System.exit(0);
			break;
		}

	}
	private static void popCalc(int popSize,int popDays,double popIncrease) throws IOException {
		FileWriter fw = new FileWriter("popCalc.txt",true);
		PrintWriter outputFile = new PrintWriter(fw);
		//Variable used for accumulating 
		int popHold=popSize;
		System.out.println("Initial Population: "+popSize);
		for(int i=1;i<=popDays;i++) {
			popHold+=(popHold*popIncrease);
			System.out.println("Day: "+i+" Population: "+popHold);
			outputFile.println("Day: "+i+" Population: "+popHold);
		}
		outputFile.close();
		
	}
	private static void displayFile(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		while(input.hasNext()) {
			String temp = input.nextLine();
			System.out.println(temp);
		}
		input.close();
	}

}
