/*
 * TCSS 342 - WINTER
 */

package program;

import java.util.Scanner;

/**
 * Console based program that takes in a positive integer and produces its
 * binary equivalent as output.
 * 
 * @author David Saelee
 * @version 01/16/2019
 *
 */
public final class Main {
    /**
     * The invalid response message.
     */
    private static String invalid = "You have entered an invalid response.";

    /**
     * A private constructor to inhibit instantiation.
     */
    private Main() {

    }

    /**
     * Client code to run binary conversion program.
     * 
     * @param theArgs string array.
     */
    public static void main(final String[] theArgs) {

        final Scanner input = new Scanner(System.in);

        intro(input);
        input.close();
    }

    /**
     * Prompt user to enter positive integer.
     * 
     * @param theConsole scanner input.
     */
    public static void intro(final Scanner theConsole) {

        System.out.println("Please enter a positive integer "
                           + "number to be converted into a binary number. ");
        convertNumber(theConsole);
        repeat(theConsole);
    }

    /**
     * Prompts user for another number to convert.
     * 
     * @param theConsole scanner input
     */
    public static void repeat(final Scanner theConsole) {

        while (true) {

            System.out.println("Would you like to try another number?");

            System.out.println("Press Y for 'YES' and N for 'NO'.");

            final String response = theConsole.next();

            if ("Y".equalsIgnoreCase(response)) {

                convertNumber(theConsole);

            } else if ("N".equalsIgnoreCase(response)) {

                System.out.println("You have quit the program.");

                break;

            } else {

                System.out.println(invalid);
            }

        }

    }

    /**
     * Prompts user to enter positive integer to be converted.
     * 
     * @param theConsole scanner input.
     */
    public static void convertNumber(final Scanner theConsole) {

        System.out.println("Number: ");

        final String s = theConsole.next();

        try {

            final int num = Integer.parseInt(s);

            if (num >= 0) {

                System.out.println(StackUtilities.decimalToBinary(num));

            } else {

                System.out.println(invalid);

            }

        } catch (final NumberFormatException e) {

            System.out.println(invalid);

        }

    }

}
