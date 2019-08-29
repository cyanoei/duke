public class Todo extends Task {

    // Do we even need this?
    public Todo(String description, int taskIndex) {
        super(description, taskIndex); //Using the Task constructor. isDone is set to false.
    }

    @Override
    public String saveDetailsString() {
        return "T/" + super.saveDetailsString();
    }

    @Override
    public String toString() {
        return "[T] " + super.toString();
    }
}