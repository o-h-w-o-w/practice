//============================================================================
// Name        : Number.cpp
// Author      : Julian Mayugba
// Professor   : Professor A
// Description : This program will accept two numbers, find their total, averages, and find which number is larger.
//============================================================================
//
#include <iostream>

using namespace std;

double findNumber();
double findAverage(double total);
double findTotal(double nums[]);
double findLargest(double nums[]);
void output(double nums[], double total, double average, double largest);
void greeting();

int main(){
    // var declare
    double nums[2], total, average, largest;
    // greeting
    greeting();
    // input loop
    for(int i=0;i<2;i++){
        nums[i]=findNumber();
    }
    //calculate
    total = findTotal(nums);
    average = findAverage(total);
    largest = findLargest(nums);
    //display
    output(nums, total, average, largest);
    return 0;
}
//findNumber function
double findNumber(){
    double number = 0;
    for(;;){
        cout << "\nEnter a number:" << endl;
        if(cin >> number){
            break;
        }else{
            cout << "Please enter an valid number." << endl;
            cin.clear();
            cin.ignore(80, '\n');
        }
    }
    return number;
}
//findTotal function
double findTotal(double nums[]){
    double total = 0;
    for(int i=0;i<2;i++){
        total += nums[i];
    }
    return total;
}
//findAverage function
double findAverage(double total){
    double average = total/2;
    return average;
}
//findLargest function
double findLargest(double nums[]){
    double largest;
    if(nums[0] > nums[1]){ //
        largest = nums[0];
    }else{
        largest = nums[1];
    }
    return largest;
}
//greeting function
void greeting(){
    cout << "welcome" << endl;
}
//output function
void output(double nums[], double total, double average, double largest){
    cout << "Number 1: " << nums[0] << endl;
    cout << "Number 2: " << nums[1] << endl;
    cout << "Total: " << total << endl;
    cout << "Average: " << average << endl;
    if(nums[0]==nums[1]){
        cout << "The numbers are equal." << endl;
    }else{
        cout << "Largest: " << largest << endl;
    }
}

