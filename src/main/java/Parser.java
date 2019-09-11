import java.util.Scanner;

public class Parser {
    protected String command;
    protected Scanner in;

    public Parser() {
        this.in = new Scanner(System.in);
    }

    public String[] readInput() {
        String input = in.nextLine().trim();
        return input.split(" ", 2);
    }
}