public class Tasklist {
    private String[] tasklist = new String[100];
    private boolean[] donelist = new boolean[100];
    private int listIndex;

    public Tasklist() {
        this.listIndex = 0;
    }

    private void setListIndex(int value) {
        listIndex = value;
    }
    private int getListIndex() {
        return listIndex;
    }

    private void addListItem(String item) {
        tasklist[getListIndex()] = item; //Update the right index
        donelist[getListIndex()] = false;
        System.out.println("Item added: " + item);
        setListIndex(getListIndex() + 1); //Increment the index
    }

    private void printList() {
        int max = getListIndex();
        for (int i = 0; i < max; i++) {
            if (donelist[i]) {
                System.out.print("[\u2713]");
            } else {
                System.out.print("[\u2718]");
            }
            System.out.println(" " + (i+1) + ". " + tasklist[i]);
        }
    }

    private void markAsDone(int i) {
        System.out.print("Nice! I've marked this task as done: ");
        donelist[i] = true; //Mark task as done.
        System.out.println(tasklist[i]); //Prints taskname
    }

    public void handleListInput(String listInput) {
        if (listInput.equals("list")) {
            printList();
        } else if (listInput.length() >= 4 && listInput.substring(0, 4).equals("done")){
            String number = listInput.substring(5);
            //System.out.println("done placeholder");
            markAsDone(Integer.parseInt(number)-1);
        }else {
            addListItem(listInput);
        }
    }

}

