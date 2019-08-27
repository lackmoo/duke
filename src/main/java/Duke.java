import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> list = new ArrayList<>();

    public static void printLine() {
        String line = "\t____________________________________________________";
        System.out.println(line);
    }

    public static void printAddedMessage(Task t) {
        list.add(t);
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t   " + t);
        System.out.println(String.format("\t Now you have %d tasks in your list.", list.size()));
        printLine();
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
        String input = scanner.next();
        String[] tokenizer;
        String userTask;
        while (!input.equals("bye")) {
            printLine();
            switch (input) {
                case "done":
                    int index = scanner.nextInt();
                    list.get(index - 1).setStatus();
                    printLine();
                    break;
                case "list":
                    System.out.println("\t Here are the tasks in your list:");
                    for (int i = 1; i <= list.size(); i++) {
                        System.out.print("\t " + i + ".");
                        System.out.println(list.get(i - 1).toString());
                    }
                    printLine();
                    break;
                case "todo":
                    userTask = scanner.nextLine().trim();
                    printAddedMessage(new Todo(userTask));
                    break;
                case "deadline":
                    userTask = scanner.nextLine().trim();
                    tokenizer = userTask.split(" /by ");
                    printAddedMessage(new Deadline(tokenizer[0], tokenizer[1]));
                    break;
                case "event":
                    userTask = scanner.nextLine().trim();
                    tokenizer = userTask.split(" /at ");
                    printAddedMessage(new Event(tokenizer[0], tokenizer[1]));
                    break;
            }
            input = scanner.next();
        }
        printLine();
        System.out.println("\tBye. Hope to see you again soon!");
        printLine();
    }
}