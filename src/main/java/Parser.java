import java.util.Scanner;

/**
 * Interprets command strings by the user.
 * Todo: Converts command strings into command objects that can be processed at the level of the duke class.
 */

public class Parser {

    //TODO:

    private boolean isInteger(String test) {
        try {
            Integer.parseInt(test);  //TODO: Improve this.
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    //functions for each type of thing!



    /**
     * Checks if the command keyword (first word is valid).
     * Determines what to do with the remaining string depending on the command.
     * Also handles exceptions for bad description string inputs.
     *
     * @param listInput array containing the command and description from the user.
     * @return an array where the first item is the command word and the second item is the rest of the text.
     * @throws BadInputException If the first word is not one of the recognised commands.
     */
    private Command handleListInput(String listInput) throws BadInputException {

        String[] keyword = listInput.split(" ", 2);
        Command command;

        switch (keyword[0]) {
            //Commands which are single words.
            case "list":
                command = new Command(Command.CommandType.LIST);
                break;
            case "bye":
                command = new Command(Command.CommandType.BYE);
                break;

            //Commands which require numerical input.
            case "done":
                if (isInteger(keyword[1])) {

                }
                break;
            case "delete": {
                if (isInteger(keyword[1])) {

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
                    //command[1] = description;
                } else {
                    //command[0] = null;
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
                command = new Command(); //Bad Command
                throw new BadInputException("Sorry, I don't recognise that input keyword!");
        }
        return command;
    }

    /**
     * Reads in the command string from the user and looks at the first word.
     * The first word and any remaining characters are separated and passed to the handler.
     *
     * @return an array where the first item is the command word and the second item is the rest of the text.
     */
    public Command parse(String userInput) {

        Command userCommand;

        //TODO: Make this a do-while that waits for a good input
        //TODO: Shift this implementation to the Ui class
        try {
            userCommand = handleListInput(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Please input only an integer after the command.");
            userCommand = new Command();

        } catch (Exception e) { //e is a string - the exception message
            System.out.println("Parser error.");
            System.out.println(e);
            userCommand = new Command();

        }

        return userCommand;
    }

}
