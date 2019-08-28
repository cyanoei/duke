public class Task {
    private String description;
    private int taskIndex;
    private boolean isDone;


    public Task() {
        this.description = "None";
        this.isDone = false;
    }

    public Task(String description, int taskIndex) {
        this.description = description;
        this.taskIndex = taskIndex;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatusIcon() {
        return (isDone ? "[\u2713]" : "[\u2718]"); //return tick or X symbols
    }

    public int getTaskIndex() {
        return this.taskIndex;
    }

    public void printTaskDetails() {
        System.out.println(toString());
    }

    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + description; //eg. [✓] read book
    }
}