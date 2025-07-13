// TODO 3.2

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "main.h"
#include "executeCommand.h"
#include "calculateBonus.h"

struct employeeInfo* head = NULL; 
struct employeeInfo* tail = NULL;

// create a new entry with the given data and return a 
// pointer to it 
struct employeeInfo* createEntry(char firstName[], char lastName[], float salary)
{ 
    struct employeeInfo *newEntry = (struct employeeInfo*) malloc(sizeof(struct employeeInfo));
    strncpy(newEntry->firstName, firstName, NAME_LENGTH);
    strncpy(newEntry->lastName, lastName, NAME_LENGTH);
    newEntry->salary = salary;
    newEntry->bonus = 0;
    newEntry->performanceGrade = 0;
    newEntry->next = NULL; 
    newEntry->prev = NULL; 
    return newEntry; 
}

//insert entry at tail of linked list
void insertEntry(char firstName[], char lastName[], float salary)
{ 
    struct employeeInfo* newEntry = createEntry(firstName, lastName, salary);
    if (tail == NULL) { 
        head = newEntry; 
        tail = newEntry;
    } 
    else { 
        newEntry->prev = tail; 
        tail->next = newEntry; 
        tail = newEntry; 
    }
}

// Delete last entry into linked list
void deleteEntry() 
{ 
    if (tail == NULL) { 
        return; 
    } 
    struct employeeInfo* temp = tail; 
    if (head == tail) { 
        head = NULL; 
        tail = NULL; 
    } 
    else { 
        tail = tail->prev; 
        tail->next = NULL; 
    } 
    free(temp); 
}

int executeCommand(int commandID, struct systemState *state)
{
    switch(commandID){
        case NEW_ENTRY: {
            char firstName[NAME_LENGTH];
            char lastName[NAME_LENGTH];
            float salary;
            printf("Enter first name: ");
            scanf("%s",firstName);
            printf("Enter last name: ");
            scanf("%s",lastName);
            printf("Enter salary: ");
            scanf("%f",&salary);
            insertEntry(firstName, lastName, salary);
            state->numEntries++;
            printf("Added Entry\n");
            if (state->selectedEntry == NULL) {
                state->selectedEntry = tail; // if no previous entry, set new entry as currently selected
            }
            fgets(firstName, NAME_LENGTH, stdin); //clear buffer
        }
        break;
        case VIEW_ENTRY: {
            if (state->selectedEntry == NULL) {
                printf("No entries found\n");
                return 1;
            }
            printf("Data for entry number: %d\n",state->selectedEntryNumber);
            printf("First Name: %s\n",state->selectedEntry->firstName);
            printf("Last Name: %s\n",state->selectedEntry->lastName);
            printf("Salary: %f, Performance Grade: %d, Bonus: %f\n", state->selectedEntry->salary, state->selectedEntry->performanceGrade, state->selectedEntry->bonus);
        break;
        }
        case DELETE_ENTRY: {
            if (state->numEntries == 0)
            {
                printf("No entries to delete\n");
                return 1;
            }
            else if (state->numEntries == 1)
            {
                printf("Deleted last entry\n");
            }
            else if (state->selectedEntry == tail) {
                state->selectedEntry = state->selectedEntry->prev;
            }
            state->numEntries--;
            deleteEntry();
            printf("Deleted Entry\n");
        break;
        }
        case SAVE_DATA: {
            printf("Not implemented yet"); //will write data to DB
        break;
        }
        case LOAD_FILE: {
            printf("Not implemented yet"); //read in text file and populate linked list
        break;
        }
        case CALCULATE_BONUS: {
            calculate_bonus(state->selectedEntry);
            break;
        }
        case GIVE_GRADE: {
            printf("Enter performance grade: ");
            int grade;
            scanf("%d",&grade);
            if (grade < 1 || grade > 10)
            {
                printf("Invalid grade, must be between 1 and 10\n");
                return 1;
            }
            state->selectedEntry->performanceGrade = grade;
            char rand [NAME_LENGTH];
            fgets(rand, NAME_LENGTH, stdin); //clear buffer
            break;
        }
        case NEXT_ENTRY: {
            if(state->selectedEntry == NULL)
            {
                printf("No entries\n");
                return 1;
            }
            if (state->selectedEntry->next == NULL)
            {
                printf("No next entry found\n");
                return 1;
            }
            state->selectedEntry = state->selectedEntry->next;
            state->selectedEntryNumber++;
        break;
        }
        case PREVIOUS_ENTRY: {
            if (state->selectedEntry == NULL)
            {
                printf("No entries\n");
                return 1;
            }
            if (state->selectedEntry->prev == NULL)
            {
                printf("No previous entry found\n");
                return 1;
            }
            state->selectedEntry = state->selectedEntry->prev;
            state->selectedEntryNumber--;
        break;
        }
        case SHOW_HELP: {
            printf("Commands:\n");
            printf("add_entry    -   adds new employee based on user prompts\n");
            printf("view_entry   -   view currently selected employee\n");
            printf("delete_entry -   delete the last employee of linked list, not current employee\n");
            printf("save_data    -   write employees in current workspace to database\n");
            printf("load_file    -   loads employees from text file\n");
            printf("calc_bonus   -   calculates the employee bonus from performance grade\n");
            printf("give_grade   -   set employee performance grade, ranges 1(worst)-10(best)\n");
            printf("next         -   select next employee in workspace\n");
            printf("prev         -   select previous employee in workspace\n");
            printf("help         -   show help\n");
            printf("exit         -   close employee-manager\n");
            break;
        }
        case EXIT: {
            exit(EXIT_SUCCESS);
        }
    }
    return 0;
}