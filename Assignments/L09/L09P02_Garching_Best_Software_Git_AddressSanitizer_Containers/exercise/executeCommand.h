#define NAME_LENGTH 16

//data structure storing employee data, should this be struct, union or array
//implement data entries of employees as linked list
struct employeeInfo{
    char firstName [NAME_LENGTH];
    char lastName [NAME_LENGTH];
    int performanceGrade;
    float salary;
    float bonus;
    struct employeeInfo *next;
    struct employeeInfo *prev;
};

int executeCommand(int commandID, struct systemState *state);