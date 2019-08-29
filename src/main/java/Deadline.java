public class Deadline extends Task {

    private String doBy;

    public Deadline(String description, String by, int taskIndex) {
        super(description, taskIndex); //Using the Task constructor. isDone is set to false.
        this.doBy = by;
    }

    public String getDoBy() {
        return doBy;
    }

    @Override
    public String saveDetailsString() {
        return "D/" + super.saveDetailsString() + "/" + doBy;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + doBy + ")";
    }
}