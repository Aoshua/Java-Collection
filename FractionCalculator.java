// Author:              Joshua Abbott
// Date:                01/25/2019
// Additional files:    Fraction.java

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FractionCalculator
{
    static	String regex =
            "(-?[0-9]+)[ \t]*/[ \t]*(-?[0-9]+)[ \t]*([+-/\\*])[ \t]*(-?[0-9]+)[ \t]*/[ \t]*(-?[0-9]+)";

    public static void main(String[] args)
    {
        // Variables:
        int num1 = 0, num2 = 0, den1 = 0, den2 = 0;
        char operator = 'a';

        // Prompt user:
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome!\nPlease enter a fraction expression (e.g. '1/3 + 2/5'): ");
        String userFrac = input.nextLine();

        // Validate input:
        if (userFrac.matches(regex))
        {
            // Parse the string:
            Matcher inputMatcher = Pattern.compile(regex).matcher(userFrac);

            if(inputMatcher.find())
            {
                num1 = Integer.parseInt(inputMatcher.group(1));
                den1 = Integer.parseInt(inputMatcher.group(2));
                operator = inputMatcher.group(3).charAt(0);
                num2 = Integer.parseInt(inputMatcher.group(4));
                den2 = Integer.parseInt(inputMatcher.group(5));
                // Test values caught:
                /*System.out.println(num1);
                System.out.println(den1);
                System.out.println(operator);
                System.out.println(num2);
                System.out.println(den2);*/
            } else { System.exit(2);}

            // Construct fraction objects:
            Fraction fraction1 = new Fraction(num1, den1);
            Fraction fraction2 = new Fraction(num2, den2);
            Fraction resultingFraction = new Fraction(1);

            // Determine and preform operation:
            if(operator == '+') { resultingFraction = fraction1.add(fraction2); }

            else if(operator == '-') { resultingFraction = fraction1.sub(fraction2); }

            else if(operator == '*') { resultingFraction = fraction1.mult(fraction2); }

            else if(operator == '/') { resultingFraction = fraction1.div(fraction2); }

            else { System.exit(3);}

            // Display result:
            System.out.println(resultingFraction.toString());

        }
        else
        {
            System.out.println("Error: Invalid input.");
            System.exit(1);
        }
    }
}
