import java.io.IOException;

public class Parser {

    private static final int EVENT_END_INDEX = 5;
    private static final int DEADLINE_END_INDEX = 8;
    private static final int TODO_END_INDEX = 4;
    private static final int DONE_END_INDEX = 4;
    private static final int DELETE_END_INDEX = 6;
    private static final int FIND_END_INDEX = 4;

    public void checkType(String command, TaskManager tasks, Storage storage) throws DukeException, IOException {

        String type;
        String name;
        String date;

        if (command.startsWith("deadline")) {
            type = "deadline";
            if (command.equals("deadline")||command.equals("deadline ")) {
                throw new DukeException("Deadline is empty!");
            }
            if(command.indexOf(" ")!= DEADLINE_END_INDEX){
                throw new DukeException("You might need to leave a space between the command and description");
            }
            if (!command.contains("/")) {//if there is no '/by'
                throw new DukeException("Deadline has no date!");
            }
            name = parseNameFromInput(command);
            date = parseDateFromInput(command);
            if (name.isBlank() || name.isEmpty()) {
                throw new DukeException("Deadline has no description!");
            }
            tasks.addTask(name, date, type);
        } else if (command.startsWith("event")) {
            type = "event";

            if (command.equals("event") || command.equals("event ")) {
                throw new DukeException("Event is empty!");
            }
            if(command.indexOf(" ")!= EVENT_END_INDEX){
                throw new DukeException("You might need to leave a space between the command and description");
            }
            if (!command.contains("/")) {
                throw new DukeException("Event has no date! Please enter date after a '/' ");
            }
            name = parseNameFromInput(command);
            date = parseDateFromInput(command);
            if (name.isBlank() || name.isEmpty()) {
                throw new DukeException("Event has no description!");
            }
            tasks.addTask(name, date, type);
        } else if (command.startsWith("todo")) {
            type = "todo";

            if (command.equals("todo")||command.equals("todo ")) {
                throw new DukeException("Todo is empty!");
            }
            if(command.indexOf(" ")!= TODO_END_INDEX){
                throw new DukeException("You might need to leave a space between the command and description");
            }
            name = parseNameFromInput(command);
            if(name.isBlank()||name.isEmpty()){
                throw new DukeException("Todo is empty!");
            }
            date = parseDateFromInput(command);
            tasks.addTask(name, date, type);
        } else if (command.startsWith("done")) {
            if(command.indexOf(" ")!= DONE_END_INDEX){
                throw new DukeException("You might need to leave a space between the command and description");
            }
            if (isNumeric(command.substring(command.indexOf(" ") + 1)))
                tasks.setDone(parseNumeral(command));
        } else if (command.equals("list")) {
            tasks.printTasks();
        } else if (command.equals("bye")) {
            tasks.printBye();
        } else if (command.equals("save")) {
            storage.saveFile(tasks.getList());
        } else if (command.equals("help")) {
            tasks.printHelp();
        } else if (command.startsWith("delete")) {
            if(command.indexOf(" ")!= DELETE_END_INDEX){
                throw new DukeException("You might need to leave a space between the command and description");
            }
            if (isNumeric(command.substring(command.indexOf(" ") + 1)))
                tasks.deleteTask(parseNumeral(command));
        } else if(command.startsWith("find")){
            if(command.indexOf(" ")!= FIND_END_INDEX){
                throw new DukeException("You might need to leave a space between the command and description");
            }
            name = parseNameFromInput(command);
            tasks.findTask(name);
        }else{
            throw new DukeException("I do not understand, please enter a valid command! " +
                    "Enter 'help' for a list of commands!");
        }

    }

    //parses the name of the task for commands that create tasks
    public String parseNameFromInput(String command) {
        if (command.startsWith("todo") || command.startsWith("find")) {
            return command.substring(command.indexOf(" ") + 1);
        } else {
            return command.substring(command.indexOf(' ') + 1, command.indexOf('/'));
        }
    }

    public String parseDateFromInput(String command) {
        if (command.contains("/")) {
            return command.substring(command.indexOf('/'));
        } else {
            return "";
        }
    }

    public String parseNameFromSave(String line) {
        int nameEnd = 0;
        int nameStart = line.indexOf("]", line.indexOf("]") + 1) + 1;
        String type = parseTypeFromSave(line);
        if (line.contains("/")) {
            nameEnd = line.indexOf("/");
        }
        if (type.equals("[T]")) {
            return line.substring(nameStart);
        } else {
            return line.substring(nameStart, nameEnd);
        }
    }

    public String parseTypeFromSave(String line) {
        return line.substring(line.indexOf("["), line.indexOf("]") + 1);
    }

    public String parseDateFromSave(String line) {
        if (line.contains("/")) {
            return line.substring(line.indexOf("/"));
        } else {
            return "";
        }
    }

    public boolean parseDoneFromSave(String line) {
        return line.contains("[✓]");
    }

    public int parseNumeral(String command) {
        return Integer.parseInt(command.substring(command.indexOf(" ") + 1))-1;
    }

    public static boolean isNumeric(String command) throws DukeException {
        if (command == null) {
            return false;
        }
        try {
            Double.parseDouble(command);
        } catch (NumberFormatException nfe) {
            throw new DukeException("Please enter a valid number after the command");
        }
        return true;
    }
}
