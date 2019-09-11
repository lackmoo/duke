import java.util.ArrayList;

public class Duke {
    /*private TaskList list;
    private Storage database;


    public Duke(String filename) {
        ui = new Ui();
        database = new Storage(filename);
        try {
            list = new TaskList(database.loadFile());
        } catch (DukeException e){
            Ui.printDukeException(e);
        }
    }*/
    /**
     * Main class.
     *
     * @param args empty
     */
    public static void main(String[] args) {
        //list = database.loadFile();
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

    /*public static void main(String[] args) {
        new Duke("duke.txt").run();
    }*/


    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        list = database.loadFile();
        ui.initialize();
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
            ui.printLine();
            try {
                switch (input) {
                    case "done":
                        String doneIndex = scanner.nextLine().trim();
                        if (doneIndex.length() == 0) {
                            throw new DukeException("\t " + sadFace + "  OOPS!!! Please input a task number to be marked done.");
                        }
                        int addIndex = Integer.parseInt(doneIndex);
                        list.get(addIndex - 1).setStatus();
                        ui.printStatus(list, addIndex);
                        ui.printLine();
                        break;
                    case "list":
                        if (list.size() == 0) {
                            throw new DukeException("\t " + sadFace + "  OOPS!!! The task list is currently empty.");
                        }
                        ui.printList(list);
                        ui.printLine();
                        break;
                    case "todo":
                        userTask = scanner.nextLine().trim();
                        if (userTask.length() == 0) {
                            throw new DukeException(taskEmpty1 + input + taskEmpty2);
                        }
                        list.add(new Todo(userTask));
                        Ui.printAddedMessage(new Todo(userTask), list.size());
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
                        list.add(new Deadline(tokenizer[0], tokenizer[1]));
                        Ui.printAddedMessage(new Deadline(tokenizer[0], tokenizer[1]), list.size());
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
                        list.add(new Event(tokenizer[0], tokenizer[1]));
                        Ui.printAddedMessage(new Event(tokenizer[0], tokenizer[1]), list.size());
                        break;
                    case "delete":
                        String deleteIndex = scanner.nextLine().trim();
                        if (deleteIndex.length() == 0) {
                            throw new DukeException("\t " + sadFace + "  OOPS!!! Please input a task number to be deleted.");
                        }
                        int removedIndex = Integer.parseInt(deleteIndex) - 1;
                        Task removedTask = list.remove(removedIndex);
                        Ui.printRemovedMessage(removedTask, list.size());
                        if (removedIndex > list.size()) {
                            throw new DukeException("\t " + sadFace + "  OOPS!!! The task is non-existent, please input a valid task number.");
                        }
                        break;
                    case "find":
                        ArrayList<Task> overallList = new ArrayList<>();
                        userTask = scanner.nextLine().trim();
                        if (userTask.length() == 0) {
                            throw new DukeException(taskEmpty1 + input + taskEmpty2);
                        }
                        for (Task task : list) {
                            if (task.description.contains(userTask)) {
                                overallList.add(task);
                            }
                        }
                        Ui.printMatchingTasks(overallList);
                        break;
                    default:
                        throw new DukeException("\t " + sadFace + "  OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                Ui.printDukeException(e);
                Ui.printLine();
            } catch (IndexOutOfBoundsException e) {
                Ui.printNonExistentTask();
                Ui.printLine();
            } catch (NumberFormatException e) {
                Ui.printIntegerError();
                Ui.printLine();
            }
            database.editFile(list);
            input = scanner.next();
        }
        Ui.printLine();
        Ui.printBye();
    }
}*/