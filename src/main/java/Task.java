/**
 * Represents a task.
 */
public class Task {
    /**
     * The description of the task.
     */
    protected String description;
    /**
     * Boolean to specify if the task has been accomplished or not.
     */
    protected boolean isDone;

    /**
     * Class constructor
     *
     * @param description The description fo the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Set the status of a task to done by setting isDone to true.
     */
    public void setStatus() {
        this.isDone = true;
    }

    /**
     * Formats the output for the data to be stored in the datafile.
     *
     * @return the status and the description of the task in the required format for the datafile.
     */
    public String fileFormat() {
        String status = "0";
        if (isDone) {
            status = "1";
        }
        return status + "|" + this.description;
    }

    /**
     * Formats the output to be printed on the command line when Duke is run.
     *
     * @return the status and the description of the task in the required format for the output on the command line.
     */
    @Override
    public String toString() {
        String status = "\u2718";
        if (isDone) {
            status = "\u2713";
        }
        return "[" + status + "] " + this.description;
    }
}