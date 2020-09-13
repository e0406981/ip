import java.util.Scanner;

public class Duke {

    public static boolean isNumeric(String command) {
        if (command == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(command);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    /*
    function to check whether is numeric
     */

    public static String checkType(String command) throws DukeException {

        String type = "invalid";


        if (command.startsWith("deadline")) {
            type = "[D]";
            if (command.equals("deadline")) {
                throw new DukeException("Deadline is empty!");
            }
            if (!command.contains("/by")) {//if there is no '/by'
                throw new DukeException("Deadline has no date!");
            }
            if (command.indexOf("/by") == 9) {
                throw new DukeException("Deadline has no description!");
            }
        }

        if (command.startsWith("event")) {
            type = "[E]";
            if (command.equals("event")) {
                throw new DukeException("Event is empty!");
            }
            if (!command.contains("/at")) {//if there is no '/at'
                throw new DukeException("Event has no date!");
            }
            if (command.indexOf("/at") == 6) {
                throw new DukeException("Event has no description!");
            }
            return type;
        }


        if (command.startsWith("todo")) {
            type = "[T]";
            if (command.equals("todo")) {
                throw new DukeException("Todo is empty!");
            }
            return type;
        }

        try {
            if (command.startsWith("done")) {
                if (isNumeric(command.substring(5)))
                    type = "doneCommand";
            }
        } catch (StringIndexOutOfBoundsException e) {
            type = "invalidDone";
        }

        if (command.equals("list")){
            return "list";
        }
        if (command.equals("bye")){
            return "bye";
        }
        if (type.equals("invalid")) {
            throw new DukeException("Much like most university students, i do not understand ):");
        }

        return type;
    }
    /*
    function to check the command type
     */

    /*
    function to check if the command is valid
     */
    public static task create(String type, int numOfTasks, String command, task tasks[]){

        numOfTasks++;
        task aTask;
        if (type.equals("[E]")){
            aTask = new event(command, numOfTasks + 1, false, type);
        }else if(type.equals("[D]")){
            aTask = new event(command, numOfTasks + 1, false, type);
        }else {
            aTask = new todo(command, numOfTasks + 1, false, type);
        }
        tasks[numOfTasks] = aTask;
        return aTask;
    }


    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello, what can I do for you?");

        int MAX_TASK = 100;

        task[] tasks = new task[MAX_TASK];
        /*
            array to store the tasks
         */
        Integer numOfTasks = 0;
        /*
            number of tasks currently in the list
         */

        while (true) {
            try {
                String command;
                Scanner in = new Scanner(System.in);
                command = in.nextLine();
                Integer length = command.length();
                String type = checkType(command);
            /*
            command is what the user types in
            type is the type of task, event/to do/deadlines
             */
                if (type.equals("bye")) {
                    System.out.println("See you again :)");
                    break;
                } else if (type.equals("list")) {
                    for (int i = 0; i < numOfTasks; i++) {
                        System.out.println(tasks[i].getNumber() + "." + tasks[i]);
                    }
                } else if (type.equals("doneCommand")) {
                    Integer toBeSet = Integer.parseInt(command.substring(5, length)) - 1;
                    /*
                    the task number to be set to done
                     */
                    if (toBeSet > numOfTasks - 1) {
                        System.out.println("Invalid done command, number is out of range ):");
                        continue;
                        /*
                        to catch if the user tries to enters an invalid task number
                         */
                    }
                    tasks[toBeSet].setDone(true);
                    System.out.println("Nice, the following task has been marked as done :)" + "\n" +
                                        tasks[toBeSet]);
                } else if (type.equals("invalidDone")) {
                    System.out.println("Please enter a number after done ):");
                } else if (type.equals("[E]")) {
                    task aTask = new event(command, numOfTasks + 1, false, type);
                    tasks[numOfTasks] = aTask;
                    numOfTasks++;
                    System.out.println("Got it, I've added the task:" + "\n" +
                                        aTask + "\n" +
                                        numOfTasks+ " tasks are in the list" );
                } else if (type.equals("[D]")) {
                    task aTask = new deadline(command, numOfTasks + 1, false, type);
                    tasks[numOfTasks] = aTask;
                    numOfTasks++;
                    System.out.println("Got it, I've added the task:" + "\n" +
                            aTask + "\n" +
                            numOfTasks+ " tasks are in the list" );
                } else if (type.equals("[T]")) {
                    task aTask = new todo(command, numOfTasks + 1, false, type);
                    tasks[numOfTasks] = aTask;
                    numOfTasks++;
                    System.out.println("Got it, I've added the task:" + "\n" +
                            aTask + "\n" +
                            numOfTasks+ " tasks are in the list" );
                } else if (type.equals("noNameEvent")) {
                    System.out.println("The event has no name!");
                } else if (type.equals("noDateEvent")) {
                    System.out.println("The event has no date!");
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


