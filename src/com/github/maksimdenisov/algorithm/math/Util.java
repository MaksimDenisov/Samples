package com.github.maksimdenisov.algorithm.math;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Util {
    public static long getNumber() {
        while (true) {
            try {
                return new Scanner(System.in).nextLong();
            } catch (NoSuchElementException e) {
                System.out.println("Please enter number");
            }
        }
    }
}
