/**
 * Command objects for adding Todos, Events, and Deadlines.
 */

public class AddCommand extends Command {

    public String details;

    public AddCommand(CommandType type, String description, String details) {

        super(type, description); //is only 1 of 3 types
        this.details = details;
    }

    @Override
    public void execute(TaskList list, Ui ui) {

    }



}
