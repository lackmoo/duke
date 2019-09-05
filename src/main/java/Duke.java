import java.util.ArrayList;

public class Duke {
    /**
     * Main class.
     *
     * @param args empty
     */
    public static void main(String[] args) {
        Ui.initialize();
        String[] userCommand;
        TaskList list = new TaskList();
        Parser parser = new Parser();
        String[] tokenizer;
        // Error messages for empty task description
        String sadFace = "\u2639";
        String taskEmpty1 = "\t " + sadFace + "  OOPS!!! The description of a ";
        String taskEmpty2 = " cannot be empty.";
        // Error messages for no deadline/event input
        String deadlineEmpty1 = "\t " + sadFace + "  OOPS!!! The ";
        String deadlineEmpty2 = " time details must be provided.";
        while (true) {
            userCommand = parser.readInput();
            if (!userCommand[0].equals("bye")) {
                Ui.printLine();
                try {
                    switch (userCommand[0]) {
                        case "done":
                            int doneIndex = Integer.parseInt(userCommand[1]);
                            list.done(doneIndex);
                            Ui.printStatus(list.userList, doneIndex);
                            Ui.printLine();
                            break;
                        case "list":
                            if (list.userList.size() == 0) {
                                throw new DukeException("\t " + sadFace + "  OOPS!!! The task list is currently empty.");
                            }
                            Ui.printList(list.userList);
                            Ui.printLine();
                            break;
                        case "todo":
                            Todo todoTask = new Todo(userCommand[1]);
                            list.add(todoTask);
                            break;
                        case "deadline":
                            tokenizer = userCommand[1].split(" /by ");
                            if (tokenizer.length < 2) {
                                throw new DukeException(deadlineEmpty1 + "deadline" + deadlineEmpty2);
                            }
                            list.add(new Deadline(tokenizer[0], tokenizer[1]));
                            break;
                        case "event":
                            tokenizer = userCommand[1].split(" /at ");
                            if (tokenizer.length < 2) {
                                throw new DukeException(deadlineEmpty1 + "event" + deadlineEmpty2);
                            }
                            list.add(new Event(tokenizer[0], tokenizer[1]));
                            break;
                        case "delete":
                            int removedIndex = Integer.parseInt(userCommand[1]) - 1;
                            Ui.printRemovedMessage(list.userList, removedIndex);
                            list.delete(removedIndex);
                            break;
                        case "find":
                            ArrayList<Task> foundList = new ArrayList<>();
                            list.find(foundList, userCommand[1]);
                            Ui.printMatchingTasks(foundList);
                            break;
                        default:
                            throw new DukeException("\t " + sadFace + "  OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                } catch (DukeException e) {
                    Ui.printDukeException(e);
                    Ui.printLine();
                } catch (IndexOutOfBoundsException e) {
                    Ui.printNonExistentTask(userCommand[0]);
                    Ui.printLine();
                } catch (NumberFormatException e) {
                    Ui.printIntegerError();
                    Ui.printLine();
                }
            }
            else {
                Ui.printLine();
                Ui.printBye();
                return;
            }
        }
    }
}