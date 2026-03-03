/*
================================================================================================================
MAIN CLASS - PalindromeCheckerApp
================================================================================================================

Use Case 10: Case-Insensitive & Space-Ignored Palindrome

Description:
This class demonstrates palindrome validation by ignoring spaces
and character case differences. The input string is normalized
before applying palindrome checking logic.

At this stage, the application:
- Starts execution from the main method
- Displays a welcome message
- Shows application Version
- Accepts String input from the user
- Normalizes the string by removing spaces and converting to lowercase
- Applies palindrome checking logic
- Prints whether the String is Palindrome or Not

Key Concepts:
String Preprocessing – Cleaning and preparing input data before validation.
Regular Expressions – Used to remove whitespace characters.
Two-Pointer Technique – Compares characters from start and end positions.

Data Structures Used: String / Character Array

@author Vansh
@version 10.0
================================================================================================================
*/

import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Application Version: 10.0");
        System.out.println("Use Case 10 - Case Insensitive & Space Ignored Palindrome");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = normalized.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}