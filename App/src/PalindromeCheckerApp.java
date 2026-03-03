/*
================================================================================================================
MAIN CLASS - PalindromeCheckerApp
================================================================================================================

Use Case 9: Recursive Palindrome Checker

Description:
This class demonstrates palindrome validation using recursion.
The recursive method compares characters from the start and end
positions and reduces the problem size at each step.

At this stage, the application:
- Starts execution from the main method
- Displays a welcome message
- Shows application Version
- Accepts String input from the user
- Calls a recursive method to compare start and end characters
- Uses a base condition to terminate recursion
- Prints whether the String is Palindrome or Not

Key Concepts:
Recursion – A technique where a method calls itself to solve smaller subproblems.
Base Condition – Prevents infinite recursion and terminates recursive calls.
Call Stack – Memory structure used to manage method calls during recursion.
Divide and Conquer – Problem size reduces in each recursive step.

Data Structures Used: Call Stack

@author Vansh
@version 9.0
================================================================================================================
*/

import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Application Version: 9.0");
        System.out.println("Use Case 9 - Recursive Palindrome Demonstration");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(processedInput, 0, processedInput.length() - 1);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}