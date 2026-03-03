/*
================================================================================================================
MAIN CLASS - PalindromeCheckerApp
================================================================================================================

Use Case 13: Performance Comparison

Description:
This class demonstrates performance comparison of different palindrome
checking approaches. Execution time for each algorithm is measured
using System.nanoTime() and displayed for analysis.

At this stage, the application:
- Starts execution from the main method
- Displays a welcome message
- Shows application Version
- Accepts String input from the user
- Executes multiple palindrome algorithms
- Captures execution time using System.nanoTime()
- Displays individual execution times
- Displays palindrome validation result

Key Concepts:
System.nanoTime() – Provides high-resolution time measurement.
Algorithm Comparison – Evaluates performance of different approaches.
Time Complexity Awareness – Understands cost of operations.

Data Structures Used: Stack / Deque / Recursion

@author Vansh
@version 13.0
================================================================================================================
*/

import java.util.*;

public class PalindromeCheckerApp {

    public static boolean stackMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequeMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public static boolean recursiveMethod(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursiveMethod(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Application Version: 13.0");
        System.out.println("Use Case 13 - Performance Comparison");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        long startTime, endTime;

        startTime = System.nanoTime();
        boolean stackResult = stackMethod(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean dequeResult = dequeMethod(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean recursiveResult = recursiveMethod(normalized, 0, normalized.length() - 1);
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        System.out.println("\nStack Method Result: " + stackResult);
        System.out.println("Stack Execution Time (ns): " + stackTime);

        System.out.println("\nDeque Method Result: " + dequeResult);
        System.out.println("Deque Execution Time (ns): " + dequeTime);

        System.out.println("\nRecursive Method Result: " + recursiveResult);
        System.out.println("Recursive Execution Time (ns): " + recursiveTime);

        scanner.close();
    }
}