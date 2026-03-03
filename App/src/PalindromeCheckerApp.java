/*
================================================================================================================
MAIN CLASS - PalindromeCheckerApp
================================================================================================================

Use Case 8: Linked List Based Palindrome Checker

Description:
This class demonstrates palindrome validation using a Singly Linked List.
The string is converted into a linked list, the second half is reversed,
and both halves are compared to validate palindrome logic.

At this stage, the application:
- Starts execution from the main method
- Displays a welcome message
- Shows application Version
- Accepts String input from the user
- Converts the String into a Singly Linked List
- Uses Fast and Slow pointer technique to find the middle
- Reverses the second half of the list in-place
- Compares both halves of the list
- Prints whether the String is Palindrome or Not

Key Concepts:
Singly Linked List – A dynamic data structure where elements are connected using node references.
Node Traversal – Sequential access to elements using next references.
Fast and Slow Pointer Technique – Efficiently finds the middle of the linked list.
In-Place Reversal – Reverses the second half without using extra memory.

Data Structures Used: Singly Linked List

@author Vansh
@version 8.0
================================================================================================================
*/

import java.util.Scanner;

public class PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Application Version: 8.0");
        System.out.println("Use Case 8 - Linked List Based Palindrome Demonstration");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < processedInput.length(); i++) {
            Node newNode = new Node(processedInput.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        if (head == null || head.next == null) {
            System.out.println("Result: The given string is a Palindrome.");
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}