public class Event extends Task {
    protected String dateTime;

    public Event(String description, String dateTime) {
        super(description);
        this.dateTime = dateTime;
    }

    @Override
    public String fileFormat() {
        return "E | " + super.fileFormat() + " | " + this.dateTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.dateTime + ")";
    }
}
