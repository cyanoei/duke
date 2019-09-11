/**
 * Command objects for marking tasks as done, or deleting them.
 * Requires the index of the task.
 */
public class NumCommand extends Command {

    private int itemIndex;

    public NumCommand(CommandType type, int index) {
        super(type);
        this.itemIndex = index-1; //Because of 0-indexing
    }

    public int getItemIndex() {
        return itemIndex;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        if (type == CommandType.DONE) {
            list.markTaskAsDone(itemIndex);
        } else if (type == CommandType.DELETE) {
            list.deleteTask(itemIndex);
        }

    }
}
