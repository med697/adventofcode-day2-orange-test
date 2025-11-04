# Advent of Code 2024 - Day 2 (Red-Nosed Reports)

**Language:** Java  
**Author:** Missaoui Mohamed habib   
**Context:** Test technique - Orange (Stage IG Fullstack - Gestion d’un vault)

---

## 🧩 Problem Description

Given several reports (each a list of levels), a report is **safe** if:

1. All levels are either strictly increasing or strictly decreasing.
2. Adjacent levels differ by **at least 1** and **at most 3**.

Example:

7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9


Result → 2 reports are safe.

---

## 🧠 Approach

- Read input from `input.txt`.
- Parse each line into integers.
- Check:
    - All increasing **OR** all decreasing.
    - |diff| between adjacent numbers is within **[1, 3]**.
- Count and print the number of safe reports.

---

## ⚙️ How to Run

1. Put your input data in `input.txt` (one report per line).
2. Compile and run:

```bash
javac -d out src/main/java/com/missaoui/aoc/Day2Part1.java
java -cp out com.missaoui.aoc.Day2Part1
Output example:


Number of safe reports: 2
🧾 Notes
Implemented using Java 17 (Amazon Corretto 17)

No external dependencies

Simple console-based solution for the Advent of Code 2024, Day 2

Optional: replace input.txt with the actual puzzle input for testing

© 2025  Missaoui Mohamed habib
