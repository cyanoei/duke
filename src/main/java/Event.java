public class Event extends Task {

    private String start;
    private String end;

    public Event(String description, String start, int taskIndex) {
        super(description, taskIndex); //Using the Task constructor. isDone is set to false.
        this.start = start;
    }

    public String getStart() {
        return start;
    }

    @Override
    public void printTaskDetails() {
        System.out.print(super.getStatusIcon() + " ");
        System.out.print(super.getTaskIndex() + ". " + super.getDescription());
        System.out.println("(" + this.start + ")");
    }

    //what does this do :/
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + start + ")";
    }
}