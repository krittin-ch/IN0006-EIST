# Git, Dynamic Analysis and Containerization

## Background

You recently started your first job as a software developer at a startup called Garching Best Software (GBS). GBS is developing software to manage employee data, and the codebase is written in C. Unfortunately, the sole developer working on this project left the company without notice, leaving the codebase in a terrible condition.

The software should consist of a main application and an external database. The application accepts input via the command line, processes the data, and stores the results in the database. While the application is not yet fully developed, this is not a priority at the moment. You have decided to resolve the existing issues in the codebase before continuing with further development.

## Setup

The following command needs to be run before you can attempt the exercises:

```
python setup.py
```

If the above command fails, you may need to replace **"python"** with **"python3"**.

If the script ran correctly, you should be able to see feature branches **A, B, D, E, F** and **G** when using the command **"git branch"**.

## Part 1: Git

It seems like there are many features that are already developed, but are yet to be merged into the appropriate branches. Your plan is to clean up the repo's commits before proceeding. In the following questions, you **must only use Git commands**. Editing the code in your IDE will result in zero points. You may use software like git-graph, or similar, to aid you in this task.

**Please be aware that the remote git history cannot be changed, once pushed it is final.**

**1. Branch Creation And Merging**

You have noticed there are two open branches with different features. Namely the new features are found on **feature/new_feature_A**, **feature/new_feature_B**. Combine these features into a new branch called **feature/new_feature_C**. Merge **feature/new_feature_C** into the main branch. Do not rewrite the git history for this subquestion.

**2. Solving Merge Conflicts**

There are also branches **feature/new_feature_D** and **feature/new_feature_E** which seem to change the same function. Merge the two branches into the main branch and maintain the way that **feature/new_feature_E** calculates the bonus. Do not rewrite the git history.

**3. Squashing and Merging**

You now want to merge **feature/new_feature_F** onto the main branch. The problem is that there are a lot of unnecessary commits on this branch. Squash all commits on **feature/new_feature_F** into a single commit with the following commit message:

Commit Message:

```
Added loadEntryFile.c

Added loadEntryFile.h

fixed typo in loadEntryFile.c

fixed typo in loadEntryFile.c for real
```

Merge this squashed commit into the main branch. The main branch must not contain any of the individual commits, just the combined commit. You may rewrite git history in this question, but be careful not to overwrite your previous answers!

**4. Cherry-Picking Commits**

You want one feature from **feature/new_feature_G** in your main branch. The problem is that you want the commit with the message **"Added superSecretFeature.c"**, but not the next commit **"Added super secret function"**. Merge only the commit with the message **"Added superSecretFeature.c"** into your main branch. You may rewrite git history in this question, but be careful not to overwrite your previous answers! Hint: look up the command **"git cherry-pick"**

## Part 2: Dynamic Analysis

You discover that your predecessor was relatively new to C development and did not have a good grasp of memory safety. You decide to investigate further.

To build the application, run the command **make**, which will build the application. Execute the application via the command line. For example, on a Linux system, **run ./employee-manager**.

**Hint:** The build with the Makefile does not include Address Sanitizer. You might want to add it.

**1. Detecting Address Safety Bugs Using GCC Address Sanitizer**

Use the address sanitizer of GCC to detect both address safety bugs in the source file **"executeCommand.c"** of the program.

**Hint:** Try entering and deleting different employee-data with the address sanitizer enabled.

## Part 3: Containerization

To make the software more portable, the application was dockerized. The problem is that your predecessor was not experienced with Docker either...

**1. Assembling a Container Application Image Using Dockerfile**

The Dockerfile for the C application does not seem to work. There are several mistakes in the Dockerfile. Fix these so you can assemble an image of your application.

The following Dockerfile specifications were given by the startup:

```
Set gcc:latest as the base image.

Set the working directory to /usr/src/employee-manager. The working directory is the directory where the commands in the Dockerfile are executed.

Create a command that copies the application directory into the working directory. Note that we set the working directory in step 2 and therefore, can simply copy the application directory to the current directory.

Create a command that runs the compilation procedure of the provided Makefile for the employee-manager application.

Add a line with the fitting command (replace with command ./employee-manager) to your Dockerfile. This command ensures that the defined application will be executed as part of building the Docker image.
```

**2. Building a Container Application Image with a Docker Command**

In the file **"docker_command.txt"** add the command that you would use to build the image with the name employee-manager.

**Note that it is not required for you to build the image during the exam. Simply push the fixed Dockerfile and docker_command.txt to the master branch.**

**3. Defining a Multi-Container Application Using Docker Compose**

For the software to work, both the image of the C application and the database (in a separate image) have to run together. To achieve this, the project uses Docker Compose. The problem is that the **"docker-compose.yaml"** file has not been completed. Complete the Docker Compose file, keeping in mind the command for building you used in the last question.

Following specifications for the Docker Compose file were given by the startup:

```
Define the following services:
    1. employee-manager-postgres:
        a. Set postgres:latest as the base image
        b. Set the container name to employee-manager-postgres
        c. Define the following volumes:
            - employee-manager.data with the path /var/lib/postgresql/data
        d. Define the following environment variables:
            - POSTGRES_DB with the value employee-manager
            - POSTGRES_USER with the value admin
            - POSTGRES_PASSWORD with the value pass
        e. Reserve the following ports:
            - 5432:5432
    2. employee-manager-app:
        a. Set the application directory as the build image
        b. Set the container name to employee-manager-app
        c. Define the following environment variables:
            - DB_SERVER with the value employee-manager-postgres
        d. Reserve the following ports:
            - 8080:8080
        e. Create a dependency on the following services:
            - employee-manager-postgres
        f. Enable interactive shell mode by setting stdin_open and tty
           to true

Define the following volumes:
    1. employee-manager-data with an empty body
```

**Note that it has to be in valid YAML formatting.**

**4. Running a Multi-Container Application with a Docker Compose Command**

In the **"compose_command.txt"** file, add the command you would use to run Docker Compose for this example.

**Note that you do not need to run Docker Compose since you did not build an image earlier, and you don't have the database image downloaded. Simply update the docker-compose.yml and compose_command.txt then push the result to the master branch.**
