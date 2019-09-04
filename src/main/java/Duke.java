import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static Storage storage;
    private static Parser parser;

    private static ArrayList<Task> tasklist = new ArrayList<>();

    //Consider not using the listIndex anymore?
    private static int listIndex = 0; //Starts from 0 now lol.

    private static void printIntro() {
        String logo = " ____        _        \n"
                    + "|  _ \\ _   _| | _____ \n"
                    + "| | | | | | | |/ / _ \\\n"
                    + "| |_| | |_| |   <  __/\n"
                    + "|____/ \\__,_|_|\\_\\___|\n";
        printNewLine();
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println("____________________________________________________________");
    }

    private static void printExitMessage() {
        printNewLine();
        System.out.println("Bye! Hope to see you again soon!");
        printNewLine();
    }

    private static void setListIndex(int value) {
        listIndex = value;
    }

    /*TODO Strip descriptions of leading/trailing spaces before submitting
        Accept multiple space delimiter to take the first word...?

    * */

    private static void addTodoItem(String item) throws InsufficientInfoException {
        try {
            String todoitem = item.substring(5);

            if (todoitem.length() == 0) {
                throw new InsufficientInfoException("Sorry, the description of a Todo cannot be blank!");
            } else {
                tasklist.add(new Todo(todoitem, listIndex)); //Use the constructor to create a new Task. Saved index starts from 1.
                System.out.println("Todo item added: " + todoitem);

                setListIndex(listIndex + 1); //Increment the index
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Sorry, the description of a Todo cannot be blank!");
        }
    }

    private static void addDeadlineItem(String item) throws InsufficientInfoException {
        if (item.length() < 9) { //Guarantees content
            throw new InsufficientInfoException("Sorry, the description of a Deadline cannot be blank!");
        } else {
            String deadline[] = item.substring(9).split("/by ");

            if (deadline[0].length() == 0) {
                throw new InsufficientInfoException("Sorry, the description of a Deadline cannot be blank!");
            } else if ((deadline.length < 2) || deadline[1].length() == 0) { //If the field is empty or does not exist
                throw new InsufficientInfoException("Sorry, the Deadline must have a date to be completed /by.");
            } else {
                tasklist.add(new Deadline(deadline[0], deadline[1], listIndex)); //Use the constructor to create a new Task. Saved index starts from 1.
                System.out.println("Deadline item added: " + deadline[0]);
                System.out.println("Deadline is: " + deadline[1]);

                setListIndex(listIndex + 1); //Increment the index
            }
        }
    }

    private static void addEventItem(String item) throws InsufficientInfoException {

        if (item.length() < 6) { //Guarantees content
            throw new InsufficientInfoException("Sorry, the description of an Event cannot be blank!");
        } else {
            String event[] = item.substring(6).split("/at ");

            if (event[0].length() == 0) {
                throw new InsufficientInfoException("Sorry, the description of an Event cannot be blank!");
            } else if ((event.length < 2) || event[1].length() == 0) {
                throw new InsufficientInfoException("Sorry, the event must have a timeframe it happens /at.");
            } else {
                tasklist.add(new Event(event[0], event[1], listIndex)); //Use the constructor to create a new Task. Saved index starts from 1.
                System.out.println("Event item added: " + event[0]);
                System.out.println("Event happens at: " + event[1]);
                setListIndex(listIndex + 1); //Increment the index
            }
        }
    }

    private static void printList() {
        int max = tasklist.size();
        if (max == 0) {
            System.out.println("The list is currently empty.");
            return;
        }

        for (int i = 0; i < max; i++) { //Index starts from 0.
            System.out.print(i+1 + ". "); //Add 1 to follow natural numbers.
            tasklist.get(i).printTaskDetails();
        }
    }

    private static void deleteTask(int i){
        try{
            Task item = tasklist.get(i);
            tasklist.remove(i); //The original copy is gone.

            System.out.print("Okay! I've deleted this task: ");
            System.out.println(item.getDescription());

            if (item.getIsDone()) {
                System.out.println("The task was completed.");
            } else {
                System.out.println("The task was not completed.");
            }
            listIndex--;

        } catch(IndexOutOfBoundsException e){
            printTaskNonexistent();
        }
    }

    private static void markTaskAsDone(int i) throws IndexOutOfBoundsException{

        try {
            tasklist.get(i).markAsDone(); //Mark task as done.
            System.out.print("Nice! I've marked this task as done: ");
            System.out.println(tasklist.get(i).getDescription()); //Prints task name
        } catch (IndexOutOfBoundsException e) {
            printTaskNonexistent();
        }
    }

    private static void printTaskNonexistent() {
        System.out.println("That task doesn't exist! Please check the available tasks again: ");
        printList();
    }

    private static void searchForTask(String search) {
        int max = tasklist.size();
        boolean found = false;

        for (int i = 0; i < max; i ++) {
            if (tasklist.get(i).getDescription().contains(search)) {
                System.out.print(i+1 + ". " ); //Print the index of the task.
                tasklist.get(i).printTaskDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Sorry, I could not find any tasks containing the description \"" + search + "\"." );
            System.out.println("Please try a different search string.");
        }
    }

    public static void main(String[] args) throws IOException {
        printIntro();

        String saveFile = "/Users/rebecca/Documents/NUS/CS2113T/Project/duke/data/saved_tasks.txt";

        //Read in saved file.
        storage = new Storage(saveFile);
        tasklist = Storage.readFileContents();

        //Start parsing user input.
        Scanner in = new Scanner(System.in);
        parser = new Parser(in);

        String[] command;

        //Should probably wrap this in the UI class.
        do {
            command = parser.parse();

        } while (!command[0].equals("bye"));

        //

        //Save tasklist.
        storage.saveFileContents(tasklist);


        printExitMessage();
    }
}
