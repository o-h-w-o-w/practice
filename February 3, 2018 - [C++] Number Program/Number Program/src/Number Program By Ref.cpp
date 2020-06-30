/*/============================================================================
// Name        : Number.cpp {by reference}
// Author      : Julian Mayugba
// Professor   : Professor A
// Description : This program will accept two numbers, find their total, averages, and find which number is larger.
//============================================================================
//
#include <iostream>
//
using namespace std;
//
void greeting();
//
void findNumber(double numbers[]);
void findTotal(double &total, double numbers[]);
void findAverage(double &average, double total);
void findLargest(double numbers[], double &largest);
void output(double numbers[], double total, double average, double largest);
//main function start
int main(){
    //Variable Declaration
	double numbers[2], total, average, largest;
    //To greeting
    greeting();
    //To findNumber
    findNumber(numbers);
    //To findTotal
    findTotal(total, numbers);
    //To findAverage
    findAverage(average, total);
    //To findLargest
    findLargest(numbers, largest);
    //To output
    output(numbers, total, average, largest);
    return 0;
}
//findNumber function start
void findNumber(double numbers[]){
	for(int i = 0;i < 2; i++){
		//Input Verification Input Loop
		for(;;){
			cout << "\nEnter a number: " << endl;
			if(cin >> numbers[i]){
				//If valid input, break;
				break;
			}else{
				//Invalid input
				cout << "Invalid Input." << endl;
				cin.clear();
				cin.ignore(80,'\n');
			}
		}
	}
}
//findTotal function start
void findTotal(double &total, double numbers[]){
	//Calcluate Total
	total = numbers[0] + numbers[1];
}
//findAverage function start
void findAverage(double &average, double total){
	//Calculate Average
	average = total / 2;
}
//findLargest function start
void findLargest(double numbers[], double &largest){
	if(numbers[0] > numbers[1]){
		//First Number is Largest
		largest = numbers[0];
	}else{
		//Second Number is Largest/Default
		largest = numbers[1];
	}
}
//greeting function
void greeting(){
	//Welcome Message
    cout << "welcome" << endl;
}
//output function
void output(double numbers[], double total, double average, double largest){
	//Start Outpu
    cout << "Number 1: " << numbers[0] << endl;
    cout << "Number 2: " << numbers[1] << endl;
    cout << "Total: " << total << endl;
    cout << "Average: " << average << endl;
    //Check if numbers are Equal
    if(numbers[0]==numbers[1]){
        cout << "The numbers are equal." << endl;
    }else{
        cout << "Largest: " << largest << endl;
    }
}
*/
