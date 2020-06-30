//============================================================================
// Name        : Payroll Project
// Author      : Julian Mayugba
// Version     : 1.0
// Description : This program will create a payroll report
//============================================================================

#include <iostream>
using namespace std;

// Constant Declaration
const float stateTax = 0.06, fedTax = 0.12, unionFees = 0.02;
const string divider = "=====================================================================================================";

int main() {
	// [Variable Declaration]
	int empNo = 0; // Number of Employees
	float totalGross = 0, averageGross; // Total Gross and Average Gross

	// [Introduction]
	cout << divider << endl;
	cout << "Welcome to the Payroll Program." << endl;

	// [Input--Number of Employees]
	for(;;){
		cout << "\nEnter Number of Employees: " << endl;
		if((cin >> empNo) && (empNo > 0)){
			break;
		}else{
			cout << "[Error] Invalid Input.\nPlease enter Integer above 0." << endl;
			cin.clear();
			cin.ignore(80, '\n');
		}
	}

	// [typedef Declaration]
	typedef string Names[empNo];

	// [Array Declaration]
	Names firstName, middleInitial, lastName;
	float hoursWorked[empNo], hourRate[empNo], overtime[empNo], empGross[empNo], netGross[empNo], sTax[empNo], fTax[empNo], uFee[empNo], cTax[empNo];

	// [Input/Calculations--For Loop]
	for(int i=0;i<empNo;i++){
		// [Input--First Name]
		cout << "Enter First Name: " << endl;
		cin >> firstName[i];

		// [Input--Middle Initial]
		cout << "Enter Middle Initial: " << endl;
		cin >> middleInitial[i];

		// [Input--Last Name]
		cout << "Enter Last Name: " << endl;
		cin >> lastName[i];

		// [Input--Hours Worked]
		for(;;){
			cout << "\nEnter Hours Worked: " << endl;
			if((cin >> hoursWorked[i]) && (hoursWorked[i] > 0) && (hoursWorked[i] < 60)){
				break;
			}else{
				cout << "[Error] Invalid Input.\nPlease enter an Integer greater than 0 and\nless than 60." << endl;
				cin.clear();
				cin.ignore(80, '\n');
			}
		}

		// [Input--Rate Per Hour]
		for(;;){
			cout << "\nEnter Rate Per Hour: " << endl;
			if((cin >> hourRate[i]) && (hourRate[i] > 0) && (hourRate[i] < 50)){
				break;
			}else{
				cout << "[Error] Invalid Input.\nPlease enter an Integer greater than 0 and\nless than 50." << endl;
				cin.clear();
				cin.ignore(80, '\n');
			}
		}

		// [Calculate Overtime]
		if(hoursWorked[i] > 40){
			overtime[i] = (hoursWorked[i] - 40) * hourRate[i] * 1.5;
		}else{
			overtime[i] = 0;
		}

		// [Calculate Gross Income]
		empGross[i] = (hourRate[i] * hoursWorked[i]) + overtime[i];

		// [Calculate State Tax]
		sTax[i] = empGross[i] * stateTax;

		// [Calculate Fed Tax]
		fTax[i] = empGross[i] * fedTax;

		// [Calculate Union Fees]
		uFee[i] = empGross[i] * unionFees;

		// [Calculate Tax Sum]
		cTax[i] = sTax[i] + fTax[i] + uFee[i];

		// [Calculate Net Gross]
		netGross[i] = empGross[i] - cTax[i];

		// [Calculate Total Gross]
		totalGross += empGross[i];

		// [Calculate Average Gross]
		averageGross = totalGross / empNo;

	}
	// [Display]
    cout << divider << endl;
    cout << "First Name\tMI\tLast Name\tRate Per Hour\tHours Worked\tOvertime\tGross\tTax" << endl;
    cout << divider << endl;
   // Information For Loop
    for(int i=0;i<empNo;i++){
        cout << firstName[i] << "\t\t" << middleInitial[i] << "\t\t" << lastName[i] << "\t\t$" << hourRate[i]
        << "\t\t" << hoursWorked[i] << "\t$" << overtime[i] << "\t\t$" << empGross[i] << "\t$" << cTax[i] << endl;
    }
    cout << divider << endl;
    cout << "Total Gross: $" << totalGross << endl;
    cout << "Average Gross: $" << averageGross << endl;
    cout << divider << endl;
	return 0;
}
