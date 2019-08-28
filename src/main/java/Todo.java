public class Todo extends Task {

    //Is like the regular Task class

    public Todo(String description, int taskIndex) {
        super(description, taskIndex); //Using the Task constructor. isDone is set to false.
    }

    //PrintTaskDetails is the same

    //what does this do :/
//    @Override
//    public String toString() {
//        return "[D]" + super.toString() + " (by: " + doBy + ")";
//    }
}