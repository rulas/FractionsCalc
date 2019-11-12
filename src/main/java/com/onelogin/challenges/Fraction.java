package com.onelogin.challenges;

import java.math.BigInteger;

import static java.lang.Math.abs;

public class Fraction {
    private long whole;
    private long numerator;
    private long denominator;

    public Fraction() {
        this(0, 0, 0);
    }

    public Fraction(long whole, long numerator, long denominator) {
        this.whole = whole;
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public Fraction(String number) {
        this();
        parseNumber(number);
    }

    private void parseNumber(String num) {
        String[] mixedParts = num.split("_");

        // this is either a whole or a fraction
        if (mixedParts.length == 1) {

            String[] split = mixedParts[0].split("/");
            if (split.length == 1) {
                // a whole
                parseWhole(split[0]);
            } else {
                // a fraction
                parseFraction(split);
            }

        } else if (mixedParts.length == 2) {
            parseWhole(mixedParts[0]);
            parseFraction(mixedParts[1].split("/"));
        } else {
            throw new NumberFormatException("Unable to parse this string as fraction: " + num);
        }

    }

    private void parseWhole(String whole) {
        this.whole = Long.parseLong(whole);
    }

    private void parseFraction(String[] fraction) {
        this.numerator = Long.parseLong(fraction[0]);
        this.denominator = Long.parseLong(fraction[1]);
        if (this.denominator == 0) {
            throw new IllegalArgumentException("Fraction denominator is '0'");
        }
    }

    private boolean hasFraction() {
        return this.denominator != 0;
    }


    private boolean hasWhole() {
        return this.whole != 0;
    }


    private boolean isZero() {
        return this.whole == 0L && this.numerator == 0L && this.denominator == 0L;
    }


    /**
     * @return the whole part of the mixed number
     */
    public Long getWhole() {
        return this.whole;
    }

    /**
     * @return the numerator of the mixed number
     */
    public Long getNumerator() {
        return this.numerator;
    }


    /**
     * @return the denominator of the mixed number
     */
    public Long getDenominator() {
        return this.denominator;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        if (!isZero()) {
            if (hasWhole()) {
                sb.append(this.whole);
            }

            if (hasFraction()) {
                if (hasWhole()) sb.append("_");
                sb.append(this.numerator).append("/").append(this.denominator);
            }
        } else {
            sb.append(0);
        }

        return sb.toString();
    }

    public Fraction add(Fraction other) {
        // convert to Improper Fractions
        this.toImproper();
        other.toImproper();

        // get the least common denominator and transform both fractions to that denominator
        long lcd = getLcd(this.getDenominator(), other.getDenominator());
        this.convert(lcd);
        other.convert(lcd);

        this.numerator += other.numerator;

        // Convert to Mixed Number
        this.toMixed();

        // reduce to simplest form
        this.toSimplestForm();

        return this;
    }


    public Fraction subtract(Fraction other) {
        // convert to Improper Fractions
        this.toImproper();
        other.toImproper();

        // get the least common denominator and transform both fractions to that denominator
        long lcd = getLcd(this.getDenominator(), other.getDenominator());
        this.convert(lcd);
        other.convert(lcd);


        this.numerator -= other.numerator;

        // Convert to Mixed Number
        this.toMixed();

        // reduce to simplest form
        this.toSimplestForm();

        return this;
    }

    public Fraction multiply(Fraction other) {
        // convert to Improper Fractions
        this.toImproper();
        other.toImproper();

        this.numerator *= other.numerator;
        this.denominator *= other.denominator;

        // Convert to Mixed Number
        this.toMixed();

        // reduce to simplest form
        this.toSimplestForm();

        return this;
    }

    public Fraction divide(Fraction other) {
        // convert to Improper Fractions
        this.toImproper();
        other.toImproper();

        this.numerator *= other.denominator;
        this.denominator *= other.numerator;

        // fix the number sign
        long sign = Long.signum(numerator) * Long.signum(denominator);
        this.numerator = sign * abs(this.numerator);
        this.denominator = abs(this.denominator);

        // Convert to Mixed Number
        this.toMixed();

        // reduce to simplest form
        this.toSimplestForm();

        return this;
    }


    /**
     * Converts it to an improper fractional number. The whole part is translated to fractional.
     *
     * @return the same object
     */
    public Fraction toImproper() {
        if (this.hasFraction()) {
            long sign = this.whole < 0 ? -1 : 1;
            this.numerator = abs(this.numerator) + abs(this.whole * this.denominator);
            this.numerator *= sign;
            this.whole = 0;
        } else {
            this.numerator = this.whole;
            this.denominator = 1;
            this.whole = 0;
        }

        return this;
    }

    private void toMixed() {
        long whole = this.numerator / this.denominator;
        long remainder = abs(this.numerator % this.denominator);

        this.whole = whole;
        if (remainder != 0) {
            this.numerator = remainder;
        } else {
            this.numerator = 0;
            this.denominator = 0;
        }
    }

    private void convert(long lcd) {
        long factor = lcd / this.denominator;
        this.numerator = factor * this.numerator;
        this.denominator = lcd;
    }


    /**
     * This method calculates the Greatest Common Divisor of 2 numbers
     *
     * @param n1 first number
     * @param n2 second number
     * @return the GCD of both numbers
     */
    private long getGcd(long n1, long n2) {

        BigInteger gcd = BigInteger.valueOf(n1).gcd(BigInteger.valueOf(n2));

        return gcd.longValue();
    }


    /**
     * This method calculate the least common denominator of 2 numbers.
     *
     * @param n1 number 1
     * @param n2 number 2
     * @return the LCD
     */
    private long getLcd(long n1, long n2) {
        long gcd = getGcd(n1, n2);
        return Math.max(gcd, Math.max(n1, n2));
    }

    private void toSimplestForm() {
        if (hasFraction()) {
            long gcd = getGcd(this.numerator, this.denominator);
            this.numerator = this.numerator / gcd;
            this.denominator = this.denominator / gcd;
        }
    }
}
