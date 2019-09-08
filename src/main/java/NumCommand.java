public class NumCommand extends Command {

    private int itemIndex;

    public NumCommand(CommandType type, int index) {
        super(type);
        this.itemIndex = index;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    @Override
    public void execute(TaskList list, Ui ui) {


    }
}
