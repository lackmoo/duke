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

    public static void printRemovedMessage(int index) {
        Task removedTask = list.remove(index);
        System.out.println("\t Got it. I've removed this task:");
        System.out.println("\t   " + removedTask);
        System.out.println(String.format("\t Now you have %d tasks in your list.", list.size()));
        printLine();
    }

    public static void printMatchingTasks(String userTask) {
        ArrayList<Task> overallList = new ArrayList<>();
        for (Task task : list) {
            if (task.description.contains(userTask)) {
                overallList.add(task);
            }
        }
        if (overallList.isEmpty()) {
            System.out.println("\t OOPS!!! There are no matching tasks.");
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
     * Main class.
     *
     * @param args empty
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        list = database.loadFile();
        Ui.initialize();
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
                        String doneIndex = scanner.nextLine().trim();
                        if (doneIndex.length() == 0) {
                            throw new DukeException("\t " + sadFace + "  OOPS!!! Please input a task number to be marked done.");
                        }
                        int addIndex = Integer.parseInt(doneIndex);
                        //int addIndex = scanner.nextInt();
                        list.get(addIndex - 1).setStatus();
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
                        //list.add(new Todo(userTask));
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
                    case "delete":
                        String deleteIndex = scanner.nextLine().trim();
                        if (deleteIndex.length() == 0) {
                            throw new DukeException("\t " + sadFace + "  OOPS!!! Please input a task number to be deleted.");
                        }
                        int removedIndex = Integer.parseInt(deleteIndex) - 1;
                        printRemovedMessage(removedIndex);
                        if (removedIndex > list.size()) {
                            throw new DukeException("\t " + sadFace + "  OOPS!!! The task is non-existent, please input a valid task number.");
                        }
                        break;
                    case "find":
                        userTask = scanner.nextLine().trim();
                        if (userTask.length() == 0) {
                            throw new DukeException(taskEmpty1 + input + taskEmpty2);
                        }
                        printMatchingTasks(userTask);
                        break;
                    default:
                        throw new DukeException("\t " + sadFace + "  OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
                printLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\t " + sadFace + "  OOPS!!! The task is non-existent, please input a valid task number.");
                printLine();
            } catch (NumberFormatException e) {
                System.out.println("\t " + sadFace + "  OOPS!!! Number Format Exception: Please provide an integer value for the task number.");
                printLine();
            }
            database.editFile(list);
            input = scanner.next();
        }
        printLine();
        Ui.printBye();
    }
}