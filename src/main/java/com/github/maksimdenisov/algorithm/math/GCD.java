package com.github.maksimdenisov.algorithm.math;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * the Euclidean algorithm is an efficient method
 * for computing the greatest common divisor (GCD)
 * of two integers (numbers), the largest number
 * that divides them both without a remainder.
 */

public class GCD {
    public static void main(String[] args) {
        System.out.println("Computing the greatest common divisor");
        System.out.println("Please enter first number");
        long a = getNumber();
        System.out.println("Please enter second number");
        long b = getNumber();
        System.out.printf("Greatest common divisor for numbers %d and %d is %d\n", a, b, computeGCD(a, b));
    }

    private static long getNumber() {
        while (true) {
            try {
                return new Scanner(System.in).nextLong();
            } catch (NoSuchElementException e) {
                System.out.println("Please enter number");
            }
        }
    }

    private static long computeGCD(long a, long b) {
        int x, y;
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }
}
