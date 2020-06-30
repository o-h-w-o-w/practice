package oct9;

import java.util.Scanner;

public class TestThing {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Choices:");
		System.out.println("1. ifStatements");
		System.out.println("2. logicalCompound");
		System.out.println("3. compareWays");
		System.out.println("4. salaryFormat");
		System.out.println("5. switchStatements");
		System.out.println("6. threeOperands");
		int choice = input.nextInt();

		switch(choice) {
		case 1:
			ifStatements();
			break;
		case 2:
			logicalCompound();
			break;
		case 3:
			compareWays();
			break;
		case 4:
			salaryFormat();
			break;
		case 5:
			switchStatements();
			break;
		case 6:
			threeOperands();
			break;
		default:
			break;
		}
		
	}

	private static int x = 1, y = 2;
	
	private static void ifStatements() {
		System.out.println("Starting ifStatements");

		//[A] A simple if statement
		if (x > y) {
			System.out.println("x is greater than y");
		}
		
		//[B] An if else statement
		if (x > y) {
			System.out.println("x is greater than y");
		}else {
			System.out.println("x is not greater than y");
		}
		
		//[C] A nested if statement
		if (x > y) {
			System.out.println("x is greater than y");
			if (x != 3) {
				System.out.println("and is not equal to 3");
			}
		}
	}
	
	private static void logicalCompound() {
		System.out.println("Starting logicalCompound");
		//[A] Write an example of a logical compound statement using the AND operator
		if (x > y && y != 3) {
			System.out.println("x is greater than y and y is not equal to 3");
		}
		//[B] Write an example of a logical compound statement using the OR operator
		if (x > y || y == 2) {
			System.out.println("Either x is greater than y");
			System.out.println("y is equal to 2");
			System.out.println("or both");
		}
		//[C] Explain what is meant by short cut evaluation when using either the AND or the OR operator.
		// Short cut evaluation [AND]
		// if one of the booleans are false, then there is no need to check the other booleans
		if (x > y && x == 3 && y == 2) {
			//the third comparison is not checked
		}
	}
	
	private static void compareWays() {
		// Declare 3 strings then write an if statement to compare any of the two declared strings using the following:
		//[A] The equalsTo class
		String test = "Test", test2 = "test";
		if (test.equals(test2)) {
			System.out.println("test1 == test2");
		}else {
			System.out.println("test1 != test2");
		}
		//[B] The comparesTo class
		System.out.println(test.compareTo(test2));
		//[C] == Operator
		if (test == test2) {
			System.out.println("test1 == test2");
		}else {
			System.out.println("test1 != test2");
		}
		
		//[D] equalsIgnoreCase
		if (test.equalsIgnoreCase(test2)) {
			System.out.println("test1 == test2");
		}else {
			System.out.println("test1 != test2");
		}
	}
	
	
	private static void salaryFormat() {
		System.out.println("Starting salaryFormat");
		double salary = 45125.45;
		// double salary = 45125.45 write the necessary formatted output statements to display the following
		//[A] Her Salary =           45125.45 (10 spaces between the = sign and the number)
		System.out.printf("Her Salary = %18.2f\n", salary);
		//[B] Her Salary = $45,125.45 (no spaces after the = sign)
		System.out.printf("Her Salary =$%,.2f\n", salary);
		//[C] Her Salary = $45125.5 (2 spaces after the = sign)
		System.out.printf("Her Salary =$%9.1f\n", salary);
	}
	
	private static void switchStatements() {
		System.out.println("Starting switchStatements");
		// Is it important to have a break after every case in the switch statement?
		// -- No
		//Switch Statement 1
		switch(x) {
			case 1:
			case 2:
			case 3:
				System.out.println("This switch statement went through cases 1-3");
				break;
			default:
				break;
		}
		//Switch Statement 2
		switch(x) {
			case 1:
				System.out.println("Only runs case 1");
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}
	}
	
	private static void threeOperands() {
		//Rewrite the if else statemnet in question 1b using hte format ternary conditional operator
		/*if (x > y) {
			System.out.println("x is greater than y");
		}else {
			System.out.println("x is not greater than y");
		} */
		String test = ((x>y)?"x is greater than y":"x is not greater than y");
		System.out.println(test);
	}
}
