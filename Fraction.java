// Author:              Joshua Abbott
// Date:                01/25/2019
// Additional files:    FractionCalculator.java

public class Fraction
{
    // Variables:
    private int numerator;
    private int denominator;

    // Constructors:

    public Fraction(int numerator)
    {
        this.numerator = numerator;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator)
    {
        // Reduce the fraction to lowest terms:
        int divisor = gcd(numerator, denominator);
        this.numerator = numerator / divisor;
        this.denominator = denominator / divisor;
    }

    // Methods:

    public Fraction add(Fraction right)
    {
        int den1 = this.denominator;
        int den2 = right.denominator;

        if(gcd(den1, den2) == 1)
        {
            this.numerator *= den2;
            this.denominator *= den2;
            right.numerator *= den1;
            right.denominator *= den1;
        }
        else if (den1 == den2){ /* Do nothing */ }
        else if (den1 > den2)
        {
            int scalar = den1 / den2;
            right.numerator *= scalar;
            right.denominator *= scalar;
        }
        else
        {
            int scalar = den2 / den1;
            this.numerator *= scalar;
            this.denominator *= scalar;
        }

        // Finally add the fractions:
        this.numerator += right.numerator;
        return this.reduce();
    }

    public Fraction sub(Fraction right)
    {
        int den1 = this.denominator;
        int den2 = right.denominator;

        if(gcd(den1, den2) == 1)
        {
            this.numerator *= den2;
            this.denominator *= den2;
            right.numerator *= den1;
            right.denominator *= den1;
        }
        else if (den1 == den2){ /* Do nothing */ }
        else if (den1 > den2)
        {
            int scalar = den1 / den2;
            right.numerator *= scalar;
            right.denominator *= scalar;
        }
        else
        {
            int scalar = den2 / den1;
            this.numerator *= scalar;
            this.denominator *= scalar;
        }

        // Finally subtract the fractions:
        this.numerator -= right.numerator;
        return this.reduce();
    }

    public Fraction mult(Fraction right)
    {
        this.numerator *= right.numerator;
        this.denominator *= right.denominator;
        return this.reduce();
    }

    public Fraction div(Fraction right)
    {
        this.numerator *= right.denominator;
        this.denominator *= right.numerator;
        return this.reduce();
    }

    public Fraction reduce()
    {
        int divisor = gcd(numerator, denominator);
        this.numerator = numerator / divisor;
        this.denominator = denominator / divisor;
        return this;
    }

    public String toString() { return this.numerator + "/" + this.denominator; }

    public boolean equals(Object other)
    {
        if (this == other) return true;                        // Test objects for equality
        if (other == null) return false;                       // Test for null
        if (getClass() != other.getClass())                    // Test classes for equality
            return false;
        if(!(other instanceof Fraction)) return false;         // Use instance of test

        var otherObject = (Fraction) other;                    // Cast variable to same class type
        return numerator == otherObject.numerator              // Return if fields match
                && denominator == otherObject.denominator;
    }

    private int gcd(int u, int v)   // Euclid's Algorithm
    {
        u = (u < 0) ? -u : u;       // Ensure that u is not negative
        v = (v < 0) ? -v : v;       // Ensure that v is not negative

        while (u > 0)
        {
            if (u < v)
            {
                int temp = u;
                u = v;
                v = temp;
            }
            u -= v;
        }
        return v;                   // v holds the GCD of u and v
    }
}
