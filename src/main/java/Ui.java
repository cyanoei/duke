public class Ui {

    public void printIntro() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        printNewLine();
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
        //printNewLine();
    }

    public void printNewLine() {
        System.out.println("____________________________________________________________");
    }

    public void printExitMessage() {
        printNewLine();
        System.out.println("Bye! Hope to see you again soon!");
        printNewLine();
    }


}
