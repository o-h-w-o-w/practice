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
using namespace std;
double getSales(string divName);
void findHighest(double northEast, double northWest, double southEast, double southWest);

int main() {
	double northEast,northWest, southEast, southWest;
	northEast = getSales("North East");
	northWest = getSales("North West");
	southEast = getSales("South East");
	southWest = getSales("South West");

	findHighest(northEast, northWest, southEast, southWest);
	return 0;
}

double getSales(string divName){
	double sales = 0;

	return sales;
}

void findHighest(double northEast, double northWest, double southEast, double southWest){

}
