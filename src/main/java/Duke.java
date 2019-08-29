import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Duke {
    private static Task[] tasklist = new Task[100];
    private static int listIndex = 1;

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

    private void addListItem(String item) {
        tasklist[listIndex] = new Task(item, listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
        System.out.println("Item added: " + item);
        setListIndex(listIndex + 1); //Increment the index
    }

    private static void addTodoItem(String item) throws InsufficientInfoException {
        try {
            String todoitem = item.substring(5);

            if (todoitem.length() == 0) {
                throw new InsufficientInfoException("Sorry, the description of a Todo cannot be blank!");
            } else {
                tasklist[listIndex] = new Todo(todoitem, listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
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
                tasklist[listIndex] = new Deadline(deadline[0], deadline[1], listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
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
                tasklist[listIndex] = new Event(event[0], event[1], listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
                System.out.println("Event item added: " + event[0]);
                System.out.println("Event happens at: " + event[1]);
                setListIndex(listIndex + 1); //Increment the index
            }
        }
    }

    private static void printList() {
        int max = listIndex;
        for (int i = 1; i < max; i++) { //index starts from 1.
            System.out.print(i + ". ");
            tasklist[i].printTaskDetails();
        }
    }

    private static void markTaskAsDone(int i) {
        System.out.print("Nice! I've marked this task as done: ");
        tasklist[i].markAsDone(); //Mark task as done.
        System.out.println(tasklist[i].getDescription()); //Prints task name
    }

    private static void handleListInput(String listInput) throws BadInputException, InsufficientInfoException {
        if (listInput.length() >= 4 && listInput.substring(0, 4).equals("list")) { //Both "list" and "list " will now be the right command.
            printList();
        } else if (listInput.length() >= 4 && listInput.substring(0, 4).equals("done")) { //Modified to include the space after done.
            String number = listInput.substring(5);
            markTaskAsDone(Integer.parseInt(number));
        } else if (listInput.length() >= 4 && listInput.substring(0, 4).equals("todo")) {

            addTodoItem(listInput);

        } else if (listInput.length() >= 8 && listInput.substring(0, 8).equals("deadline")) {

            addDeadlineItem(listInput);

        } else if (listInput.length() >= 5 && listInput.substring(0, 5).equals("event")) {

            addEventItem(listInput);

        } else {

            throw new BadInputException("Sorry, don't recognise that input!");
        }
    }
    
    private static Task[] readFileContents(String filePath) {
        Task[] savedList = new Task[100];  
        int i = 1; 
        File f = new File(filePath); // create a File for the given file path
        
        try {
            Scanner s = new Scanner(f); // create a Scanner using the File as the source
            while (s.hasNext()) {
                String itemRaw = s.nextLine();
                String[] item = itemRaw.split("/", 4);

                switch (item[0]) {
                    case "T":
                        savedList[i] = new Todo(item[2], i);

                        break;
                    case "D":
                        savedList[i] = new Deadline(item[2], item[3], i);

                        break;
                    case "E":
                        savedList[i] = new Event(item[2], item[3], i);

                        break;
                    default:
                        //throw an exception 
                        System.out.println("An exception will be thrown here eventually.");
                        break;
                }
                
                if (item[1].equals("1")) {
                    savedList[i].markAsDone(); 
                }
                
                i++; //Increment counter! 
            }
        } catch (FileNotFoundException e) {
            System.out.println("Save file not found. New list will be created instead.");
        }
        
        setListIndex(i); //Point to the next available task number; 
        
        return savedList; //Returns an array of Task objects 
    }

    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    private static void saveFileContents(String filePath) {
        StringBuilder tasksToSave = new StringBuilder();
        for (int i = 1; i < listIndex; i++) { //index starts from 1.
            tasksToSave.append(tasklist[i].saveDetailsString()).append(System.lineSeparator());
        }

        String taskListToSave = tasksToSave.toString();
        try {
            writeToFile(filePath, taskListToSave);
        } catch (IOException e) {
            System.out.println("Something went wrong saving the file :(");
        }
    }
    
    public static void main(String[] args) throws IOException {
        printIntro();

        tasklist = readFileContents("data/saved_tasks.txt");

        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        
        while (!userInput.equals("bye")) {
            printNewLine();

            try {
                handleListInput(userInput);
            } catch (BadInputException | InsufficientInfoException e) { //e is a string - the exception message
                System.out.println(e);
            }

            printNewLine();
            userInput = in.nextLine();
        }

        //userInput = in.nextLine();
        //Date hello = new Date(userInput);
        //hello.printFormattedDate();

        saveFileContents("data/saved_tasks.txt");
        printExitMessage();
    }
}
