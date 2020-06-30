################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Payroll\ Project\ V2.cpp 

OBJS += \
./src/Payroll\ Project\ V2.o 

CPP_DEPS += \
./src/Payroll\ Project\ V2.d 


# Each subdirectory must supply rules for building sources it contributes
src/Payroll\ Project\ V2.o: ../src/Payroll\ Project\ V2.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/Payroll Project V2.d" -MT"src/Payroll\ Project\ V2.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


