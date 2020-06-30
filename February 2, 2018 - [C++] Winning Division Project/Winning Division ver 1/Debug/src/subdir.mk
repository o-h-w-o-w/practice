################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Winning\ Division.cpp 

OBJS += \
./src/Winning\ Division.o 

CPP_DEPS += \
./src/Winning\ Division.d 


# Each subdirectory must supply rules for building sources it contributes
src/Winning\ Division.o: ../src/Winning\ Division.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/Winning Division.d" -MT"src/Winning\ Division.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


