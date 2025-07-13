#define INPUT_COMMAND_LENGTH 32

//Input commands
enum input_commands {
    ERROR,
    NEW_ENTRY, //add new entry
    VIEW_ENTRY,
    DELETE_ENTRY, //delete data entry
    SAVE_DATA, //write to database, dont actually implement, leave as dummy function
    LOAD_FILE, // load in multiple data entries from text file
    CALCULATE_BONUS, //some function to calculate employee bonus, !can do illegal memory reads here
    GIVE_GRADE, // give an employee a performance grade
    NEXT_ENTRY,
    PREVIOUS_ENTRY,
    SHOW_HELP,
    EXIT
};

//State (stores state of program)
struct systemState {
    int numEntries; // how many employees are in work space now
    int selectedEntryNumber; // number of currently selected entry in list
    struct employeeInfo *selectedEntry; // Current entry selected in list
};