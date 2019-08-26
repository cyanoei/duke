import java.util.Scanner;

public class Duke {
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

    public static void main(String[] args) {
        printIntro();

        Tasklist l = new Tasklist();
        Scanner in = new Scanner(System.in);

        String userInput = in.nextLine();

        while (!userInput.equals("bye")) {
            printNewLine();
            l.handleListInput(userInput);
            printNewLine();
            userInput = in.nextLine();
        }
        printExitMessage();
    }
}
