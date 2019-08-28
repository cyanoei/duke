public class Tasklist {
    private Task[] tasklist = new Task[100];
    private int listIndex;

    public Tasklist() {
        this.listIndex = 1; //Easier to start from 1.
    }

    private void setListIndex(int value) {
        listIndex = value;
    }

    private void addListItem(String item) {
        tasklist[listIndex] = new Task(item, listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
        System.out.println("Item added: " + item);
        setListIndex(listIndex + 1); //Increment the index
    }

    private void addTodoItem(String item) {
        String todoitem = item.substring(5);
        tasklist[listIndex] = new Todo(todoitem, listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
        System.out.println("Todo item added: " + todoitem);
        setListIndex(listIndex + 1); //Increment the index
    }

    private void addDeadlineItem(String item) {
        String ditem = item.substring(9);
        String deadline = ditem.split("/")[0];
        String by = ditem.split("/")[1]; //Behind the slash
        tasklist[listIndex] = new Deadline(deadline, by, listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
        System.out.println("Deadline item added: " + deadline);
        System.out.println("Deadline is: " + by);
        setListIndex(listIndex + 1); //Increment the index
    }

    private void printList() {
        int max = listIndex;
        for (int i = 1; i < max; i++) { //index starts from 1.
            tasklist[i].printTaskDetails();
        }
    }

    private void markTaskAsDone(int i) {
        System.out.print("Nice! I've marked this task as done: ");
        tasklist[i].markAsDone(); //Mark task as done.
        System.out.println(tasklist[i].getDescription()); //Prints task name
    }

    public void handleListInput(String listInput) {
        if (listInput.substring(0, 4).equals("list")) { //Both "list" and "list " will now be the right command.
            printList();
        } else if (listInput.length() >= 5 && listInput.substring(0, 5).equals("done ")) { //Modified to include the space after done.
            String number = listInput.substring(5);
            markTaskAsDone(Integer.parseInt(number));
        } else if (listInput.length() >= 5 && listInput.substring(0, 5).equals("todo ")) {

            addTodoItem(listInput);

        } else if (listInput.length() >= 9 && listInput.substring(0, 9).equals("deadline ")) {

            addDeadlineItem(listInput);

        } else if (listInput.length() >= 6 && listInput.substring(0, 6).equals("event ")) {

            //add event item

        } else {
            addListItem(listInput); //Regular "Task" class
            //Or throw an exception?
        }
    }

}

