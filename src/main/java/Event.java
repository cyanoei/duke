/**
 * In addition to the deadline and done status (inherited from Task),
 * the Event has a start time (and later, end time) that is represented by a date class.
 * The save and print strings have been overridden to show more information.
 */
public class Event extends Task {

    private String start;
    private String end; //For later.
    private Date eventTime;

    public Event(String description, String start, int taskIndex) {
        super(description, TaskType.EVENT); //Using the Task constructor. isDone is set to false.
        this.start = start;
        this.eventTime = new Date(start);
    }

    public String getStart() {
        return start;
    }

    public String getEventTime() {
        return eventTime.returnFormattedDate();
    }

    @Override
    public String saveDetailsString() {
        return "E/" + super.saveDetailsString() + "/" + start;
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " (at: " + eventTime.returnFormattedDate() + ")";
    }
}