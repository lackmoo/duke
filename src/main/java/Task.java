public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols

    }

    public void printStatus() {
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t [" + this.getStatusIcon() + "] " + this.description);
    }

    public void setStatus() {
        this.isDone = true;
        printStatus();
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