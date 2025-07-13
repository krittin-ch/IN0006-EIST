#Configures the repo for use in the exam. You must run this script before starting the exam.
#Install dependecies with: pip install -r requirements.txt
#Usage: python setup.py

#import git
import shutil
import os

def edit_line(file_name: str, line_number: int, new_line: str):
    with open(file_name, "r") as file:
        lines = file.readlines()
    lines[line_number-1] = new_line
    with open(file_name, "w") as file:
        file.writelines(lines)

if __name__ == "__main__":
    username = os.popen("git config user.name").read()
    email = os.popen("git config user.email").read()
    if username == "" or email == "":
        print(
           """
Author identity unknown

*** Please tell me who you are.

Run

  git config --global user.email "you@example.com"
  git config --global user.name "Your Name"

to set your account's default identity.
Omit --global to set the identity only in this repository.
""")
        exit(-1)

    #question a setup
    commit_message_a = "\"Added databaseInterface.c\""
    commit_message_b = "\"Added databaseInterface.h\""

    os.system("git checkout -b feature/new_feature_A")
    shutil.copy("setup_files/databaseInterface.c", "databaseInterface.c")
    os.system("git add --all .")
    os.system(f"git commit -m {commit_message_a}")
    os.system("git checkout main")
    os.system("git checkout -b feature/new_feature_B")
    shutil.copy("setup_files/databaseInterface.h", "databaseInterface.h")
    os.system("git add --all .")
    os.system(f"git commit -m {commit_message_b}")
    os.system("git checkout main")

    #question b setup
    commit_message_d = "\"Modified calculateBonus.c to include new feature D\""
    commit_message_e = "\"Modified calculateBonus.c to include new feature E\""
    featureD_string_grade_factor = "    float grade_factor = entry->performanceGrade / 10.0;\n" #line 11
    featureD_string_new_calculation = "    entry->bonus = entry->salary * bonus_factor * grade_factor * 0.5;\n" #line 14
    featureE_string_new_bonus_factor = "    float bonus_factor = 1000 / ( entry->salary);\n" #line 8
    featureE_string_new_calculation = "    entry->bonus = entry->salary * bonus_factor * grade_factor * 2;\n" #line 14

    os.system("git checkout -b feature/new_feature_D")
    edit_line("calculateBonus.c", 11, featureD_string_grade_factor)
    edit_line("calculateBonus.c", 14, featureD_string_new_calculation)
    os.system("git add --all .")
    os.system(f"git commit -m {commit_message_d}")
    os.system("git checkout main")
    os.system("git checkout -b feature/new_feature_E")
    edit_line("calculateBonus.c", 8, featureE_string_new_bonus_factor)
    edit_line("calculateBonus.c", 14, featureE_string_new_calculation)
    os.system("git add --all .")
    os.system(f"git commit -m {commit_message_e}")
    os.system("git checkout main")

    #question c setup
    commit_message_f_1 = "\"Added loadEntryFile.c\""
    commit_message_f_2 = "\"Added loadEntryFile.h\""
    commit_message_f_3 = "\"fixed typo in loadEntryFile.c\""
    commit_message_f_4 = "\"fixed typo in loadEntryFile.c for real\""
    featureF_string_fixed_typo = r'    printf("Loeding entry file\n");'+'\n' #line 6
    featureF_string_fixed_real = r'    printf("Loading entry file\n");'+'\n' #line 6
    os.system("git checkout -b feature/new_feature_F")
    shutil.copy("setup_files/loadEntryFile.c", "loadEntryFile.c")
    os.system("git add --all .")
    os.system(f"git commit -m {commit_message_f_1}")
    shutil.copy("setup_files/loadEntryFile.h", "loadEntryFile.h")
    os.system("git add --all .")
    os.system(f"git commit -m {commit_message_f_2}")
    edit_line("loadEntryFile.c", 6, featureF_string_fixed_typo)
    os.system("git add --all .")
    os.system(f"git commit -m {commit_message_f_3}")
    edit_line("loadEntryFile.c", 6, featureF_string_fixed_real)
    os.system("git add --all .")
    os.system(f"git commit -m {commit_message_f_4}")
    os.system("git checkout main")

    #question d setup
    commit_message_g_1 = "\"Added superSecretFeature.c\""
    commit_message_g_2 = "\"Added super secret function\""
    featureG_string_secret = "    return a + b;\n" #line 3
    os.system("git checkout -b feature/new_feature_G")
    shutil.copy("setup_files/superSecretFeature.c", "superSecretFeature.c")
    os.system("git add --all .")
    os.system(f"git commit -m {commit_message_g_1}")
    edit_line("superSecretFeature.c", 3, featureG_string_secret)
    os.system("git add --all .")
    os.system(f"git commit -m {commit_message_g_2}")
    os.system(f"git checkout main")
    print("Setup Done!")
