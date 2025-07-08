# Merge Conflict

In this exercise, we want you to experience a merge conflict and solve it appropriately by creating a merge commit. Clone the remote repository to get a local repository on your computer. Open this working copy.

`Warning: In order to achieve all the points in this exercise, you must complete the given task in the exact order and only do what you are being told to do. If you mess up a step (for example by pulling without being asked to do so), you must start from the beginning to achieve all the pointsmv .* exercise/!`

## Part 1: Commit your solution

Create a class named `Hello` and print `Hello World!` within the _main_ method using _System.out.println()_.

1. **Change the statement**

    Stage the change within your working copy (add file to repo), write a meaningful commit message, and commit the change into your `local repository`. Push your changes to the `remote repository`.

    Hint: You may use a meaningful commit message with prefixes like feat:, fix:, or chore: to follow common Git conventions.

## Part 2: Merge conflict

We will now simulate a merge conflict. This will help you learn how to properly handle such situations.

Merge conflicts occur when two people work on the same lines in the same files at the same time.

`Important: From now on, do not pull changes, unless we explicitly ask you!`

Because this code is only being shown to EIST students, we want you to change the statement to `"Hello EIST!"`. Update the statement in the `Hello` class accordingly, stage your changes and commit your changes to the local repository.

Try to push your changes. You will notice that this is not possible and receive an error message saying that the `remote contains work that you do not have locally`.
**Explanation: Another developer was not aware of your changes and pushed theirs before you. Therefore, you must pull the latest changes before pushing your own commit.**

1. **Resolve the conflict**

    Review the conflict and resolve it in a meaningful way: Print `"Hello EIST 2025!"`.

    Stage and commit your changes with a meaningful commit message, and push the changes to the `remote repository`.