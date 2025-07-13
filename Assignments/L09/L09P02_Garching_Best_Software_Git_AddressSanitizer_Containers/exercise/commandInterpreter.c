#include <string.h>
#include <stdio.h>
#include "main.h"

int commandInterpreter (char inputCommand []) {
    if (strcmp(inputCommand, "add_entry\n") == 0){
        return NEW_ENTRY;
    }
    else if (strcmp(inputCommand, "view_entry\n") == 0) {
        return VIEW_ENTRY;
    }
    else if (strcmp(inputCommand, "delete_entry\n") == 0) {
        return DELETE_ENTRY;
    }
    else if (strcmp(inputCommand, "save_data\n") == 0) {
        return SAVE_DATA;
    }
    else if (strcmp(inputCommand, "load_file\n") == 0) {
        return LOAD_FILE;
    }
    else if (strcmp(inputCommand, "calc_bonus\n") == 0) {
        return CALCULATE_BONUS;
    }
    else if (strcmp(inputCommand, "give_grade\n") == 0) {
        return GIVE_GRADE;
    }
    else if (strcmp(inputCommand, "next\n") == 0) {
        return NEXT_ENTRY;
    }
    else if (strcmp(inputCommand, "prev\n") == 0) {
        return PREVIOUS_ENTRY;
    }
    else if (strcmp(inputCommand, "help\n") == 0) {
        return SHOW_HELP;
    }
    else if (strcmp(inputCommand, "exit\n") == 0) {
        return EXIT;
    }
    else
    {
        printf("unknown command:%s",inputCommand);
        return ERROR;
    }
}