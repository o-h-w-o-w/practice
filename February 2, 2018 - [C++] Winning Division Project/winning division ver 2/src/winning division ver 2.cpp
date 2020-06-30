//============================================================================
// Name        : Winning.cpp
// Author      : Julian Mayugba
// Professor   : Professor A
// Description : This program determines which of a company's four divisions
//				 had the greatest sales for a quarter.
//============================================================================



/* Do not accept dollar amounts less than $0.00
 * double getSales is passed the name of a division, asks the user for a division
 * quarterly sales figure, validates then returns it.  (call once per division)
 * void findHighest is passed four sales totals, determines which is the largest,
 * and prints the name of the high grossing division, along with its sales figure.
 */

#include <iostream>
#include <iomanip>

using namespace std;
//double getSales(string divName);
void getSales(string divName, double &sales);
void findHighest(double northEast, double northWest, double southEast, double southWest);

int main() {
	double northEast,northWest, southEast, southWest;
	/*getSales by value
	northEast = getSales("North East");
	northWest = getSales("North West");
	southEast = getSales("South East");
	southWest = getSales("South West");
	*/
	//getSales by reference
	 getSales("North East", northEast);
	 getSales("North West", northWest);
	 getSales("South East", southEast);
	 getSales("South West", southEast);

	findHighest(northEast, northWest, southEast, southWest);
	return 0;
}

/* getSales by value
double getSales(string divName){
	double sales = 0;
	cout << "Division: " << divName << endl;
	for(;;){
		cout << "\nEnter the quarterly sales figure: " << endl;
		if((cin >> sales) && (sales > 0)){
			break;
		}else{
			cout << "Please enter a number above 0." << endl;
			cin.clear();
			cin.ignore(80, '\n');
		}
	}
	return sales;
}*/

// getSales by reference
void getSales(string divName, double &sales){
	cout << "Division: " << divName << endl;
	for(;;){
		cout << "\nEnter the quarterly sales figure: " << endl;
		if((cin >> sales) && (sales > 0)){
			break;
		}else{
			cout << "Please enter a number above 0." << endl;
			cin.clear();
			cin.ignore(80, '\n');
		}
	}
}


void findHighest(double northEast, double northWest, double southEast, double southWest){
	double highestNum = 0;

	if((northEast > southEast) && (northEast > southWest) && (northEast > northWest)){
		//northEast is highestNum
		highestNum = northEast;
		cout << "North East ";
	}else if((southEast > southWest) && (southEast > northEast) && (southEast > northWest)){
		//southEast is highestNum
		highestNum = southEast;
		cout << "South East ";
	}else if((northWest > northEast) && (northWest > southWest) && (northWest > southEast)){
		//northWest is highestNum
		highestNum = northWest;
		cout << "North West";
	}else{
		//southWest is highestNum
		highestNum = southWest;
		cout << "South West ";
	}
	cout << fixed << showpoint << setprecision(2);
	cout << "division has the highest sales." << endl;
	cout << "Sales: $" << highestNum << endl;
}
