
import java.util.Date;

/**
 * Represents a deadline.
 */
public class Deadline extends Task {
    /**
     * Represents the date and time information of the deadline.
     */
    protected DatesTimes by;

    /**
     * Class constructor.
     *
     * @param description the description of the deadline.
     * @param dateTime the date and time details of the deadline.
     * @throws DukeException if the datetime format and values are invalid.
     */
    public Deadline(String description, String dateTime) throws DukeException {
        super(description);
        by = new DatesTimes(dateTime);
    }

    /**
     * Formats the output for the data to be stored in the datafile.
     *
     * @return the status and the description of the deadline in the required format for the datafile.
     */
    @Override
    public String fileFormat() {
        return "D|" + super.fileFormat() + "|" + this.by.toString();
    }

    /**
     * Formats the output to be printed on the command line when Duke is run.
     *
     * @return the status and the description of the deadline in the required format for the output on the command line.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by.toString() + ")";
    }
}