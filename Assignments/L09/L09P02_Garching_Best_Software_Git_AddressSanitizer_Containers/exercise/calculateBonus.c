#include "executeCommand.h"
#include "main.h"


void calculate_bonus(struct employeeInfo *entry)
{
    //calculation of bonus factor
    float bonus_factor = 0.1;

    //calculation of grade factor
    float grade_factor = 1;

    //calculate_bonus
    entry->bonus = entry->salary * bonus_factor * grade_factor;
}