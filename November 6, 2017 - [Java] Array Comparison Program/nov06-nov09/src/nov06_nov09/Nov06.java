package nov06_nov09;
/* Julian Mayugba
 * Professor A
 * Java Programming Class
 * November 6, 2017
 * This program will ask the user for the size of two arrays and its values, sort them, compare them, union them,
 * find the intersection, and display this information.
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class Nov06 {
	public static void main(String[] args) {
		// scanner object
		Scanner input = new Scanner(System.in);
		// variable declaration
		int arraySize1 = 0, arraySize2 = 0;
		char choice = 'y';
		// greeting
		System.out.println("Welcome to the array comparison program.");		
		// ask user for array size 1
		System.out.println("Array Size 1: ");
		arraySize1 = input.nextInt();	
		// input validation
 		while(!(arraySize1 > 0)) {
 			System.out.println("Invalid Input. Please try again.");
 			arraySize1 = input.nextInt();
 		}	
 		// ask user for array size 2
		System.out.println("Array Size 2: ");
		arraySize2 = input.nextInt();	
		// input validation
		while(!(arraySize2 > 0)) {
			System.out.println("Invalid Input. Please try again.");
 			arraySize2 = input.nextInt();
		}
		// array size declaration
		Integer[] array1 = new Integer[arraySize1];
		Integer[] array2 = new Integer[arraySize2];
		// check array length
		if(arraySize1 != arraySize2) {
			// arrays not equal | terminate program
			System.out.println("Array size not equal.\nTherefore the arrays are not equal.");
		}else {
			// arrayOne element input
			for(int i=0;i<array1.length;i++) {
				System.out.println("[Array 1] Enter Number: ");
				array1[i] = input.nextInt();
			}
			// arrayTwo element input
			for(int i=0;i<array1.length;i++) {
				System.out.println("[Array 2] Enter Number: ");
				array2[i] = input.nextInt();
			}
			// sort arrays
			Arrays.sort(array1);
			Arrays.sort(array2);
			// Display Result Input
			System.out.println("Display Results? Y or N");
			choice = input.next().charAt(0);
			switch (choice){
				case 'y':
				case 'Y':
					// all
					compareElements(array1, array2);
					displayArray(array1, array2);
					unionElements(array1, array2);
					intersectElements(array1, array2);
				default:
					// exit
					break;
			}
			input.close();
		}
		/* end of main method*/ 
	}
	
	// compare arrays method
	private static void compareElements(Integer[] array1, Integer[] array2) {
		boolean isEqual = true;
		int i = 0;
		// array compare
		while(isEqual && i < array1.length) {
			if(array1[i] != array2[i]) {
				isEqual = false;
			}
			i++;
		}
		// output
				if(isEqual) {
			System.out.println("==============================");
			System.out.println("Array 1 and Array 2 are equal.");
			System.out.println("==============================");
		}else {
			System.out.println("==================================");
			System.out.println("Array 1 and Array 2 are not equal.");
			System.out.println("==================================");
		}
		/* end of compareElements method*/
	}
	// display array method
	private static void displayArray(Integer[] array1, Integer[] array2) {
		// display first array
		System.out.println("\n===============");
		System.out.println("Array 1 Sorted:");
		System.out.println("===============");
		for(int i=0;i<array1.length;i++) {
			System.out.printf("\n[Index %d] = %d", i, array1[i]);
		}
		// display second array
		System.out.println("\n===============");
		System.out.println("Array 2 Sorted:");
		System.out.println("===============");
		for(int i=0;i<array2.length;i++) {
			System.out.printf("\n[Index %d] = %d", i, array2[i]);
		}
		System.out.println();
		/* end of displayArray method */
	}
	// union array method
	private static void unionElements(Integer[] ... arrays) {
		//creating new HashSet object
		HashSet<Integer>unionSet=new HashSet<Integer>();
		// for loop adding each array elements of both arrays to unionSet
		for (Integer[] array:arrays) {
            for (int i:array){
            	unionSet.add(i);
            }
		}
		// display union
		System.out.println("======");
		System.out.println("Union:");
		System.out.println("======");
		System.out.println(unionSet);
		/* end of unionElements method */
	}
	// intersection array method
	private static void intersectElements(Integer[] ... arrays) {
		// hashset object for intersection for first out of "x" arrays
		HashSet<Integer> intersectSet = new HashSet<>(Arrays.asList(arrays[0]));
		// retain all to intersectSet from tempSet
		for(int i = 1;i<arrays.length;i++) {
			HashSet<Integer> tempSet = new HashSet<>(Arrays.asList(i));
			intersectSet.retainAll(tempSet);
		}
		// display intersection
		System.out.println("=============");
		System.out.println("Intersection:");
		System.out.println("=============");
		System.out.println(intersectSet);
	}	
}
	


