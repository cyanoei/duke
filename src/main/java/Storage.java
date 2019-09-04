import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    //Write and read functions

    public static ArrayList<Task> readFileContents(String filePath) {
        ArrayList<Task> savedList = new ArrayList<>();
        //Task[] savedList = new Task[100];

        int i = 0;
        File f = new File(filePath); // create a File for the given file path

        try {
            Scanner s = new Scanner(f); // create a Scanner using the File as the source
            while (s.hasNext()) {
                String itemRaw = s.nextLine();
                String[] item = itemRaw.split("/", 4);

                switch (item[0]) {
                    case "T":
                        savedList.add(new Todo(item[2], i));

                        break;
                    case "D":
                        savedList.add(new Deadline(item[2], item[3], i));

                        break;
                    case "E":
                        savedList.add(new Event(item[2], item[3], i));

                        break;
                    default:
                        //throw an exception
                        System.out.println("An exception will be thrown here eventually.");
                        break;
                }

                if (item[1].equals("1")) {
                    savedList.get(i).markAsDone();  //ArrayList indexing starts from 0.
                }

                i++; //Increment counter!
            }
        } catch (FileNotFoundException e) {
            System.out.println("Save file not found. New list will be created instead.");
        }

        //setListIndex(i); //Should not require anymore.

        return savedList; //Returns an array of Task objects
    }

    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    public static void saveFileContents(ArrayList<Task> taskList, String filePath) {
        StringBuilder tasksToSave = new StringBuilder();
        int max = taskList.size();
        for (int i = 0; i < max; i++) { //index starts from 0.
            tasksToSave.append(taskList.get(i).saveDetailsString()).append(System.lineSeparator());
        }

        String taskListToSave = tasksToSave.toString();
        try {
            writeToFile(filePath, taskListToSave);
        } catch (IOException e) {
            System.out.println("Something went wrong saving the file :(");
        }
    }


    //Should pass out the read item to main to pass to tasklist
    //Tasklist passes the task array to write
}
