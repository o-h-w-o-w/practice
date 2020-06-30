package sgjdfjfni;

import java.util.Scanner;

public class ds {
public static void main (String[] args)
{
 // Create a scanner object to read input. 
	Scanner keyboard = new Scanner (System.in); 
//     
    String Triangle, Square, Rectangle;
    double length = 0, width = 0, base, height, area;
//
	System.out.println("Choose a shape == triangle, square or rectangle?");
	String shape = keyboard.nextLine().toLowerCase();

	switch(shape) {
		case ("triangle"):
			System.out.println("Triangle area calculation is base x 1/2 x height");
			System.out.println(" What is your height?");
			height= keyboard.nextDouble();
			System.out.println("What is your base?");
			base= keyboard.nextDouble();
			area = base * 0.5 * height;
			System.out.println("The area of your Triangle is" + area);
			break;
		case ("rectangle"):
			System.out.println("Rectangle are is length x width");
			System.out.println(" What is your height?");
			height= keyboard.nextDouble();
			System.out.println("What is your base?");
			base= keyboard.nextDouble();
			area = base * 0.5 * height;
			System.out.println("The area of your Triangle is" + area);
			break;
		case ("square"):
			System.out.println("Square area calculation is s^2");
			System.out.println("What is the Square length?");
			area = width * length;
			System.out.println("The area of your Square is" + area);
			break;
	}
}
}

 




