public class Tasklist {
    private Task[] tasklist = new Task[100];
    //private boolean[] donelist = new boolean[100];
    private int listIndex;

    public Tasklist() {
        this.listIndex = 1; //Easier to start from 1.
    }

    private void setListIndex(int value) {
        listIndex = value;
    }

//    private int getListIndex() {
//        return listIndex;
//    }

    private void addListItem(String item) {
        tasklist[listIndex] = new Task(item, listIndex); //Use the constructor to create a new Task. Saved index starts from 1.
        //donelist[getListIndex()] = false; //Handled by the class
        System.out.println("Item added: " + item);
        setListIndex(listIndex + 1); //Increment the index
    }

    private void printList() {
        int max = listIndex;
        for (int i = 1; i < max; i++) { //index starts from 1.
//            if (donelist[i]) {
//                System.out.print("[\u2713]");
//            } else {
//                System.out.print("[\u2718]");
//            }
//            System.out.println(" " + (i+1) + ". " + tasklist[i]);

            //Should just repeatedly call a print function from the Task class.
            tasklist[i].printTaskDetails();
        }
    }

    private void markTaskAsDone(int i) {
        System.out.print("Nice! I've marked this task as done: ");
        tasklist[i].markAsDone(); //Mark task as done.
        System.out.println(tasklist[i].getDescription()); //Prints task name
    }

    public void handleListInput(String listInput) {
        if (listInput.equals("list")) {
            printList();
        } else if (listInput.length() >= 4 && listInput.substring(0, 4).equals("done")){
            String number = listInput.substring(5);
            markTaskAsDone(Integer.parseInt(number));
        }else {
            addListItem(listInput);
        }
    }

}

