import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;
    private int listIndex;

    public TaskList(ArrayList<Task> savedFile) {
        taskList = savedFile;
        this.listIndex = taskList.size(); //Easier to start from 1.
    }

    public TaskList() {
        taskList = new ArrayList<Task>();
        this.listIndex = 0;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public int getListIndex() {
        return listIndex;
    }

    private void setListIndex(int value) {
        listIndex = value;
    }

    private void addTodoItem(String item) throws InsufficientInfoException {
        try {
            String todoitem = item.substring(5);

            if (todoitem.length() == 0) {
                throw new InsufficientInfoException("Sorry, the description of a Todo cannot be blank!");
            } else {
                taskList.add(new Todo(todoitem, listIndex)); //Use the constructor to create a new Task. Saved index starts from 1.
                System.out.println("Todo item added: " + todoitem);

                setListIndex(listIndex + 1); //Increment the index
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Sorry, the description of a Todo cannot be blank!");
        }
    }

    private void addDeadlineItem(String item) throws InsufficientInfoException {
        if (item.length() < 9) { //Guarantees content
            throw new InsufficientInfoException("Sorry, the description of a Deadline cannot be blank!");
        } else {
            String deadline[] = item.substring(9).split("/by ");

            if (deadline[0].length() == 0) {
                throw new InsufficientInfoException("Sorry, the description of a Deadline cannot be blank!");
            } else if ((deadline.length < 2) || deadline[1].length() == 0) { //If the field is empty or does not exist
                throw new InsufficientInfoException("Sorry, the Deadline must have a date to be completed /by.");
            } else {
                taskList.add(new Deadline(deadline[0], deadline[1], listIndex)); //Use the constructor to create a new Task. Saved index starts from 1.
                System.out.println("Deadline item added: " + deadline[0]);
                System.out.println("Deadline is: " + deadline[1]);

                setListIndex(listIndex + 1); //Increment the index
            }
        }
    }

    private void addEventItem(String item) throws InsufficientInfoException {

        if (item.length() < 6) { //Guarantees content
            throw new InsufficientInfoException("Sorry, the description of an Event cannot be blank!");
        } else {
            String event[] = item.substring(6).split("/at ");

            if (event[0].length() == 0) {
                throw new InsufficientInfoException("Sorry, the description of an Event cannot be blank!");
            } else if ((event.length < 2) || event[1].length() == 0) {
                throw new InsufficientInfoException("Sorry, the event must have a timeframe it happens /at.");
            } else {
                taskList.add(new Event(event[0], event[1], listIndex)); //Use the constructor to create a new Task. Saved index starts from 1.
                System.out.println("Event item added: " + event[0]);
                System.out.println("Event happens at: " + event[1]);
                setListIndex(listIndex + 1); //Increment the index
            }
        }
    }

    private void printList() {
        int max = taskList.size();
        if (max == 0) {
            System.out.println("The list is currently empty.");
            return;
        }

        for (int i = 0; i < max; i++) { //Index starts from 0.
            System.out.print(i+1 + ". "); //Add 1 to follow natural numbers.
            taskList.get(i).printTaskDetails();
        }
    }

    private void deleteTask(int i){
        try{
            Task item = taskList.get(i);
            taskList.remove(i); //The original copy is gone.

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

    private void markTaskAsDone(int i) throws IndexOutOfBoundsException{

        try {
            taskList.get(i).markAsDone(); //Mark task as done.
            System.out.print("Nice! I've marked this task as done: ");
            System.out.println(taskList.get(i).getDescription()); //Prints task name
        } catch (IndexOutOfBoundsException e) {
            printTaskNonexistent();
        }
    }

    private void printTaskNonexistent() {
        System.out.println("That task doesn't exist! Please check the available tasks again: ");
        printList();
    }

    private void searchForTask(String search) {
        int max = taskList.size();
        boolean found = false;

        for (int i = 0; i < max; i ++) {
            if (taskList.get(i).getDescription().contains(search)) {
                System.out.print(i+1 + ". " ); //Print the index of the task.
                taskList.get(i).printTaskDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Sorry, I could not find any tasks containing the description \"" + search + "\"." );
            System.out.println("Please try a different search string.");
        }
    }

    //add handling function.

    //Holds the arraylist of task
    //All the task-related functions (resembles old tasklist class)

}
