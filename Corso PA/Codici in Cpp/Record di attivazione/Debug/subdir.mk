################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../1.cpp \
../2.cpp \
../3.cpp \
../4.cpp \
../5.cpp 

CPP_DEPS += \
./1.d \
./2.d \
./3.d \
./4.d \
./5.d 

OBJS += \
./1.o \
./2.o \
./3.o \
./4.o \
./5.o 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.cpp subdir.mk
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


clean: clean--2e-

clean--2e-:
	-$(RM) ./1.d ./1.o ./2.d ./2.o ./3.d ./3.o ./4.d ./4.o ./5.d ./5.o

.PHONY: clean--2e-

