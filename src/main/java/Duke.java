import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    //function to check whether is numeric
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

    /*
    function to check the command type & validity
    */
    public static String checkType(String command) throws DukeException {

        String type = "invalid";
        String name = "";
        if(command.contains("/")){
            name = command.substring(command.indexOf(' ') + 1, command.indexOf('/'));
        }

        if (command.startsWith("deadline")) {
            type = "deadline";
            if (command.equals("deadline")) {
                throw new DukeException("Deadline is empty!");
            }
            if (!command.contains("/")) {//if there is no '/by'
                throw new DukeException("Deadline has no date!");
            }
            if (name.isBlank() || name.isEmpty()) {
                throw new DukeException("Deadline has no description!");
            }
        }

        if (command.startsWith("event")) {
            type = "event";
            if (command.equals("event")) {
                throw new DukeException("Event is empty!");
            }
            if (!command.contains("/")) {
                throw new DukeException("Event has no date! Please enter date after a '/' ");
            }
            if (name.isBlank() || name.isEmpty()) {
                throw new DukeException("Event has no description!");
            }
            return type;
        }


        if (command.startsWith("todo")) {
            type = "todo";
            if (command.equals("todo")) {
                throw new DukeException("Todo is empty!");
            }
            return type;
        }

        if (command.startsWith("done")) {
            if (isNumeric(command.substring(command.indexOf(" ") + 1)))
                type = "done";
        }

        if (command.equals("list")) {
            return "list";
        }
        if (command.equals("bye")) {
            return "bye";
        }
        if (command.equals("save")) {
            return "save";
        }
        if (command.equals("help")){
            return "help";
        }
        if (command.startsWith("delete")){
            if (isNumeric(command.substring(command.indexOf(" ") + 1)))
                type = "delete";
        }
        if (type.equals("invalid")) {
            throw new DukeException("I do not understand, please enter a valid command! " +
                    "Enter 'help' for a list of commands!" );
        }


        return type;
    }

    public static task createTask(String type, int numOfTasks, String command) {

        numOfTasks++;
        task NewTask;
        if (type.equals("event")) {
            NewTask = new event(command, numOfTasks, false);
        } else if (type.equals("deadline")) {
            NewTask = new deadline(command, numOfTasks, false);
        } else {
            NewTask = new todo(command, numOfTasks, false);
        }
        System.out.println("Got it, I've added the task:" + "\n" +
                NewTask + "\n" +
                numOfTasks + " tasks are in the list");
        return NewTask;
    }

    public static task loadTask(String type, int numOfTasks, String line){
        numOfTasks++;
        task NewTask;
        boolean isDone=false;
        int nameEnd=0;
        int nameStart = line.indexOf("]", line.indexOf("]")+1)+1;
        if(line.contains("/")) {
            nameEnd = line.indexOf("/");
        }
        if(line.contains("[✓]")){
            isDone = true;
        }
        if (type.equals("[E]")) {
            line = "event" + " " + line.substring(nameStart, nameEnd) + line.substring(nameEnd);
            NewTask = new event(line, numOfTasks, isDone);
        } else if (type.equals("[D]")) {
            line = "deadline" + " " + line.substring(nameStart, nameEnd) + line.substring(nameEnd);
            NewTask = new deadline(line, numOfTasks, isDone);
        } else {
            line = "todo" + " " + line.substring(nameStart);
            NewTask = new todo(line, numOfTasks, isDone);
        }
        return NewTask;
    }

    public static void saveFile(String filePath, ArrayList<task> tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < tasks.size(); i++) {
            fw.write(i + 1 + tasks.get(i).getTaskType()
                    + tasks.get(i).getIsDone() + tasks.get(i).getName() + tasks.get(i).date() +
                    System.lineSeparator());
        }
        fw.close();
        System.out.println("File has been saved!");
    }

    private static int readFile(String file, ArrayList<task> tasks) {
        int number = 0;
        try {
            tasks.clear();
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;

            while ((line = in.readLine()) != null) {
                String type = line.substring(line.indexOf("["), line.indexOf("]") + 1);
                task newTask = loadTask(type, number, line);
                tasks.add(newTask);
                number++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }

    private static void delete(ArrayList<task> tasks, String command){
        int taskNum = Integer.parseInt(command.substring(command.indexOf(" ")+1));
        tasks.remove(taskNum-1);
        System.out.println("Task number " + taskNum + " has been deleted!");
        for(int i=0; i<tasks.size(); i++){
            tasks.get(i).setNumber(i+1);
        }
     }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello, what can I do for you?");

        ArrayList<task> tasks = new ArrayList<>();
        String file = "data/savaData.txt";
        int numOfTasks = readFile(file, tasks);

        label:
        while (true) {
            try {

                String command;
                Scanner scanner = new Scanner(System.in);
                command = scanner.nextLine();
                int length = command.length();
                String type = checkType(command);
            /*
            type is the type of task, event/to do/deadlines
             */
                switch (type) {
                    case "bye":
                        System.out.println("See you again :)");
                        break label;
                    case "list":
                        if(tasks.size() == 0){
                            System.out.println("List is empty!");
                        }else {
                            for (int i = 0; i < tasks.toArray().length; i++) {
                                System.out.println(tasks.get(i));
                            }
                        }
                        break;
                    case "help":
                        System.out.println("Commands are \n" +
                                "list : shows current tasks\n" +
                                "bye : exits the program\n" +
                                "done number : e.g done 2, sets the task at the number to done \n" +
                                "event name/date : e.g event Birthday /tomorrow \n" +
                                "todo name : e.g todo Homework\n" +
                                "deadline name/date : e.g deadline Project /next Sunday\n" +
                                "delete number : e.g delete 2, deletes a task\n" +
                                "save number : e.g save 2, saves the current list");
                        break;
                    case "done":
                        int taskNum = Integer.parseInt(command.substring(command.indexOf(" ")+1, length)) - 1;
                    /*
                    the task number to be set to done
                     */
                        if (taskNum > numOfTasks - 1 || taskNum < 0) {
                            System.out.println("Invalid done command, number is out of range ):");
                            continue;
                        /*
                        to catch if the user tries to enters an invalid task number
                         */
                        }
                        tasks.get(taskNum).setDone(true);
                        System.out.println("Nice, the following task has been marked as done :)" + "\n" +
                                tasks.get(taskNum));
                        break;
                    case "event":
                    case "todo":
                    case "deadline":
                        tasks.add(createTask(type, numOfTasks, command));
                        numOfTasks++;

                        break;
                    case "save":
                        saveFile(file, tasks);
                        break;
                    case "delete":
                        taskNum = Integer.parseInt(command.substring(command.indexOf(" ")+1, length)) - 1;
                        if (taskNum > numOfTasks - 1 || taskNum < 0) {
                            System.out.println("Invalid delete command, number is out of range ):");
                            continue;
                        /*
                        to catch if the user tries to enters an invalid task number
                         */
                        }
                        delete(tasks, command);
                        numOfTasks--;
                }
            } catch (DukeException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


