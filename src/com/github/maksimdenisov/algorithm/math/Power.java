package com.github.maksimdenisov.algorithm.math;

import static com.github.maksimdenisov.algorithm.math.Util.getDoubleNumber;
import static com.github.maksimdenisov.algorithm.math.Util.getNumber;

/**
 * The algorithm of rapid exponentiation.
 */
public class Power {

    public static void main(String[] args) {
        System.out.println("Computing the power of real number");
        System.out.println("Please enter base");
        double base = getDoubleNumber();
        System.out.println("Please enter index");
        long index = getNumber();
        System.out.printf("%f raised to the power of %d is %f\n", base, index, power(base, index));
    }

    public static double power(double base, long index) {
        long k = index;
        double b = base;
        double result = 1.0;
        while (k > 0) {
            if (k % 2 == 0) {
                k = k / 2;
                b *= b;
            } else {
                k = k - 1;
                result *= b;
            }
        }
        return result;
    }
}
