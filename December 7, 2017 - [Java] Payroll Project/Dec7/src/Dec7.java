/**
 * Julian Mayugba
 * Professor A
 * Java Programming Class
 * December 7, 2017
 * Payroll Project
 * This program will create a payroll report.
 * 
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dec7 {
	/* Constant Tax/Fee Declaration */ 
	private static final double stateTax = 0.06, federalTax = 0.12, unionFees = 0.01;
	private static final String divider = "=================================";
	
	/* Scanner Object Creation */	
	private	static Scanner input = new Scanner(System.in);

	/* Start of Main Method */
	public static void main(String[] args) {
		// Variable Declaration
		int numEmployees = 0;

		// Greeting
		System.out.println(divider);
		System.out.println("Data Housing Corp Payroll Program");
		System.out.println(divider);
		
		// User Input: Number of Employees
		System.out.println("Enter amount of employees: ");
		do {
			try {
				numEmployees = input.nextInt();
				while(numEmployees <= 0) {
					System.out.println("[Error] Number of Employees cannot be less than or equal to zero..");
					try {
						numEmployees = input.nextInt();
					}catch (InputMismatchException e) {
						// User Enters Invalid Input
						System.out.printf("[Error] Invalid Input.\nTry Again.\n");
					}
					// Reset Scanner Buffer
					input.nextLine();
				}
			}catch (InputMismatchException e) {
				// User Enters Invalid Input
				System.out.printf("[Error] Invalid Input.\nTry Again.\n");
			}
			// Reset Scanner Buffer
			input.nextLine();
		}while(numEmployees <= 0);
		
		// Array Declaration
		// | 0 hours worked | 1 overtimeHours |
		int[][] hours = new int[numEmployees][2];
		// | 0 first | 1 middle | 2 last | 4 id |
		String[][] names = new String[numEmployees][4];
		// | 0 rate | 1 gross | 2 net gross | 3 overtime | 4 state tax | 5 fed tax | 6 union fees | 7 total gross | 8 average gross |
		double[][] money = new double[numEmployees][9];

		for(int i = 0; i < numEmployees; i++) {
			// First Name Input
			names[i][0] = firstName(i);
			// Middle Name Input
			names[i][1] = middleName(i);
			// Last Name Input
			names[i][2] = lastName(i);
			// ID Input
			names[i][3] = idNo(i);
			// Hours Worked Input
			hours[i][0] = hoursWorked(i);
			// Rate Input
			money[i][0] = employeeRate(i);
			
			// Overtime Hours 
			if(hours[i][0] > 40) {
				hours[i][1] = hours[i][0] - 40;
			}
			
			// Calculate Gross
			money[i][1] = grossCalc(money, hours, i);
			// Calculate Overtime
			money[i][3] = overtimeCalc(money, hours, i);
			// Calculate State Tax
			money[i][4] = stateTax(money, i);
			// Calculate Federal Tax
			money[i][5] = fedTax(money, i);
			// Calculate Union Fees
			money[i][6] = unionFees(money, i);
			// Calculate Net Gross
			money[i][2] = netGross(money, i);
		}
		// Calculate Total Gross
		money[0][7] = totalGross(money);
		// Calculate Average Gross
		money[0][8] = averageGross(money, numEmployees);
		// Display All
		displayAll(money, hours, names);
	}
	
	/* Start of First Name Input Method */
	private static String firstName(int i) {
		String firstName = null;
		System.out.printf("[Input] Enter Employee %d's First Name:\n", i);
		firstName = input.nextLine();
		return firstName;
	}/* End of First Name Input Method */
	
	/* Start of Middle Name Input Method */
	private static String middleName(int i) {
		String middleName = null;
		System.out.printf("[Input] Enter Employee %d's Middle Name:\n", i);
		middleName = Character.toString(input.nextLine().charAt(0));
		return middleName;
	}/* End of middle Name Input Method */
	
	/* Start of Last Name Input Method */
	private static String lastName(int i) {
		String lastName = null;
		System.out.printf("[Input] Enter Employee %d's Last Name:\n", i);
		lastName = input.nextLine();
		return lastName;
	}/* End of last Name Input Method */
	
	/* Start of ID Input Method */
	private static String idNo(int i) {
		String idNo = null;
		System.out.printf("[Input] Enter Employee %d's ID Number:\n", i);
		idNo = input.nextLine();
		return idNo;
	}/* End of idNo Method */
	
	/* Start of Hours Worked Input Method */
	private static int hoursWorked(int i) {
		int hoursWorked = 0;
		System.out.printf("[Input] Enter Employee %d's Hours Worked:\n", i);
		do {
			try {
				hoursWorked = input.nextInt();
				while(hoursWorked <= 0 || hoursWorked >= 60) {
					System.out.println("[Error] Hours Worked cannot be less than or equal to zero or greater than or equal to 60.");
					try {
						hoursWorked = input.nextInt();
					}catch(InputMismatchException e) {
						// User entered invalid input 
						System.out.println("[Error] Invalid Number.\nTry Again.\n");
					}
					// Reset Input Buffer
					input.nextLine();
				}
			}catch(InputMismatchException e) {
				// User entered invalid input 
				System.out.println("[Error] Invalid Number.\nTry Again.\n");
			}
			// Reset Input Buffer
			input.nextLine();
		}while(hoursWorked <= 0);
		return hoursWorked;
	}/* End of hoursWorked Method */
	
	/* Start of Hourly Rate Input Method */
	private static double employeeRate(int i) {
		double employeeRate = 0;
		System.out.printf("[Input] Enter Employee %d's Hourly Rate:\n", i);
		do {
			try {
				employeeRate = input.nextDouble();
				while(employeeRate <= 0) {
					System.out.println("[Error] Employee Rate cannot be less than or equal to zero.");
					try {
						employeeRate = input.nextDouble();
					}catch (InputMismatchException e) {
						// User entered invalid input 
						System.out.println("[Error] Invalid Number.\nTry Again\n");
					}
					// Reset Input Buffer
					input.nextLine();
				}
			}catch (InputMismatchException e) {
				// User entered invalid input 
				System.out.println("[Error] Invalid Number.\nTry Again.\n");
			}
			// Reset Input Buffer
			input.nextLine();
		}while(employeeRate <= 0);
		// Return employeeRate to main
		return employeeRate;
	}/* End of employeeRate Method */

	/* Start of grossCalc Method */
	private static double grossCalc(double[][] money, int[][] hours, int i) {
		double gross = (money[i][0] * hours[i][0]) + (hours[i][1] * money[i][0] * 1.5);
		return gross;
	}/* End of grossCalc Method */
	
	/* Start of overtimeCalc Method */
	private static double overtimeCalc(double[][] money, int[][] hours, int i) {
		double overtime = (hours[i][1] * money[i][0] * 1.5);
		return overtime;
	}/* End of overtimeCalc Method */
	
	/* Start of stateTax Method */
	private static double stateTax(double[][] money, int i) {
		double tax = (money[i][1] * stateTax);
		return tax;
	}/* End of stateTax Method */
	
	/* Start of fedTax Method */
	private static double fedTax(double[][] money, int i) {
		double tax = (money[i][1] * federalTax);
		return tax;
	}/* End of fedTax Method */
	
	/* Start of unionFees Method */
	private static double unionFees(double[][] money, int i) {
		double tax = (money[i][1] * unionFees);
		return tax;
	}/* End of unionFees Method */
	
	/* Start of netGross Method */
	private static double netGross(double[][] money, int i) {
		double netGross = money[i][1] - (money[i][4] + money[i][5] + money[i][6]);
		return netGross;
	}/* End of netGross Method */
	
	/* Start of totalGross Method */
	private static double totalGross(double[][] money) {
		double totalGross = 0;
		for(int i = 0; i < money.length; i++) {
			totalGross += money[i][1];
		}
		return totalGross;
	}/* End of totalGross Method */
	
	/* Start of averageGross Method */
	private static double averageGross(double[][] money, int numEmployees) {
		double avg = money[0][7] / numEmployees;
		return avg;
	}/* End of averageGross Method */
	
	/* Start of Display Method */
	private static void displayAll(double[][] money, int[][] hours, String[][] names) {
		System.out.println("F Name\tInitial\tL Name\tID#\tRate/h\tHours\tQT hrs\tGross\tSTax\tFTax\tUFees\tNet");
		System.out.println("======\t=======\t======\t===\t======\t=====\t======\t=====\t====\t====\t=====\t===");
		for(int i = 0; i < money.length; i++) {
			System.out.printf("%s\t%s\t%s\t%s\t$%.2f\t%d\t%d\t$%.2f\t$%.2f\t$%.2f\t$%.2f\t$%.2f\t\n", names[i][0], names[i][1], names[i][2], names[i][3], money[i][0], hours[i][0], hours[i][1], money[i][1], money[i][4], money[i][5], money[i][6], money[i][2]);
			//System.out.println(names[i][0] + "\t" + names[i][1] + "\t" + names[i][2] + "\t" + names[i][3] + "\t$" + money[i][0] + "\t" + hours[i][1] + "\t$" + money[i][1] + "\t" + money[i][4] + "\t" + money[i][5] + "\t" + money[i][6] + "\t" + money[i][2] );
		}
		System.out.println("Total Gross: " + money[0][7]);
		System.out.println("Average Gross: " + money[0][8]);
	}/* End of displayAll Method */

}
