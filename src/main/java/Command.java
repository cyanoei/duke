public class Command {
    private enum commandType {
        TODO, DEADLINE, EVENT, BYE, LIST, DONE, DELETE, FIND
    }

    private int type; //Todo: decide what types/numbers OR learn enums lol
    private String description;
}
