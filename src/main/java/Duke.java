import java.io.IOException;
import java.util.Scanner;

public class Duke {
    private static Storage storage;
    private static Parser parser;
    private static TaskList taskList;
    private static Ui ui;

    //Consider not using the listIndex anymore?
    private static int listIndex = 0; //Starts from 0 now lol.

    private static void setListIndex(int value) {
        listIndex = value;
    }

    /*TODO Strip descriptions of leading/trailing spaces before submitting
        Accept multiple space delimiter to take the first word...?
    * */


    public static void main(String[] args) {
        ui = new Ui();
        ui.printIntro();

        String saveFile = "/Users/rebecca/Documents/NUS/CS2113T/Project/duke/data/saved_tasks.txt";

        //Read in saved file.
        storage = new Storage(saveFile);
        taskList = new TaskList(Storage.readFileContents()); //Will always return the right object even if empty.

        //Start parsing user input.
        Scanner in = new Scanner(System.in);
        parser = new Parser(in);

        String[] command;

        //Should probably wrap this in the UI class.
        do {
            ui.printNewLine();
            command = parser.parse();
            ui.printNewLine();
            taskList.handleListInput(command); //Should only be passed good inputs.
        } while (!command[0].equals("bye"));

        //Save tasklist.
        storage.saveFileContents(taskList.getTaskList());

        ui.printExitMessage();
    }
}
