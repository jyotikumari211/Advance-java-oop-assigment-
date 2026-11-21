# Advanced Learner Assignment — Java OOP (Hard Level)

This repository contains **10 Java programming solutions** and **10 non-programming OOP questions with answers**, matching the uploaded assignment requirement: 10 programming + 10 non-programming questions.

## Contents
- `PayrollSystem.java` — abstraction, inheritance and runtime polymorphism
- `ShapeInterfaceDemo.java` — abstract class, interface and polymorphism
- `BankWithCustomExceptions.java` — custom exception handling and synchronised methods
- `GenericRepository.java` — bounded generics, collections and `Optional`
- `LibraryManagement.java` — OOP design, encapsulation, maps and validation
- `MultithreadedTicketBooking.java` — threads, synchronisation and `join`
- `StrategyPattern.java` — interfaces, composition and Strategy design pattern
- `ComparableComparator.java` — `Comparable`, `Comparator` and collections
- `StudentManagementStreams.java` — collections, lambda expressions and streams
- `ThreadSafeInventory.java` — concurrent collections, atomic variables and CAS
- `NON_PROGRAMMING_QA.md` — 10 theory questions and answers

## Requirements
- JDK 8 or later (JDK 17 or 21 recommended)
- VS Code with Extension Pack for Java, Eclipse, IntelliJ IDEA, or terminal

## How to compile and run
Open a terminal in this folder. Compile and run one program at a time. Example:

```bash
javac PayrollSystem.java
java PayrollSystem
```

For another file, use its filename with `javac` and its public class name with `java`. For example:

```bash
javac MultithreadedTicketBooking.java
java MultithreadedTicketBooking
```

Each `.java` file is self-contained. Do not compile all files together in one command because several examples intentionally define their own supporting classes with simple names.

## Upload this folder to GitHub (browser method)
1. Sign in at https://github.com/ or create an account.
2. Click the **+** icon (top-right) → **New repository**.
3. Name it `advanced-java-oop-assignment`.
4. Add a description such as `Advanced Java OOP assignment: 10 programs and 10 theory answers`.
5. Choose **Public** if your teacher needs to view it, or **Private** if instructed.
6. Select **Add a README file** only if you want GitHub to create one. This folder already contains a README; if you create one on GitHub, avoid uploading a duplicate or replace it with this one.
7. Click **Create repository**.
8. Open the repository → **Add file** → **Upload files**.
9. Upload the 10 `.java` files, `NON_PROGRAMMING_QA.md`, and `README.md` from this folder. You can select multiple files. If GitHub's browser uploader does not accept a folder, upload the files and preserve their names.
10. In **Commit changes**, enter `Add advanced Java OOP assignment solutions`, then click **Commit changes**.
11. Open the repository and check that all files are visible. Copy the repository URL and submit it as instructed by your teacher.

## Git command-line method (optional)
After creating an empty repository on GitHub, open a terminal in this folder and run:

```bash
git init
git add .
git commit -m "Add advanced Java OOP assignment solutions"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/advanced-java-oop-assignment.git
git push -u origin main
```

Replace `YOUR-USERNAME` with your GitHub username. If Git asks you to authenticate, complete the browser sign-in flow or use GitHub's supported authentication method. Never put your password or access token inside the repository.

## Suggested evidence for submission
- Screenshot of the repository home page showing the project name and files.
- Screenshot of at least one Java program running successfully.
- Repository URL pasted into your assignment submission.

## Important
Read each program, run it, and understand the output before submitting. Change sample names/data if needed and follow your teacher's rules about individual work, repository visibility, and submission format.
