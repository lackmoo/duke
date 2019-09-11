/**
 * Represents a to-do task.
 */
public class Todo extends Task {
    /**
     * Class constructor.
     *
     * @param description the description of the to-do task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Formats the output for the data to be stored in the datafile.
     *
     * @return the status and the description of the to-do task in the required format for the datafile.
     */
    @Override
    public String fileFormat() {
        return "T|" + super.fileFormat();
    }

    /**
     * Formats the output to be printed on the command line when Duke is run.
     *
     * @return the status and the description of the to-do task in the required format for the output on the command line.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
