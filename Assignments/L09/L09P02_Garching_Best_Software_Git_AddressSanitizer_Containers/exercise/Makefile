#############################################################
# DON'T change the variable names of INCLUDEDIRS and SOURCE
#############################################################
# A list of include directories
INCLUDEDIRS =
# A list of source files
SOURCE = calculateBonus.c commandInterpreter.c executeCommand.c main.c

employee-manager: $(SOURCE)
	gcc -g3 -O3 $(SOURCE) -o employee-manager -lm

run:
	./employee-manager

clean:
	rm -f employee-manager && rm -r employee-manager.*
