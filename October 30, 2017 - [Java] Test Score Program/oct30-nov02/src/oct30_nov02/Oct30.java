package oct30_nov02;
/* Julian Mayugba
 * Professor A
 * ORIGNAL[November 2, 2017]
 * Java Programming Class
 * This program will ask the user for 10 First, Middle, Last Names and 30 Test Scores.
 * The program will find the minimum, maximum, and average of these test scores and display them.
 */

 /* FILE OUTPUT/READ EDIT
  * November 16, 2017
 */
import java.util.Scanner;


public class Oct30 {
	//[Static Fixed Array Size]
	private final static int size = 10;

	//[Static Arrays]
	static String[] firstName = new String[size];
	static String[] lastName = new String[size];
	static char[] middleInitial = new char[size];
	static double[] testOne = new double[size];
	static double[] testTwo= new double[size];
	static double[] testThree = new double[size];
	static double[] testAverage = new double[size];
	static Scanner input = new Scanner(System.in);
	//[Main Method]
	public static void main(String[] args) {
		//[Choice Variable]
		String choice;
		//[choice: write to file/read from file]
		System.out.println("Welcome to the test avg program.");
		System.out.println("Would you like to read a file or write a file?");
		System.out.println("Type 'Read', 'Write', or 'Quit'");
		choice = input.nextLine().toUpperCase();
		//[Choice Input Validation]
		while(choice != "READ" && choice != "WRITE" && choice != "QUIT") {
			System.out.println("Invalid Input.\nPlease try again.");
		}
		//[Choice to Method]
		if(choice=="READ") {
			//[Read Files and Output Method]
			/* Needed Files
			 * firstName
			 * middleInitial
			 * lastName
			 * testOne
			 * testTwo
			 * testThree
			 * testAverage
			 * test min
			 * test max
			 * test avg
			 */
		}else if(choice=="WRITE") {
			//[Write to File and Output Method]
			writetoFile();
		}else {
			//[Quit Case]
			System.out.println("Quitting program.");
			System.exit(0);
		}
		input.close();
		//[END OF main METHOD]
	}

	//[Write to File Method]
	private static void writetoFile(){
		//[Varable Delcaration]
		double avg = 0, min = 0, max = 0;
		//[User Input Loop]
		for(int i = 0; i < size; i++) {
			//[Name Input]
			System.out.printf("\nEnter Student %d's First Name:\n", i);
			firstName[i] = input.next();
			System.out.printf("\nEnter Student %d's Middle Initial:\n", i);
			middleInitial[i] = input.next().charAt(0);
			System.out.printf("\nEnter Student %d's Last Name:\n", i);
			lastName[i] = input.next(); //nextLine skips scanner after next().charAt(0);
			
			//[Test 1 Score Input]
			System.out.printf("Enter %s %s. %s First Test Score:\n", firstName[i], Character.toUpperCase(middleInitial[i]), lastName[i]);
			testOne[i] = input.nextDouble();
			
			//[Test 1 Input Validation]
			while(!(testOne[i] >= 0 && testOne[i] <= 100)) {
				System.out.println("[Error] Invalid Input. Please try again.");
				testOne[i] = input.nextDouble();
			}	
			
			//[Test 2 Score Input]
			System.out.printf("Enter %s %s. %s Second Test Score:\n", firstName[i], Character.toUpperCase(middleInitial[i]), lastName[i]);
			testTwo[i] = input.nextDouble();
			
			//[Test 2 Input Validation]
			while(!(testTwo[i] >= 0 && testTwo[i] <= 100)) {
				System.out.println("[Error] Invalid Input. Please try again.");
				testTwo[i] = input.nextDouble();
			}
			//[Test 3 Score Input]
			System.out.printf("Enter %s %s. %s Third Test Score:\n", firstName[i], Character.toUpperCase(middleInitial[i]), lastName[i]);
			testThree[i] = input.nextDouble();
			
			//[Test 3 Input Validation]
			while(!(testThree[i] >= 0 && testThree[i] <= 100)) {
				System.out.println("[Error] Invalid Input. Please try again.");
				testThree[i] = input.nextDouble();
			}
			//[Average]
			testAverage[i] = (testOne[i] + testTwo[i] + testThree[i]) / 3;
		}	
		//[To Max/Min/Avg Methods]
		max = findMax(testAverage);
		min = findMin(testAverage);
		avg = findAvg(testAverage);

		//[Display Table]
		displayTable(firstName, lastName, middleInitial, testOne, testTwo, testThree, testAverage, min, max, avg);
		//[END OF writeToFile METHOD]
	}
	//[Find Max Method]
	private static double findMax(double[] testAverage) {
		double max = -9999;
		//[For Loop Sequential Search]
		for(int i = 0; i < size; i++) {
			if(testAverage[i] > max) {
				max =  testAverage[i];
			}
		}
		return max;
		//[END OF findMax METHOD]
	}
	//[Find Min Method]
	private static double findMin(double[] testAverage) {
		double min = 9999;
		//[For Loop Sequential Search]
		for(int i = 0; i < size; i++) {
			if(testAverage[i] < min) {
				min = testAverage[i];
			}
		}
		return min;
		//[END OF findMin METHOD]
	}
	//[Find Avg Method]
	private static double findAvg(double[] testAverage) {
		double avg = 0, tempAccu = 0;
		//[For Loop Accumulator]
		for(int i = 0; i < size; i++) {
			tempAccu += testAverage[i];
		}
		avg = tempAccu / size;
		return avg;
		//[END OF findAvg METHOD]
	}
	//[Display Table Method]
	private static void displayTable(String[] firstName, String[] lastName, char[] middleInitial, double[] testOne, double[] testTwo, double[] testThree, double[] testAverage, double min, double max, double avg) {
		System.out.println("First\tMiddle\tLast\tTest1\tTest2\tTest3\tAverage");
		System.out.println("-----\t------\t----\t-----\t-----\t-----\t-------");
		for(int i = 0; i < size; i++) {
			System.out.printf("\n%s\t%s\t%s\t%.2f\t%.2f\t%.2f\t%.2f \t\n", firstName[i], Character.toUpperCase(middleInitial[i]), lastName[i], testOne[i], testTwo[i], testThree[i], testAverage[i]);
		}
		System.out.printf("\nClass Maximum Avg:\t %.2f\n",max);
		System.out.printf("\nClass Minimum Avg:\t %.2f\n",min);
		System.out.printf("\nClass Average:\t %.2f\n",avg);
		//[END OF displayTable METHOD]
	}
}
