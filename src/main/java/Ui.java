import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Prints messages to the command line interface.
 */
public class Ui {
    /**
     * Representation of a sadface emoji in unicode.
     */
    private static String sadFace = "\u2639";

    /**
     * Prints a horizontal line.
     */
    public static void printLine() {
        String line = "\t____________________________________________________";
        System.out.println(line);
    }

    /**
     * Printed to the main screen a welcome message when the user first opens the program.
     */
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

    /**
     * Prints a goodbye message on the screen when the user wishes to terminate the program.
     */
    public static void printBye() {
        System.out.println("\tBye. Hope to see you again soon! " + "\uD83D\uDC4B");
        printLine();
    }

    /**
     * Prints a message to inform the user that a task has been registered and added to the database of tasks.
     *
     * @param addedTask The task to be added as specified by the user.
     * @param userListSize The size of the current list containing all the tasks.
     */
    public static void printAddedMessage(Task addedTask, int userListSize) {
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t   " + addedTask.toString());
        System.out.println(String.format("\t Now you have %d tasks in your list.", userListSize));
        printLine();
    }

    /**
     * Prints a message to inform the user that a task has been removed.
     *
     * @param overallList The overall list containing all the tasks in the database.
     * @param removedIndex The index of the task that the user wishes to remove.
     * @throws DukeException if the task number that the user enters is non-existent.
     */
    public static void printRemovedMessage(ArrayList<Task> overallList, int removedIndex) throws DukeException {
        if (removedIndex >= overallList.size()) {
            throw new DukeException("\t " + sadFace + "  OOPS!!! The task is non-existent, please input a valid task number.");
        }
        System.out.println("\t Got it. I've removed this task:");
        System.out.println("\t   " + overallList.get(removedIndex).toString());
        System.out.println(String.format("\t Now you have %d tasks in your list.", overallList.size() - 1));
        printLine();
    }

    /**
     * prints the tasks that match the keyword that the user specifies.
     *
     * @param overallList The overall list containing all the tasks in the database.
     */
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

    /**
     * Prints the current overall list.
     *
     * @param overallList the overall list containing all the tasks in the database.
     */
    public static void printList(ArrayList<Task> overallList) {
        System.out.println("\t Here are the tasks in your list:");
        for (int i = 1; i <= overallList.size(); i++) {
            System.out.print("\t " + i + ".");
            System.out.println(overallList.get(i - 1).toString());
        }
    }

    /**
     * Prints the message to inform the user that the specified task has been marked as done.
     *
     * @param overallList the overall list containing all the tasks in the database.
     * @param doneIndex the index of the task which the user wishes to specify as done.
     */
    public static void printStatus(ArrayList<Task> overallList, int doneIndex) {
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t " + overallList.get(doneIndex - 1).toString());
    }

    /**
     * Prints the error message that the description of a task cannot be empty.
     *
     * @param userCommand The type of task that the user specified.
     */
    public static void printNonExistentTask(String userCommand) {
        System.out.println(String.format("\t " + sadFace + "  OOPS!!! The description of %s cannot be empty.", userCommand));
    }

    /**
     * Prints the error message that the task number provided must be an integer.
     */
    public static void printIntegerError() {
        System.out.println("\t " + sadFace + "  OOPS!!! Please provide an integer value for the task number.");
    }

    /**
     * Prints the error message captured by the exception.
     *
     * @param e the exception captured.
     */
    public static void printDukeException(Exception e) {
        System.out.println(e.getMessage());
    }
}