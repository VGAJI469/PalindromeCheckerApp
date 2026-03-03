/*
================================================================================================================
MAIN CLASS - UseCase5PalindromeApp
================================================================================================================

Use Case 5: Palindrome Validation Using Stack (LIFO Principle)

Description:
This class represents palindrome validation using
a Hardcoded String Value and Stack Data Structure.

At this stage, the application:
- Starts execution from the main method
- Displays a welcome message
- Shows application Version
- Stores a Hardcoded String
- Pushes each character of the String into a Stack
- Pops characters from the Stack to reverse the String
- Compares the Original String with the Reversed String
- Prints whether the String is Palindrome or Not
- Displays both Original and Reversed Strings


The goal is to find if a Hardcoded string is Palindrome or not
using Stack (LIFO - Last In First Out).

Key Concepts:
Stack – A linear data structure that follows the Last In First Out (LIFO) principle.
Push Operation – Used to insert characters into the stack.
Pop Operation – Used to remove characters from the stack in reverse order.
Reversal Logic – Stack naturally reverses the order of elements.

@author SAKET-2005
@version 5.0
 */

import java.util.Stack;

public class PalindromeCheckerApp
{
    public static void main(String args[])
    {
        System.out.println("Welcome to The Palindrome Checker");

        String txt = "123321";

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < txt.length(); i++)
        {
            stack.push(txt.charAt(i));
        }

        String reversed = "";

        while(!stack.isEmpty())
        {
            reversed = reversed + stack.pop();
        }

        System.out.println("Original String: " + txt);
        System.out.println("Reversed String: " + reversed);

        if(txt.equals(reversed))
            System.out.println("The String " + txt + " is a Palindrome");
        else
            System.out.println("The String " + txt + " is Not a Palindrome");
    }
}