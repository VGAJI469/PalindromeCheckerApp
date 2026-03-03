/*
================================================================================================================
MAIN CLASS - PalindromeCheckerApp
================================================================================================================

Use Case 11: Object-Oriented Palindrome Service

Description:
This class demonstrates palindrome validation using Object-Oriented principles.
The palindrome logic is encapsulated inside a separate service class
and exposed through a public method.

At this stage, the application:
- Starts execution from the main method
- Displays a welcome message
- Shows application Version
- Accepts String input from the user
- Delegates palindrome validation to PalindromeChecker class
- Prints whether the String is Palindrome or Not

Key Concepts:
Encapsulation – Wrapping palindrome logic inside a dedicated class.
Single Responsibility Principle – Each class handles a single responsibility.
Abstraction – Exposes only required behavior via public method.

Data Structures Used: Character Array (Internal Processing)

@author Vansh
@version 11.0
================================================================================================================
*/

import java.util.Scanner;

class PalindromeChecker {

    public boolean checkPalindrome(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        char[] chars = normalized.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Application Version: 11.0");
        System.out.println("Use Case 11 - Object Oriented Palindrome Service");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}