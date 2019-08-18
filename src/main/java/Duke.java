import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke. What can I do for you?");
        System.out.println("________________________________________");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("bye")) {
            System.out.println("________________________________________");
            System.out.println(input);
            System.out.println("________________________________________");
            input = scanner.nextLine();
        }
        System.out.println("________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("________________________________________");
    }
}
