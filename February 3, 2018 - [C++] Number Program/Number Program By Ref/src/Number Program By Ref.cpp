//============================================================================
// Author      : Julian Mayugba
// Professor   : Professor A
// Date        : 02/03/2018
// Description : (by ref) This program will accept two numbers, find their total, averages, and find which number is larger.
//============================================================================

#include <iostream>

using namespace std;

void numInput(double &num);
void numAverage(double num1, double num2, double &average);
void numLargest(double num1, double num2, double &largest);
void displayAll(double num1, double num2, double average, double largest);

int main(){
    double num1, num2, average, largest = 0;

    numInput(num1);
    numInput(num2);
    numAverage(num1, num2, average);
    numLargest(num1, num2, average);
    displayAll(num1, num2, average, largest);
	return 0;
}

void numInput(double &num){
	for(;;){
		cout << "\nEnter a Number." << endl;

		if(cin >> num){
			break;
		}else{
			cout << "Please enter a valid number." << endl;
			cin.clear();
			cin.ignore(80,'\n');
		}
	}
}

void numAverage(double num1, double num2, double &average){
    average = (num1 + num2) / 2;
    cout << average << endl;
}

void numLargest(double num1, double num2, double &largest){

    cout << "this is num 1:" << num1 << endl;
    cout << "this is num 2:" << num2 << endl;
    if(num1 > num2){
        largest = num1;
    }else if(num1 < num2){
        largest = num2;
    }
    cout << "this is num 1:" << num1 << endl;
    cout << "this is num 2:" << num2 << endl;
    cout << largest;
}

void displayAll(double num1, double num2, double average, double largest){
    cout << "Number 1      : " << num1 << endl;
    cout << "Number 2      : " << num2 << endl;
    cout << "Average       : " << average << endl;
    if(num1==num2){
        cout << "The numbers are the same." << endl;
    }else{
    cout << "Largest: " << largest << endl;
    }
}
