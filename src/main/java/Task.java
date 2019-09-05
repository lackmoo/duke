public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void setStatus() {
        this.isDone = true;
    }

    public void setDone() {
        this.isDone = true;
    }

    public String fileFormat() {
        String status = "0";
        if (isDone) {
            status = "1";
        }
        return status + "|" + this.description;
    }

    @Override
    public String toString() {
        String status = "\u2718";
        if (isDone) {
            status = "\u2713";
        }
        return "[" + status + "] " + this.description;
    }
}