/**
 * The least detailed task is the todo,
 * which consists of a deadline and done status.
 * It is effectively the (parent) Task class with a different print and save string.
 */

public class Todo extends Task {

    // Do we even need this?
    public Todo(String description, int taskIndex) {
        super(description, TaskType.TODO); //Using the Task constructor. isDone is set to false.
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