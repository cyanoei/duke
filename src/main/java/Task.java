import java.text.SimpleDateFormat;

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

    public boolean getIsDone() {
        return isDone;
    }

    public void printTaskDetails() {
        System.out.println(toString());
    }

    public String saveDetailsString() {
        String done;
        if (this.isDone) done = "1";
        else done = "0";

        return done + "/" + description;
        //Returns string in the style of "1/read book"
    }

    public void markAsDone() {
        this.isDone = true;
    }

//    public void readDateTime(String dateAndTime) {
//        String pattern = "dd/MM/yyyy HHmm";
//        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//        String formatted = formatter.format(dateAndTime);
//        System.out.println(formatted);
//    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + description; //eg. [✓] read book
    }
}