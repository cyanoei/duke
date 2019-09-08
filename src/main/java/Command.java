/**
 * This is an abstract class.
 * Command objects are sent from the Parser and executed with TaskList or Ui.
 * Commands include: adding, deleting, marking as done etc.
 */

public class Command {

    protected enum CommandType {
        TODO, DEADLINE, EVENT, BYE, LIST, DONE, DELETE, FIND
    }

    private CommandType type;
    private String description;

    public Command(CommandType type, String description) {
        this.type = type;
        this.description = description;
    }

    public void execute(TaskList list, Ui ui) { //Abstract method
        //Abstract method
    }
}
