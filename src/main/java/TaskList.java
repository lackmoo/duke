import java.util.ArrayList;

/**
 * Represents a list of tasks/todos/events/deadlines in the overall list.
 */
public class TaskList {
    /**
     * The overall list of tasks to be done.
     */
    protected ArrayList<Task> userList = new ArrayList<Task>();
    /**
     * The database file containing the last stored user input data.
     */
    private static Storage database = new Storage("duke.txt");
    /**
     * Representation of a sadface emoji in unicode.
     */
    private static String sadFace = "\u2639";

    /**
     * Class constructor.
     *
     * Loads the database file containing the last stored user input data.
     */
    public TaskList() {
        this.userList = database.loadFile();
    }

    /**
     * To remove a task as specified by the user.
     *
     * @param deleteIndex The index of the task to be removed.
     */
    public void delete(int deleteIndex) {
        userList.remove(deleteIndex);
        database.editFile(userList);
    }

    /**
     * To mark a task that is specified by the user as done.
     *
     * @param doneIndex The index of the task to be marked as done.
     * @throws DukeException if the index of the task provided exceeds/is less than the total number of tasks available.
     */
    public void done(int doneIndex) throws DukeException {
        if (doneIndex > userList.size()) {
            throw new DukeException("\t " + sadFace + "  OOPS!!! The task is non-existent, please input a valid task number.");
        }
        userList.get(doneIndex - 1).setStatus();
        database.editFile(userList);
    }

    /**
     * Find the tasks that match the keyword as specified by the user.
     *
     * @param foundList The list that contains the tasks that match the keyword as specified by the user.
     * @param findWord The word that the user wishes to find in the overall list.
     */
    public void find(ArrayList<Task> foundList, String findWord) {
        for (Task task : userList) {
            if (task.description.contains(findWord)) {
                foundList.add(task);
            }
        }
    }

    /**
     * Adds a new task to the overall list.
     *
     * @param addedTask The task to be added into the overall list.
     */
    public void add(Task addedTask) {
        userList.add(addedTask);
        database.editFile(userList);
        Ui.printAddedMessage(addedTask, userList.size());
    }
}