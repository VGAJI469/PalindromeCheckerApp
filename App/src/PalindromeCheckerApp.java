/*
================================================================================================================
MAIN CLASS - PalindromeCheckerApp
================================================================================================================

Use Case 7: Deque-Based Optimized Palindrome Checker

Description:
This class demonstrates palindrome validation using a Deque
(Double Ended Queue) to compare front and rear elements efficiently.

At this stage, the application:
- Starts execution from the main method
- Displays a welcome message
- Shows application Version
- Accepts String input from the user
- Inserts characters into a Deque
- Removes first and last elements
- Compares both elements until the structure becomes empty
- Validates Palindrome logic using bidirectional access
- Prints whether the String is Palindrome or Not

Key Concepts:
Deque – A data structure that allows insertion and deletion from both ends.
Front and Rear Access – Enables direct comparison of first and last characters.
Optimized Data Handling – Eliminates the need for separate reversal data structures.
Bidirectional Removal – Supports efficient palindrome validation.

Data Structures Used: Deque

@author Vansh
@version 7.0
================================================================================================================
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Application Version: 7.0");
        System.out.println("Use Case 7 - Deque Based Palindrome Demonstration");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < processedInput.length(); i++) {
            deque.addLast(processedInput.charAt(i));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}