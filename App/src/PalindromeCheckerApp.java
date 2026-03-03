/*
================================================================================================================
MAIN CLASS - UseCase6QueueStackPalindromeApp
================================================================================================================

Use Case 6: Demonstration of FIFO vs LIFO using Queue and Stack

Description:
This class demonstrates the behavioral difference between
Queue (FIFO – First In First Out) and
Stack (LIFO – Last In First Out) using a Hardcoded String.

At this stage, the application:
- Starts execution from the main method
- Displays a welcome message
- Shows application Version
- Stores a Hardcoded String
- Enqueues characters into a Queue (FIFO)
- Pushes characters into a Stack (LIFO)
- Compares Dequeue (Queue) output with Pop (Stack) output
- Validates Palindrome logic using structural behavior
- Prints whether the String is Palindrome or Not

Key Concepts:
Queue – A linear data structure that follows the First In First Out (FIFO) principle.
Enqueue & Dequeue Operations – Used to insert and remove elements from the queue.
Stack – A linear data structure that follows the Last In First Out (LIFO) principle.
Push & Pop Operations – Used to insert and remove elements from the stack.
Logical Comparison – Matching dequeue (queue) output with pop (stack) output to validate palindrome logic.

Data Structures Used: Queue, Stack

@author Vansh
@version 6.0
================================================================================================================
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp{

    public static void main(String[] args) {

        System.out.println("Application Version: 6.0");
        System.out.println("Use Case 6 - Queue vs Stack Palindrome Demonstration");

        String input = "madam";
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < processedInput.length(); i++) {
            char ch = processedInput.charAt(i);
            queue.add(ch);
            stack.push(ch);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            char fromQueue = queue.remove();
            char fromStack = stack.pop();

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }
    }
}