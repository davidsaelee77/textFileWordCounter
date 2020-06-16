import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author David Saelee
 * @version
 *
 */
public class WordCountMain {
    /**
     * 
     * @param theArgs
     * @throws FileNotFoundException
     */
    public static void main(final String[] theArgs) throws FileNotFoundException {

        final Scanner input = new Scanner(System.in);
        intro(input);
        input.close();

    }

    /**
     * 
     * @throws FileNotFoundException
     */
    public static void intro(Scanner theConsole) throws FileNotFoundException {

        System.out.println("This program will analyze any text file book and output "
                           + "a list of the top repeated words.");

        System.out.println();
        invalidCheck(theConsole);
        repeat(theConsole);

    }

    public static void invalidCheck(Scanner theConsole) throws FileNotFoundException {

        System.out.println("Please enter the name of the text file followed by the .txt: ");

        final String textFileName = theConsole.next();
        String read = new String(textFileName);
        File textFileExist = new File(textFileName);

        if (textFileName.equalsIgnoreCase(read) && textFileExist.exists()) {

            try {
                final Scanner input = new Scanner(new File(textFileName));
                System.out.println("Please enter a number to generate the top N list.");
                final int number = theConsole.nextInt();

                new WordCount().run(input, number);
            }
            catch (InputMismatchException e) {
                Scanner in = new Scanner(System.in);
                System.err.println("You have entered an invalid response.  Please try again.");
                repeat(in);
                

            }

        }
        else {
            System.out.println("You have enteredd an invalid response.  Please try again.");
            repeat(theConsole);

        }

    }

    public static void repeat(final Scanner theConsole) throws FileNotFoundException {

        while (true) {

            System.out.println();

            System.out.println("Try another file?");

            System.out.println("Press Y for 'YES' and N for 'NO'.");

            final String response = theConsole.next();

            if ("Y".equalsIgnoreCase(response)) {

                invalidCheck(theConsole);

            }
            else if ("N".equalsIgnoreCase(response)) {

                System.out.println("You have quit the program.");

                break;

            }
            else {

                System.out.println("You have entered an invalid response.");
            }

        }

    }
}
