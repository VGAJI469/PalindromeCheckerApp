/*
================================================================================================================
MAIN CLASS - PalindromeCheckerApp
================================================================================================================

Use Case 12: Strategy Pattern for Palindrome Algorithms (Advanced)

Description:
This class demonstrates dynamic selection of palindrome algorithms
using the Strategy Design Pattern. Different palindrome validation
strategies can be injected at runtime.

At this stage, the application:
- Starts execution from the main method
- Displays a welcome message
- Shows application Version
- Accepts String input from the user
- Allows user to choose a palindrome strategy
- Injects selected strategy at runtime
- Executes palindrome validation using chosen algorithm
- Prints whether the String is Palindrome or Not

Key Concepts:
Interface – Defines a common contract for all palindrome strategies.
Polymorphism – Enables dynamic method dispatch at runtime.
Strategy Pattern – Encapsulates interchangeable algorithms.
Dependency Injection – Injects selected strategy into context.

Data Structures Used: Stack / Deque (Varies per strategy)

@author Vansh
@version 12.0
================================================================================================================
*/

import java.util.*;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {
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
}

class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {
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
}

class PalindromeService {

    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Application Version: 12.0");
        System.out.println("Use Case 12 - Strategy Pattern Palindrome Checker");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeService service = new PalindromeService(strategy);
        boolean result = service.execute(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}