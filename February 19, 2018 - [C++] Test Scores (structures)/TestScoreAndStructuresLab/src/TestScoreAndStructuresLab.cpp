/* Julian Mayugba
 * Professor A
 * February 19, 2018
 * Test Scores [structures no functions]
 */
#include <iostream>
#include <iomanip>
#include <string>
// Date Structure
struct Date{
	int Month, Day, Year;
};
// Student Information Structure
struct StudentInfo{
	Date Grad;
	int Id;
	std::string FirstName, MiddleName, LastName;
	float TestOne, TestTwo, TestThree, TestAvg;
};
// START OF MAIN FUNCTION
int main() {
	short int noStudents;
	float classAverage = 0;
	// Introduction
	std::cout << "Class Average [Structure Ver]" << std::endl;
	// Number of Students Input
	for(;;){
		std::cout << "\nEnter Number of Students: " << std::endl;
		if((std::cin >> noStudents) && (noStudents > 0)){
			break;
		}else{
			std::cout << "Invalid Input.\nPlease try again." << std::endl;
			std::cin.clear();
			std::cin.ignore(80,'\n');
		}
	}
	// Structure
	StudentInfo Student[noStudents];
	// Input
	for(int i=0;i<noStudents;i++){
		// Names Input
		std::cout << "Student No. " << i+1 << std::endl;
		std::cout << "Enter First Name: " << std::endl;
		std::cin >> Student[i].FirstName;
		std::cout << "Enter Middle Name: " << std::endl;
		std::cin >> Student[i].MiddleName;
		std::cout << "Enter Last Name: " << std::endl;
		std::cin >> Student[i].LastName;
		// Test Scores Input
		for(;;){
			std::cout << "\nEnter Test Score 1: " << std::endl;
			if((std::cin >> Student[i].TestOne) && (Student[i].TestOne >= 0) && (Student[i].TestOne <= 100)){
				break;
			}else{
				std::cout << "Invalid Input.\nPlease try again." << std::endl;
				std::cin.clear();
				std::cin.ignore(80,'\n');
			}
		}
		for(;;){
			std::cout << "\nEnter Test Score 2: " << std::endl;
			if((std::cin >> Student[i].TestTwo) && (Student[i].TestTwo >= 0) && (Student[i].TestTwo <= 100)){
				break;
			}else{
				std::cout << "Invalid Input.\nPlease try again." << std::endl;
				std::cin.clear();
				std::cin.ignore(80,'\n');
			}
		}
		for(;;){
			std::cout << "\nEnter Test Score 3: " << std::endl;
			if((std::cin >> Student[i].TestThree) && (Student[i].TestThree >= 0) && (Student[i].TestThree <= 100)){
				break;
			}else{
				std::cout << "Invalid Input.\nPlease try again." << std::endl;
				std::cin.clear();
				std::cin.ignore(80,'\n');
			}
		}
		// Student Average Calc
		Student[i].TestAvg = (Student[i].TestOne + Student[i].TestTwo + Student[i].TestThree) / 3;
		// Class Average Accumulator
		classAverage += (Student[i].TestOne + Student[i].TestTwo + Student[i].TestThree);
	}
	// Class Average Calc
	classAverage = classAverage / (noStudents * 3);
	// Output
	std::cout << "F NAME\tM NAME\tL NAME\tTEST1\tTEST2\tTEST3\t AVG" << std::endl;
	std::cout << std::fixed << std::setprecision(2);
	for(int i=0;i<noStudents;i++){
		std::cout << Student[i].FirstName << "\t" << Student[i].MiddleName.at(0) << "\t" << Student[i].LastName << "\t"
				<< Student[i].TestOne << "\t" << Student[i].TestTwo << "\t" << Student[i].TestThree <<"\t" << Student[i].TestAvg
				<< std::endl;
	}
	std::cout << "==========" << std::endl;
	std::cout << "Class Average: " << classAverage;
	return 0;
}
