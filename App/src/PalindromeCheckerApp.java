import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Palidrome Checker App Management System");
//        // Hardcoded string
//        String word = "madam";
//
//        // Reverse the string
        String reversed = "";
//
//        for (int i = word.length() - 1; i >= 0; i--) {
//            reversed = reversed + word.charAt(i);
//        }
//
//        // Check if palindrome using if-else
//        if (word.equals(reversed)) {
//            System.out.println(word + " is a Palindrome.");
//        } else {
//            System.out.println(word + " is NOT a Palindrome.");
//        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String original = scanner.nextLine();
        String LowercasedString = original.toLowerCase();


        for (int i = LowercasedString.length() - 1; i >= 0; i--) {
            reversed = reversed + LowercasedString.charAt(i);
        }
        boolean isPalindrome = LowercasedString.equals(reversed);
        System.out.println(isPalindrome);
        scanner.close();


    }

}