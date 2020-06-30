/*
 * Julian Mayugba
 * Professor A
 * CPP
 * Feb 10, 2018
 * This program will create a payroll report. [v2]
 */

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

const float stateTax = 0.06, fedTax = 0.12, unionFees = 0.02;

void input(string names[][3], float hours[][3], float empNo);
void calc(float gross[][2], float hours[][3], float tax[][4], float empNo, float &totalGross, float &averageGross);
void output(string names[][3], float gross[][2], float hours[][3], float tax[][4], float empNo, float totalGross, float averageGross);

int main() {
	short int empNo = 0;
	float totalGross = 0, averageGross = 0;
	cout << "Welcome to the Payroll Program." << endl;
	for(;;){
		cout << "\nEnter Number of Employees: " << endl;
		if((cin >> empNo) && (empNo > 0)){
			break;
		}else{
			cout << "Invalid Input. Please enter an integer above 0." << endl;
			cin.clear();
			cin.ignore(80, '\n');
		}
	}
	string names[empNo][3];
	/* 0 - first name
	 * 1 - middle name
	 * 2 - last name
	 */
	float tax[empNo][4];
	/* 0 - state tax
	 * 1 - federal tax
	 * 2 - union fees
	 * 3 - combined tax
	 */
	float hours[empNo][3];
	/* 0 - hours worked
	 * 1 - rate per hour
	 * 2 - overtime
	 */
	float gross[empNo][2];
	/* 0 - employee gross
	 * 1 - net gross
	 */
	input(names, hours, empNo);
	calc(gross, hours, tax, empNo, totalGross, averageGross);
	output(names, gross, hours, tax, empNo, totalGross, averageGross);

	return 0;
}
void input(string names[][3], float hours[][3], float empNo){
	for(int i=0;i<empNo;i++){
		// first name input
		cout << "Enter First Name: " << endl;
		cin >> names[i][0];
		// middle name input
		cout << "Enter Middle Name: " << endl;
		cin >> names[i][1];
		// last name input
		cout << "Enter Last Name: " << endl;
		cin >> names[i][2];
		// hours worked input
		for(;;){
			cout << "\nEnter Hours Worked: " << endl;
			if((cin >> hours[i][0]) && (hours[i][0] > 0) && (hours[i][0] < 60)){
				break;
			}else{
				cout << "Invalid Input.  Please enter a number above 0 and less than 60." << endl;
				cin.clear();
				cin.ignore(80, '\n');
			}
		}
		// rate per hour input
		for(;;){
			cout << "\nEnter Rate Per Hour: " << endl;
			if((cin >> hours[i][1]) && (hours[i][1] > 0) && (hours[i][1] < 50)){
				break;
			}else{
				cout << "Invalid Input. Please enter a number above 0 and less than 50." << endl;
				cin.clear();
				cin.ignore(80, '\n');
			}
		}
	}
}
void calc(float gross[][2], float hours[][3], float tax[][4], float empNo, float &totalGross, float &averageGross){
	for(int i=0;i<empNo;i++){
		// overtime calc
		if(hours[i][0] > 40){
			hours[i][2] = (hours[i][0] - 40) * hours[i][1] * 1.5;
		}else{
			hours[i][2] = 0;
		}
		// gross income calc
		gross[i][0] = (hours[i][1] * hours[i][0]) + hours[i][2];
		// state tax calc
		tax[i][0] = gross[i][0] * stateTax;
		// fed tax calc
		tax[i][1] = gross[i][0] * fedTax;
		// union fee calc
		tax[i][2] = gross[i][0] * unionFees;
		// all tax calc
		tax[i][3] = tax[i][0] + tax[i][1] + tax [i][2];
		// net gross calc
		gross[i][1] = gross[i][0] - tax[i][3];
		// total gross calc
		totalGross += gross[i][0];
		// average gross calc
		averageGross = totalGross / empNo;
	}
}
void output(string names[][3], float gross[][2], float hours[][3], float tax[][4], float empNo, float totalGross, float averageGross){
	// [Display]
	cout << "First Name\tMI\tLast Name\tRate\tHours\tOvertime Gross\tNet Gross\tTax" << endl;
   // Information For Loop
    for(int i=0;i<empNo;i++){
    		cout << fixed << setprecision(2);
        cout << names[i][0] << "\t\t" << names[i][1].at(0) << "\t" << names[i][2] << "\t\t$" << hours[i][1]
        << "\t" << hours[i][0] << "\t$" << hours[i][2]<< "\t $" << gross[i][0] << "\t$" << gross[i][1] << "\t\t$" << tax[i][3] << endl;
    }
    cout << "================" << endl;
    cout << "Total Gross: $" << totalGross << endl;
    cout << "Average Gross: $" << averageGross << endl;
}
