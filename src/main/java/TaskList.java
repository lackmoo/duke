import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> userList = new ArrayList<Task>();
    private static Storage database = new Storage("duke.txt");
    private static String sadFace = "\u2639";

    public TaskList() {
        this.userList = database.loadFile();
    }

    public void delete(int deleteIndex) throws DukeException {
        userList.remove(deleteIndex);
        database.editFile(userList);
    }

    public void done(int doneIndex) throws DukeException {
        if (doneIndex > userList.size()) {
            throw new DukeException("\t " + sadFace + "  OOPS!!! The task is non-existent, please input a valid task number.");
        }
        userList.get(doneIndex - 1).setStatus();
        database.editFile(userList);
    }

    public void find(ArrayList<Task> foundList, String findWord) {
        for (Task task : userList) {
            if (task.description.contains(findWord)) {
                foundList.add(task);
            }
        }
    }

    public void add(Task addedTask) {
        userList.add(addedTask);
        database.editFile(userList);
        Ui.printAddedMessage(addedTask, userList.size());
    }
}