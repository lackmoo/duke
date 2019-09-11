import java.util.Arrays;
import java.util.List;

/**
 * Represents an event.
 */
public class Event extends Task {
    /**
     * Represents the start time of an event.
     */
    protected DatesTimes startTime;
    /**
     * Represents the end time of an event.
     */
    protected DatesTimes endTime;

    /**
     * Class constructor.
     *
     * @param description the description of the event.
     * @param dateTime the start and end date and time information of the event.
     * @throws DukeException if the datetime format and values are invalid.
     */
    public Event(String description, String dateTime) throws DukeException {
        super(description);
        String[] date = dateTime.split(" - ");
        List<String> dates = Arrays.asList(date);
        this.startTime = new DatesTimes(dates.get(0));
        this.endTime = new DatesTimes(dates.get(1));
    }

    /**
     * Formats the output for the data to be stored in the datafile.
     *
     * @return the status and the description of the event in the required format for the datafile.
     */
    @Override
    public String fileFormat() {
        return "E|" + super.fileFormat() + "|" + this.startTime + " - " + this.endTime;
    }

    /**
     * Formats the output to be printed on the command line when Duke is run.
     *
     * @return the status and the description of the event in the required format for the output on the command line.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.startTime + " - " + this.endTime + ")";
    }
}
