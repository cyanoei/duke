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

    private Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        taskList = new TaskList(storage.readFileContents()); //Will always return the right object even if empty.
    }

    private void run() {
        ui.printIntro();

        //Start parsing user input.
        Scanner in = new Scanner(System.in);
        parser = new Parser(in);

        String[] command;

        //Should probably wrap this in the UI class.
        do {
            ui.printNewLine();
            command = parser.parse();
            //ui.printNewLine();
            taskList.handleListInput(command); //Should only be passed good inputs.
        } while (!command[0].equals("bye"));

        //Save tasklist.
        storage.saveFileContents(taskList.getTaskList());

        ui.printExitMessage();
    }

    public static void main(String[] args) {
        String saveFile = "/Users/rebecca/Documents/NUS/CS2113T/Project/duke/data/saved_tasks.txt";
        new Duke(saveFile).run();
    }
}
