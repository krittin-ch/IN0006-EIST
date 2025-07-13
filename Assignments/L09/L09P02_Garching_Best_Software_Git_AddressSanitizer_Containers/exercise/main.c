#include <stdio.h>
#include "main.h"
#include "commandInterpreter.h"
#include "executeCommand.h"

int main (){

    int commandID;
    struct systemState state;
    state.numEntries = 0;
    state.selectedEntryNumber = 0;
    state.selectedEntry = NULL;
    printf("Please Enter Command:\n");
    printf("Enter \"help\" to see commands\n");
    while(1)
    {
        //input state machine
        char inputCommand [32];
        printf("CMD: ");
        fgets(inputCommand, INPUT_COMMAND_LENGTH, stdin);
        commandID = commandInterpreter(inputCommand);
        if (commandID == ERROR)
        {
            printf("Invalid Command, please try again\n");
        }
        else
        {
            executeCommand(commandID, &state); //basically large case switch statement for executing large functions
        }
    }
}