import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ui {
    private static String sadFace = "\u2639";

    public static void printLine() {
        String line = "\t____________________________________________________";
        System.out.println(line);
    }

    public static void initialize() {
        String logo = " \t____        _        \n"
                + "\t|  _ \\ _   _| | _____ \n"
                + "\t| | | | | | | |/ / _ \\\n"
                + "\t| |_| | |_| |   <  __/\n"
                + "\t|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("\tHello from\n" + logo);
        printLine();
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you? " + "\uD83D\uDE0A");
        printLine();
    }

    public static void printBye() {
        System.out.println("\tBye. Hope to see you again soon! " + "\uD83D\uDC4B");
        printLine();
    }

    public static void printAddedMessage(Task addedTask, int userListSize) {
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t   " + addedTask.toString());
        System.out.println(String.format("\t Now you have %d tasks in your list.", userListSize));
        printLine();
    }

    public static void printRemovedMessage(ArrayList<Task> overallList, int removedIndex) throws DukeException {
        if (removedIndex >= overallList.size()) {
            throw new DukeException("\t " + sadFace + "  OOPS!!! The task is non-existent, please input a valid task number.");
        }
        System.out.println("\t Got it. I've removed this task:");
        System.out.println("\t   " + overallList.get(removedIndex).toString());
        System.out.println(String.format("\t Now you have %d tasks in your list.", overallList.size() - 1));
        printLine();
    }

    public static void printMatchingTasks(ArrayList<Task> overallList) {
        if (overallList.isEmpty()) {
            System.out.println("\t " + sadFace + "  OOPS!!! There are no matching tasks.");
            printLine();
        } else {
            System.out.println("\t Here are the matching tasks in your list:");
            for (int i = 0; i < overallList.size(); i++) {
                System.out.println("\t " + (i + 1) + "." + overallList.get(i));
            }
            printLine();
        }
    }

    public static void printList(ArrayList<Task> list) {
        System.out.println("\t Here are the tasks in your list:");
        for (int i = 1; i <= list.size(); i++) {
            System.out.print("\t " + i + ".");
            System.out.println(list.get(i - 1).toString());
        }
    }

    public static void printStatus(ArrayList<Task> list, int doneIndex) {
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t " + list.get(doneIndex - 1).toString());
        //System.out.println("\t [" + this.getStatusIcon() + "] " + this.description);
    }

    public static void printNonExistentTask(String userCommand) {
        System.out.println(String.format("\t " + sadFace + "  OOPS!!! The description of %s cannot be empty.", userCommand));
    }

    public static void printIntegerError() {
        System.out.println("\t " + sadFace + "  OOPS!!! Please provide an integer value for the task number.");
    }

    public static void printDukeException(Exception e) {
        System.out.println(e.getMessage());
    }
}