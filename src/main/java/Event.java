import java.util.Arrays;
import java.util.List;

public class Event extends Task {
    protected DatesTimes startTime;
    protected DatesTimes endTime;

    public Event(String description, String dateTime) throws DukeException {
        super(description);
        String[] date = dateTime.split(" - ");
        List<String> dates = Arrays.asList(date);
        this.startTime = new DatesTimes(dates.get(0));
        this.endTime = new DatesTimes(dates.get(1));


    }

    @Override
    public String fileFormat() {
        return "E|" + super.fileFormat() + "|" + this.startTime + " - " + this.endTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.startTime + " - " + this.endTime + ")";
    }
}