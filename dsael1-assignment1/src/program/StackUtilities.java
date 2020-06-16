/*
 * TCSS 342 - WINTER
 */

package program;

import structures.ArrayStack;

/**
 * Console based program that takes in a positive integer and produces its
 * binary equivalent as output.
 * 
 * @author David Saelee
 * @version 01/16/2019
 *
 */
public final class StackUtilities {
    /**
     * Binary constant for division & modulus operations.
     */
    public static final int BINARY_CONSTANT = 2;

    /**
     * A private constructor to inhibit instantiation.
     */
    private StackUtilities() {

    }

    /**
     * Converts positive integer to binary number.
     * 
     * @param theNumber positive integer.
     * @return string of binary numbers.
     */
    public static String decimalToBinary(final int theNumber) {

        int num = theNumber;

        final ArrayStack<Integer> binaryStack = new ArrayStack<Integer>();

        final StringBuilder binaryNumber = new StringBuilder("Binary Number: ");

        do {

            final int remainder = num % BINARY_CONSTANT;
            num = num / BINARY_CONSTANT;
            binaryStack.push(remainder);

        } while (num > 0);

        while (!binaryStack.isEmpty()) {

            binaryNumber.append(binaryStack.pop());

        }

        return binaryNumber.toString();

    }

}
