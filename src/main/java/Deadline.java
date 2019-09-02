import java.util.Date;

public class Deadline extends Task {
    protected DatesTimes by;

    public Deadline(String description, String dateTime) throws DukeException {
        super(description);
        by = new DatesTimes(dateTime);
    }

    @Override
    public String fileFormat() {
        return "D|" + super.fileFormat() + "|" + this.by.toString();
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by.toString() + ")";
    }
}

