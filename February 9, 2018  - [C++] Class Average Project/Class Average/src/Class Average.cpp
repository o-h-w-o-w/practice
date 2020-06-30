/*
 * Julian Mayugba
 * Professor A
 * 
 * Feb 9, 2018
 * This program will do something with test scores
 */
#include <iostream>
#include <iomanip>
#include <string>

using namespace std;
// Prototypes
void testInput(double testScores[][4], string names[][3], int noStudents);
void studentAverage(double testScores[][4], int noStudents);
double classAverage(double testScores[][4], int noStudents);
void output(double testScores[][4], string names[][3], int noStudents, int classAvg);
//
const string divider = "\n=============\n";
// Main Function
int main(){
	// Variable Declaration
	int noStudents = 0, classAvg = 0;
	// Number of Students Input
	for(;;){
		cout << "\nEnter Number of Students: " << endl;
		if((cin >> noStudents) && (noStudents > 0)){
			break;
		}else{
			cout << "Invalid Input. Please try again." << endl;
			cin.clear();
			cin.ignore(80, '\n');
		}
	}
	// Array Declaration
	double testScores[noStudents][4];
	string names[noStudents][3];
	// To Functions
	testInput(testScores, names, noStudents);
	studentAverage(testScores, noStudents);
	classAvg = classAverage(testScores, noStudents);
	output(testScores, names, noStudents, classAvg);
	return 0;
}
// Input Function
void testInput(double testScores[][4], string names[][3], int noStudents){
	for(int i=0;i<noStudents;i++){
		cout << divider << "Student " << i+1 << divider;
		cout << "Enter First Name: " << endl;
		cin >> names[i][0];
		cout << "Enter Middle Name: " << endl;
		cin >> names[i][1];
		cout << "Enter Last Name: " << endl;
		cin >> names[i][2];
		for(int x = 0;x < 3;x++){
			for(;;){
				cout << "\nEnter Test Score " << x+1 << endl;
				if((cin >> testScores[i][x]) && (testScores[i][x] >= 0) && (testScores[i][x] <= 100)){
					break;
				}else{
					cout << "Invalid Input. Try Again." << endl;
					cin.clear();
					cin.ignore(80, '\n');
				}
			}
		}
	}
}
// Student Average Function
void studentAverage(double testScores[][4], int noStudents){
	for(int i=0;i<noStudents;i++){
		testScores[i][3] = (testScores[i][0] + testScores[i][1] + testScores[i][2]) / 3;
	}
}
// Class Average Function
double classAverage(double testScores[][4], int noStudents){
	double classAvg = 0, accu = 0;
	for(int x=0;x<3;x++){
		for(int i=0;i<noStudents;i++){
			accu += testScores[i][x];
		}
	}
	return classAvg = accu / (noStudents * 3);
}
// Output Function
void output(double testScores[][4], string names[][3], int noStudents, int classAvg){
	cout << "F NAME\tM NAME\tL NAME\tTEST1\tTEST2\tTEST3\t AVG" << endl;
	cout << fixed << setprecision(2);
	for(int i=0;i<noStudents;i++){
		cout << names[i][0] << "\t  " << names[i][1].at(0) << "   \t" << names[i][2] << "\t" << testScores[i][0] << "\t" << testScores[i][1] << "\t" << testScores[i][2] << "\t"  << testScores[i][3] << endl;
	}
	cout << divider << "Class Average: " << classAvg;
}
