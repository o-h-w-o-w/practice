#include <iostream>

struct DateTest{
	int month, day, year;
};

struct TestStructure{
	DateTest Date;
	int testElement1;
	std::string testString1;

};

void byRefFunction(int &num1);
int byValFunction();

int main() {

	// Input Validation
	int value = 0;
	for(;;){
		std::cout << "\nEnter something" << std::endl;
		if(std::cin >> value){
			break;
		}else{
			std::cout << "You have entered it wrong" << std::endl;
			std::cin.clear();
			std::cin.ignore(80, '\n');
		}
	}
	std::cout << &value << std::endl;
	return 0;
}

void byRefFunction(int &num1){
	std::cout << "Enter a number:" << std::endl;
	std::cin >> num1;
}

int byValFunction(){
	int returnVal;
	std::cout << "Enter a number:" << std::endl;
	std::cin >> returnVal;
	return returnVal;
}
