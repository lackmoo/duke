import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> list = new ArrayList<>();
    private static Storage database = new Storage("duke.txt");

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
        Scanner scanner = new Scanner(System.in);
        list = database.loadFile();
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

        String input = scanner.next();
        String[] tokenizer;
        String userTask;
        // Error messages for empty task description
        String sadFace = "\u2639";
        String taskEmpty1 = "\t " + sadFace + "  OOPS!!! The description of a ";
        String taskEmpty2 = " cannot be empty.";
        // Error messages for no deadline/event input
        String deadlineEmpty1 = "\t " + sadFace + "  OOPS!!! The ";
        String deadlineEmpty2 = " time details must be provided.";
        while (!input.equals("bye")) {
            printLine();
            try {
                switch (input) {
                    case "done":
                        int index = scanner.nextInt();
                        list.get(index - 1).setStatus();
                        printLine();
                        break;
                    case "list":
                        System.out.println("\t Here are the tasks in your list:");
                        if (list.size() == 0) {
                            throw new DukeException("\t " + sadFace + "  OOPS!!! The task list is currently empty.");
                        }
                        for (int i = 1; i <= list.size(); i++) {
                            System.out.print("\t " + i + ".");
                            System.out.println(list.get(i - 1).toString());
                        }
                        printLine();
                        break;
                    case "todo":
                        userTask = scanner.nextLine().trim();
                        if (userTask.length() == 0) {
                            throw new DukeException(taskEmpty1 + input + taskEmpty2);
                        }
                        printAddedMessage(new Todo(userTask));
                        break;
                    case "deadline":
                        userTask = scanner.nextLine().trim();
                        if (userTask.length() == 0) {
                            throw new DukeException(taskEmpty1 + input + taskEmpty2);
                        }
                        tokenizer = userTask.split(" /by ");
                        if (tokenizer.length < 2) {
                            throw new DukeException(deadlineEmpty1 + input + deadlineEmpty2);
                        }
                        printAddedMessage(new Deadline(tokenizer[0], tokenizer[1]));
                        break;
                    case "event":
                        userTask = scanner.nextLine().trim();
                        if (userTask.length() == 0) {
                            throw new DukeException(taskEmpty1 + input + taskEmpty2);
                        }
                        tokenizer = userTask.split(" /at ");
                        if (tokenizer.length < 2) {
                            throw new DukeException(deadlineEmpty1 + input + deadlineEmpty2);
                        }
                        printAddedMessage(new Event(tokenizer[0], tokenizer[1]));
                        break;
                    default:
                        throw new DukeException("\t " + sadFace + "  OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
                printLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\t " + sadFace + "  OOPS!!! The task is non-existent, please input a valid task number.");
            }
            database.editFile(list);
            input = scanner.next();
        }
        printLine();
        System.out.println("\tBye. Hope to see you again soon!");
        printLine();
    }
}