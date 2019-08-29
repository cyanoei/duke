//Cleaned up


//public class Tasklist {
//    private Task[] tasklist = new Task[100];
//    private int listIndex;
//
//    public Tasklist() {
//        this.listIndex = 1; //Easier to start from 1.
//    }
//
//    private void setListIndex(int value) {
//        listIndex = value;
//    }
//
//    private void addListItem(String item) {
//        tasklist[listIndex] = new Task(item, listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
//        System.out.println("Item added: " + item);
//        setListIndex(listIndex + 1); //Increment the index
//    }
//
//    private void addTodoItem(String item) throws InsufficientInfoException {
//        try {
//            String todoitem = item.substring(5);
//
//            if (todoitem.length() == 0) {
//                throw new InsufficientInfoException("Sorry, the description of a Todo cannot be blank!");
//            } else {
//                tasklist[listIndex] = new Todo(todoitem, listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
//                System.out.println("Todo item added: " + todoitem);
//                setListIndex(listIndex + 1); //Increment the index
//            }
//        } catch (StringIndexOutOfBoundsException e) {
//            System.out.println("Sorry, the description of a Todo cannot be blank!");
//        }
//    }
//
//    private void addDeadlineItem(String item) throws InsufficientInfoException {
//        if (item.length() < 9) { //Guarantees content
//            throw new InsufficientInfoException("Sorry, the description of a Deadline cannot be blank!");
//        } else {
//            String deadline[] = item.substring(9).split("/by ");
//
//            if (deadline[0].length() == 0) {
//                throw new InsufficientInfoException("Sorry, the description of a Deadline cannot be blank!");
//            } else if ((deadline.length < 2) || deadline[1].length() == 0) { //If the field is empty or does not exist
//                throw new InsufficientInfoException("Sorry, the Deadline must have a date to be completed /by.");
//            } else {
//                tasklist[listIndex] = new Deadline(deadline[0], deadline[1], listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
//                System.out.println("Deadline item added: " + deadline[0]);
//                System.out.println("Deadline is: " + deadline[1]);
//                setListIndex(listIndex + 1); //Increment the index
//            }
//        }
//    }
//
//    private void addEventItem(String item) throws InsufficientInfoException {
//
//        if (item.length() < 6) { //Guarantees content
//            throw new InsufficientInfoException("Sorry, the description of an Event cannot be blank!");
//        } else {
//            String event[] = item.substring(6).split("/at ");
//
//            if (event[0].length() == 0) {
//                throw new InsufficientInfoException("Sorry, the description of an Event cannot be blank!");
//            } else if ((event.length < 2) || event[1].length() == 0) {
//                throw new InsufficientInfoException("Sorry, the event must have a timeframe it happens /at.");
//            } else {
//                tasklist[listIndex] = new Event(event[0], event[1], listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
//                System.out.println("Event item added: " + event[0]);
//                System.out.println("Event happens at: " + event[1]);
//                setListIndex(listIndex + 1); //Increment the index
//            }
//        }
//    }
//
//    private void printList() {
//        int max = listIndex;
//        for (int i = 1; i < max; i++) { //index starts from 1.
//            System.out.print(i + ". ");
//            tasklist[i].printTaskDetails();
//        }
//    }
//
//    private void markTaskAsDone(int i) {
//        System.out.print("Nice! I've marked this task as done: ");
//        tasklist[i].markAsDone(); //Mark task as done.
//        System.out.println(tasklist[i].getDescription()); //Prints task name
//    }
//
//    public void handleListInput(String listInput) throws BadInputException, InsufficientInfoException {
//        if (listInput.length() >= 4 && listInput.substring(0, 4).equals("list")) { //Both "list" and "list " will now be the right command.
//            printList();
//        } else if (listInput.length() >= 4 && listInput.substring(0, 4).equals("done")) { //Modified to include the space after done.
//            String number = listInput.substring(5);
//            markTaskAsDone(Integer.parseInt(number));
//        } else if (listInput.length() >= 4 && listInput.substring(0, 4).equals("todo")) {
//
//            addTodoItem(listInput);
//
//        } else if (listInput.length() >= 8 && listInput.substring(0, 8).equals("deadline")) {
//
//            addDeadlineItem(listInput);
//
//        } else if (listInput.length() >= 5 && listInput.substring(0, 5).equals("event")) {
//
//            addEventItem(listInput);
//
//        } else {
//
//            throw new BadInputException("Sorry, don't recognise that input!");
//        }
//    }
//
//}
//
