public class Event extends Task {

    private String start;
    private String end; //For later.

    public Event(String description, String start, int taskIndex) {
        super(description, taskIndex); //Using the Task constructor. isDone is set to false.
        this.start = start;
    }

    public String getStart() {
        return start;
    }

//    @Override
//    public void printTaskDetails() {
//        System.out.print(super.getStatusIcon() + " ");
//        System.out.print(super.getTaskIndex() + ". " + super.getDescription());
//        System.out.println("(at: " + this.start + ")");
//    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " (at: " + start + ")";
    }
}