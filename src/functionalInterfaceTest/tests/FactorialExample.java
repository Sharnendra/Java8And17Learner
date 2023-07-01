package functionalInterfaceTest.tests;

import java.util.function.IntFunction;

public class FactorialExample {

    public static void main(String[] args) {
        // Create a functional interface representing a function that takes an int and returns an int
        IntFunction<Integer> factorial = n -> {
            if (n == 0) {
                return 1; // Base case: factorial of 0 is 1
            } else {
                return n * factorial.apply(n - 1); // Recursive case
            }
        };

        // Calculate factorial using the functional interface
        int number = 5;
        int result = factorial.apply(number);
        System.out.println("Factorial of " + number + " is " + result);
    }
}

