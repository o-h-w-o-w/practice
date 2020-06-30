package oct12;

import java.util.Scanner;
public class SwitchProgram {
	private static double results = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice;
		double base, height, radius, length, width;
		System.out.println("Welcome to the Java Shape Area Calculator.");
		System.out.println("Type 1 for Triangle, Type 2 for Circle, Type 3 for Rectangle, or type 4 to quit");
		choice = input.nextInt();
		switch (choice) {
		case 1:
			// triangle case
			System.out.println("Triangle Area Calculator");
			System.out.println("Enter the Triangle's Base: ");
			base = input.nextDouble();
			// base input validation
			while (base <= 0) {
				System.out.println("Base cannot be equal to or less than 0.\nPlease try again. ");
				base = input.nextDouble();
			}
			System.out.println("Enter the Triangle's Height: ");
			height = input.nextDouble();
			// height input validation
			while (height <= 0) {
				System.out.println("Height cannot be equal to or less than 0.\nPlease try again. ");
				height = input.nextDouble();
			}
			// to triangle method
			System.out.printf("Area is : %.2f",triangle(base,height));
			break;
		case 2:
			// circle case
			System.out.println("Circle Area Calculator");
			System.out.println("Enter the Circle's radius: ");
			radius = input.nextDouble();
			// radius input validation
			while (radius <= 0) {
				System.out.println("Radius cannot be equal or less than 0.\nPlease try again. ");
				radius = input.nextDouble();
			}
			System.out.println("Enter the Circle's height: ");
			height = input.nextDouble();
			// height input validation
			while (height <= 0) {
				System.out.println("Height cannot be equal or less than 0.\nPlease try again. ");
				height = input.nextDouble();
			}
			// to circle method
			System.out.printf("Area is : %.2f",circle(radius,height));
			break;
		case 3:
			// rectangle case
			System.out.println("Rectangle Area Calculator");
			System.out.println("Enter the Rectangle's length: ");
			length = input.nextDouble();
			// length input validation
			while (length <= 0) {
				System.out.println("Length cannot be equal or less than 0.\nPlease try again. ");
				length = input.nextDouble();
			}
			System.out.println("Enter the Rectangle's width");
			width = input.nextDouble();
			// width input validation
			while (width <= 0) {
				System.out.println("Width cannot be equal to or less than 0.\nPlease try again. ");
				width = input.nextDouble();
			}
			// to rectangle method
			System.out.printf("Area is : %.2f",rectangle(length,width));
			break;
		case 4:
			// quit case
			System.out.println("Exiting program");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid selection.\nExiting Program");
		}
		input.close();
	}
	private static double triangle(double base, double height) {
		results = (base*.5)*height;
		return results;
	}
	private static double circle(double radius, double height) {
		results = 3.14 * Math.pow(radius, 2);
		return results;
	}
	private static double rectangle(double length, double width) {
		results = length * width;
		return results;
	}
}
