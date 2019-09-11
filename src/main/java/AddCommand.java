/**
 * Command objects for adding Todos, Events, and Deadlines.
 */
public class AddCommand extends Command {

    public String description;
    public String details;

    public AddCommand(CommandType type, String description, String details) {
        super(type);
        this.description = description;
        this.details = details;
    }


    @Override
    public void execute(TaskList list, Ui ui, Storage storage)  {
        if (super.type == CommandType.TODO) {
            list.addTodoItem(description);
        } else if (super.type == CommandType.DEADLINE) {
            list.addDeadlineItem(description, details);
        } else if (super.type == CommandType.EVENT) { //
            list.addEventItem(description, details);
        } else {
            System.out.println("Type error."); //should handle an error here?
        }
    }



}
