################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Class\ Average.cpp 

OBJS += \
./src/Class\ Average.o 

CPP_DEPS += \
./src/Class\ Average.d 


# Each subdirectory must supply rules for building sources it contributes
src/Class\ Average.o: ../src/Class\ Average.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/Class Average.d" -MT"src/Class\ Average.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


