public class Tasklist {
    private String[] tasklist = new String[100];

    private int listIndex = 0;

    private void setListIndex(int value) {
        listIndex = value;
    }
    private int getListIndex() {
        return listIndex;
    }

    private void addListItem(String item) {
        tasklist[getListIndex()] = item; //Update the right index
        System.out.println("Item added: " + item);
        setListIndex(getListIndex() + 1); //Increment the index
    }

    private void printList() {
        int max = getListIndex();
        for (int i = 0; i < max; i++) {
            System.out.println((i+1) + ". " + tasklist[i]);
        }
    }

    public void handleListInput(String listInput) {
        if (listInput.equals("list")) {
            printList();
        } else {
            addListItem(listInput);
        }
    }

}

