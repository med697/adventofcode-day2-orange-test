package com.missaoui.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * Advent of Code 2024 - Day 2 (Part 1)
 * Author: Mohamed Missaoui
 *
 * Description:
 *   Determines how many reactor reports are "safe".
 *   A report is considered safe if:
 *     - All levels are strictly increasing or strictly decreasing.
 *     - The difference between any two adjacent levels is between 1 and 3 (inclusive).
 */
public class Day2Part1 {

    public static void main(String[] args) {
        try {
            List<String> reports = readInput("input.txt");
            long safeReports = reports.stream()
                    .filter(line -> !line.isBlank())
                    .filter(Day2Part1::isSafeReport)
                    .count();

            System.out.printf("✅ Number of safe reports: %d%n", safeReports);
        } catch (IOException e) {
            System.err.println("❌ Error reading input: " + e.getMessage());
        }
    }

    /**
     * Reads the input file lines or returns sample data if file is missing.
     */
    private static List<String> readInput(String fileName) throws IOException {
        Path path = Path.of(fileName);
        if (Files.exists(path)) {
            return Files.readAllLines(path);
        }

        // Fallback example input
        return List.of(
                "7 6 4 2 1",
                "1 2 7 8 9",
                "9 7 6 2 1",
                "1 3 2 4 5",
                "8 6 4 4 1",
                "1 3 6 7 9"
        );
    }

    /**
     * Checks whether a given report is safe.
     */
    private static boolean isSafeReport(String report) {
        int[] levels = Arrays.stream(report.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < levels.length; i++) {
            int diff = levels[i] - levels[i - 1];
            if (diff == 0 || Math.abs(diff) > 3) {
                return false; // violates the rules
            }
            if (diff > 0) decreasing = false;
            if (diff < 0) increasing = false;
        }

        return increasing || decreasing;
    }
}
