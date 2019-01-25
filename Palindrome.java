// Author: Joshua Abbott
// Date: 01/17/2019

import java.util.Scanner;

public class Palindrome
{
    static boolean isPalindrome(String userPhrase)
    {
        userPhrase = userPhrase.replaceAll("\\s+", ""); // This replaces the spaces
        String reverseUserPhrase = "";

        for(int i = userPhrase.length() - 1; i >= 0; i--)
        {
            reverseUserPhrase += userPhrase.charAt(i);
        }

        if(userPhrase.equals(reverseUserPhrase))
            return true;
        else
            return false;

    }
    static void printResult(boolean result)
    {
        if(result == true)
            System.out.println("Yes, that is a palindrome.");
        else
            System.out.println("No, that is not a palindrome.");
    }

    public static void main(String[] args)
    {

        // With scanner
        if(args.length == 0)
        {
            /*System.err.println("Failed to enter a palindrome.");
            System.exit(1);*/

            // With scanner
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter a palindrome: ");
            String palindrome = input.nextLine();

            System.out.println(palindrome);
            printResult(isPalindrome(palindrome));
        }
        // With console:
        else
        {
           String palindrome = "";
            for(int i = 0; i < args.length; i++)
                palindrome += args[i];

            System.out.println(palindrome);
            printResult(isPalindrome(palindrome));
        }
    }
}
