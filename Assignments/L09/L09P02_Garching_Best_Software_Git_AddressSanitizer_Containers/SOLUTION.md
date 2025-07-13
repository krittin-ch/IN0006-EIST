# Solution of Exercise L09P02

## Part 1: Git

The exercise should be done through terminal only.

**1. Branch Creation And Merging**

```
git checkout feature/new_feature_A
git merge feature/new_feature_B
git checkout main
git merge feature/new_feature_A
git push
```

**2. Solving Merge Conflicts**

```
git checkout main 
git merge feature/new_feature_D
git merge feature/new_feature_E

<<<<< FIX CONFLICT >>>>>

git add .
git commit -m "calculateBonus.c resolved"
git push origin main
```

**3. Squashing and Merging**

```
git checkout feature/new_feature_F
git rebase -i main 

<<<<< CHANGE "pick" TO "squash" EXCEPT THE FIRST ONE >>>>>

git checkout main
git merge feature/new_feature_F
git push origin main
```

**4. Cherry-Picking Commits**

Use command `git log --oneline --graph` to see the commit code before cherry-picking.

```
git cherry-pick <commit>
git push origin main
```

## Part 2: Dynamic Analysis

**1. Detecting Address Safety Bugs Using GCC Address Sanitizer**

Open terminal and type `gcc -fsanitize=address -g *.c -o employee-manager`

- `-g`: 
- `-o`: 

Type `help` to see other commands.

Type the following commands:

```
CMD: add_entry
Enter first name: SUPER_LONG_NAME
```

The memory error will occur which can be fixed by changing  `#define NAME_LENGTH 16` to `#define NAME_LENGTH 50` or larger number in `executeCommand.h`