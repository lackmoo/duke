import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void printLine() {
        String line = "\t____________________________________________________";
        System.out.println(line);
    }

    /**
     * Main class.
     *
     * @param args empty
     */
    public static void main(String[] args) {
        String logo = " \t____        _        \n"
                + "\t|  _ \\ _   _| | _____ \n"
                + "\t| | | | | | | |/ / _ \\\n"
                + "\t| |_| | |_| |   <  __/\n"
                + "\t|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("\tHello from\n" + logo);
        printLine();
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        printLine();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        String input = scanner.next();

        while (!input.equals("bye")) {
            if (input.equals("done")) {
                printLine();
                int index = scanner.nextInt();
                list.get(index - 1).setStatus();
                printLine();
            } else if (input.equals("list")) {
                printLine();
                System.out.println("\tHere are the tasks in your list:");
                for (int i = 1; i <= list.size(); i++) {
                    System.out.print("\t" + i + ".");
                    System.out.println("[" + list.get(i - 1).getStatusIcon() + "] " + list.get(i - 1).description);
                }
                printLine();
            } else {
                input = input + scanner.nextLine();
                Task t = new Task(input);
                list.add(t);
                printLine();
                System.out.println("\tadded: " + input);
                printLine();
            }
            input = scanner.next();
        }
        printLine();
        System.out.println("\tBye. Hope to see you again soon!");
        printLine();
    }
}