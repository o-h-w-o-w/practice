/* Julian Mayugba
 * Professor A
 * CPP
 * Payroll Project and Structures [No Functions]
 * February 19, 2019
 */

#include <iostream>
#include <string>
#include <iomanip>

// Date Structure
struct Date{
	int Month, Day, Year;
};
// Employee Info Structure
struct Info{
	Date HireDate;
	std::string FirstName, MiddleName, LastName;
	float StateTax, FedTax, UnionFees, TotalTax;
	float HourWorked, HourRate, HourOvertime;
	float EmpGross, EmpNetGross;
};
// Tax Constants
const float stateTaxVal = 0.06, fedTaxVal = 0.12, unionFeesVal = 0.02;
/* MAIN FUNCTION START */
int main(){
	// Variable Declaration
	int empNo = 0;
	float totalGross = 0, averageGross = 0;
	// Start Message
	std::cout << "Payroll Program:" << std::endl;
	// Number of Employee Input + Input Validation
	for(;;){
		std::cout << "\nEnter Number of Employees: " << std::endl;
		if((std::cin >> empNo) && (empNo > 0)){
			break;
		}else{
			std::cout << "Invalid Input.\nPlease enter an integer above 0." << std::endl;
			std::cin.clear();
			std::cin.ignore(80,'\n');
		}
	}
	Info Employee[empNo];
	for(int i=0;i<empNo;i++){
		std::cout << "Employee: " << i+1 << std::endl;
		// Hire Date Month:
		for(;;){
			std::cout << "\nEnter Numerical Month of Hire: " << std::endl;
			if((std::cin >> Employee[i].HireDate.Month) && (Employee[i].HireDate.Month > 0) && (Employee[i].HireDate.Month <= 12)){
				break;
			}else{
				std::cout << "Invalid Input.\nPlease enter a valid month (1-12)" << std::endl;
				std::cin.clear();
				std::cin.ignore(80,'\n');
			}
		}
		// Hire Date Day:
		for(;;){
			std::cout << "\nEnter Numerical Day of Hire: " << std::endl;
			if((std::cin >> Employee[i].HireDate.Day) && (Employee[i].HireDate.Day > 0) && (Employee[i].HireDate.Day <= 31)){
				// Ignoring Months < 31 days;
				break;
			}else{
				std::cout << "Invalid Input.\nPlease enter a valid number." << std::endl;
				std::cin.clear();
				std::cin.ignore(80,'\n');
			}
		}
		// Hire Date Year:
		for(;;){
			std::cout << "\nEnter the last two numbers of the Year of Hire: " << std::endl;
			if(std::cin >> Employee[i].HireDate.Year){
				break;
			}else{
				std::cout << "Invalid Input.\nPlease enter a valid number." << std::endl;
				std::cin.clear();
				std::cin.ignore(80,'\n');
			}
		}
		// Names
		std::cout << "Enter First Name: " << std::endl;
		std::cin >> Employee[i].FirstName;
		std::cout << "Enter Middle Name: " << std::endl;
		std::cin >> Employee[i].MiddleName;
		std::cout << "Enter Last Name: " << std::endl;
		std::cin >> Employee[i].LastName;
		// Hours Worked Input + Input Verification
		for(;;){
			std::cout << "\nEnter Hours Worked: " << std::endl;
			if((std::cin >> Employee[i].HourWorked) && (Employee[i].HourWorked > 0) && (Employee[i].HourWorked < 60)){
				break;
			}else{
				std::cout << "Invalid Input.\nPlease enter a number above 0 and below 60." << std::endl;
				std::cin.clear();
				std::cin.ignore(80,'\n');
			}
		}
		// Hour Rate Input + Input Verification
		for(;;){
			std::cout << "\nEnter Hour Rate: " << std::endl;
			if((std::cin >> Employee[i].HourRate) && (Employee[i].HourRate > 0) && (Employee[i].HourRate < 50)){
				break;
			}else{
				std::cout << "Invalid Input.\nPlease enter a number above 0 and below 50." << std::endl;
				std::cin.clear();
				std::cin.ignore(80,'\n');
			}
		}
		// Calculate Overtime
		if(Employee[i].HourWorked > 40){
			Employee[i].HourOvertime = (Employee[i].HourWorked - 40) * Employee[i].HourRate * 1.5;
		}else{
			Employee[i].HourOvertime = 0;
		}
		// Calculate Gross Income
		Employee[i].EmpGross = (Employee[i].HourWorked * Employee[i].HourRate) + Employee[i].HourOvertime;
		// Calculate Fed Tax
		Employee[i].FedTax = Employee[i].EmpGross * fedTaxVal;
		// Calculate Union Fees
		Employee[i].UnionFees = Employee[i].EmpGross * unionFeesVal;
		// Calculate State Tax
		Employee[i].StateTax = Employee[i].EmpGross * stateTaxVal;
		// Calculate Total Tax
		Employee[i].TotalTax = Employee[i].FedTax + Employee[i].UnionFees + Employee[i].StateTax;
		// Calculate Net Gross
		Employee[i].EmpNetGross = Employee[i].EmpGross - Employee[i].TotalTax;
		// Calculate Total Gross
		totalGross += Employee[i].EmpGross;
	}
	// Calculate Average Gross
	averageGross = totalGross / empNo;
	// Display
	std::cout << "First Name\tMI\tLast Name\tRate\tHours\tOvertime  Gross\t\tNet Gross\tTax\tHire Date" << std::endl;
	std::cout << std::fixed << std::setprecision(2);
	for(int i=0;i<empNo;i++){
		std::cout << Employee[i].FirstName << "\t\t" << Employee[i].MiddleName.at(0) << "\t"
				<< Employee[i].LastName << "\t\t" << Employee[i].HourRate << "\t"
				<< Employee[i].HourWorked << "     $" << Employee[i].HourOvertime << "    $"
				<< Employee[i].EmpGross << "\t$" << Employee[i].EmpNetGross << "\t\t$" <<Employee[i].TotalTax
				<< "\t" << Employee[i].HireDate.Month << "/" << Employee[i].HireDate.Day << "/"
				<< Employee[i].HireDate.Year << std::endl;
	}
	std::cout << "================" << std::endl;
	std::cout << "Total Gross: $" << totalGross << std::endl;
	std::cout << "Average Gross: $" << averageGross << std::endl;
	return 0;
}
