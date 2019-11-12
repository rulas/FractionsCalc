package com.onelogin.challenges;

import java.util.Scanner;
import java.util.logging.Logger;

public class FracCalculator {

    private final static Logger LOG = Logger.getLogger(FracCalculator.class.getName());

    public static String calc(String args) {

        String[] tokens = args.split("\\s+");
        Fraction a = new Fraction(tokens[0]);
        Fraction b = new Fraction(tokens[2]);

        LOG.info("Processing these operations: " + args);

        switch (tokens[1]) {
            case "+":
                a.add(b);
                break;
            case "-":
                a.subtract(b);
                break;
            case "*":
                a.multiply(b);
                break;
            case "/":
                a.divide(b);
                break;
        }

        return a.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));

        System.out.print("? ");
        String input = scanner.next();

        String result = FracCalculator.calc(input);

        System.out.println(String.format("= %s", result));
    }
}
