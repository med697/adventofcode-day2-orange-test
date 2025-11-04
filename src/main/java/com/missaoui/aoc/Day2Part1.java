package com.missaoui.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day2Part1 {

    public static void main(String[] args) throws IOException {
        List<String> lines = readInput("input.txt"); // or use args[0]
        int safeCount = 0;
        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            if (isSafeReport(line)) safeCount++;
        }
        System.out.println("Number of safe reports: " + safeCount);
    }

    static List<String> readInput(String path) throws IOException {
        Path p = Paths.get(path);
        if (Files.exists(p)) {
            return Files.readAllLines(p);
        } else {
            // fallback to example if file missing
            return List.of(
                    "7 6 4 2 1",
                    "1 2 7 8 9",
                    "9 7 6 2 1",
                    "1 3 2 4 5",
                    "8 6 4 4 1",
                    "1 3 6 7 9"
            );
        }
    }

    static boolean isSafeReport(String report) {
        String[] parts = report.trim().split("\\s+");
        int n = parts.length;
        if (n < 2) return true; // trivial

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(parts[i]);

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            int adiff = Math.abs(diff);
            if (adiff < 1 || adiff > 3) return false; // difference out of range
            if (diff > 0) decreasing = false;
            if (diff < 0) increasing = false;
            if (diff == 0) return false; // equal numbers are invalid (neither inc nor dec)
        }

        return increasing || decreasing;
    }
}