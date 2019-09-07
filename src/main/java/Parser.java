import java.util.Scanner;

public class Parser {

    private Scanner in;

    public Parser() {
        this.in = new Scanner(System.in);
    }

    private String[] handleListInput(String listInput) throws BadInputException {

        String[] keyword = listInput.split(" ", 2);
        String[] command = new String[2];

        command[0] = keyword[0]; //Assume command is correctly entered.

        switch (keyword[0]) {
            //Commands which are single words.
            case "list":
            case "bye":
                break;

            //Commands which require numerical input.
            case "done":
            case "delete": {
                try {
                    Integer.parseInt(keyword[1]);  //TODO: Improve this.
                    command[1] = keyword[1];
                } catch (NumberFormatException e){
                    System.out.println("Please enter a valid number.");
                    command[0] = null;
                }
                break;
            }

            //Commands which require string input.
            case "todo":
            case "deadline":
            case "event":
            case "find": {
                String description = keyword[1].trim(); //Might need to catch empty string exceptions?
                if (!description.isBlank()) {
                    command[1] = description;
                } else {
                    command[0] = null;
                    switch (keyword[0]) {
                        case "deadline":
                            System.out.println("Please enter the description of the deadline.");
                        case "event":
                            System.out.println("Please enter the description of the event.");
                        case "find":
                            System.out.println("Please enter the search description.");
                    }
                }
                break;
            }

            default:
                command[0] = null;
                throw new BadInputException("Sorry, I don't recognise that input keyword!");
        }
        return command;
    }

    public String[] parse() {
        String userInput = in.nextLine(); //Todo: Should be the Ui's problem

        String[] command;
        command = new String[2];


        //TODO: Make this a do-while that waits for a good input
        //TODO: Shift this implementation to the Ui class
        try {
            command = handleListInput(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Please input only an integer after the command.");
            command[0] = null;
        } catch (Exception e) { //e is a string - the exception message
            System.out.println("Parser error.");
            System.out.println(e);
            command[0] = null;
        }

        return command;
    }

}
