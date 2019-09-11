import java.util.Scanner;

/**
 * Process the user input.
 */
public class Parser {
    /**
     * Scanner to scan for the user input.
     */
    protected Scanner in;

    /**
     * Class constructor.
     *
     * Stores the scanned user input.
     */
    public Parser() {
        this.in = new Scanner(System.in);
    }

    /**
     * Reads the user input and make sense of it.
     * @return the split user input with the delimiter " ".
     */
    public String[] readInput() {
        String input = in.nextLine().trim();
        return input.split(" ", 2);
    }
}
