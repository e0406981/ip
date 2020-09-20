import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {

    //function to check whether is numeric
    public static boolean isNumeric(String command) throws DukeException {
        if (command == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(command);
        } catch (NumberFormatException nfe) {
            throw new DukeException("Please enter a number after done!");
        }
        return true;
    }

    /*
    function to check the command type & validity
    */
    public static String checkType(String command) throws DukeException {

        String type = "invalid";

        if (command.startsWith("deadline")) {
            type = "[D]";
            if (command.equals("deadline")) {
                throw new DukeException("Deadline is empty!");
            }
            if (!command.contains("/")) {//if there is no '/by'
                throw new DukeException("Deadline has no date!");
            }
            String name = command.substring(command.indexOf(' ') + 1, command.indexOf('/'));
            if (name.isBlank() || name.isEmpty()) {
                throw new DukeException("Deadline has no description!");
            }
        }

        if (command.startsWith("event")) {
            type = "[E]";
            if (command.equals("event")) {
                throw new DukeException("Event is empty!");
            }
            if (!command.contains("/")) {
                throw new DukeException("Event has no date! Please enter date after a '/' ");
            }
            String name = command.substring(command.indexOf(' ') + 1, command.indexOf('/'));
            if (name.isBlank() || name.isEmpty()) {
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
        if (type.equals("invalid")) {
            throw new DukeException("I do not understand, please enter a valid command!");
        }


        return type;
    }

    public static task createTask(String type, int numOfTasks, String command) {

        numOfTasks++;
        task NewTask;
        if (type.equals("[E]")) {
            NewTask = new event(command, numOfTasks, false, type);
        } else if (type.equals("[D]")) {
            NewTask = new deadline(command, numOfTasks, false, type);
        } else {
            NewTask = new todo(command, numOfTasks, false, type);
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
            NewTask = new event(line, numOfTasks, isDone, type);
        } else if (type.equals("[D]")) {
            line = "deadline" + " " + line.substring(nameStart, nameEnd) + line.substring(nameEnd);
            NewTask = new deadline(line, numOfTasks, isDone, type);
        } else {
            line = "todo" + " " + line.substring(nameStart);
            NewTask = new todo(line, numOfTasks, isDone, type);
        }
        return NewTask;
    }

    public static void saveFile(String filePath, ArrayList<task> tasks, int numOfTasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < numOfTasks; i++) {
            fw.write(i + 1 + tasks.get(i).getTaskType()
                    + tasks.get(i).getIsDone() + tasks.get(i).getName() + tasks.get(i).date() +
                    System.lineSeparator());
        }
        fw.close();
    }

    private static int readFile(String file, ArrayList<task> tasks) {
        int number = 0;
        try {
            tasks.clear();
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            boolean isDone = false;

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
                Integer length = command.length();
                String type = checkType(command);
            /*
            type is the type of task, event/to do/deadlines
             */
                switch (type) {
                    case "bye":
                        System.out.println("See you again :)");
                        break label;
                    case "list":
                        for (int i = 0; i < tasks.toArray().length; i++) {
                            System.out.println(tasks.get(i));
                        }
                        break;
                    case "done":
                        Integer taskNum = Integer.parseInt(command.substring(5, length)) - 1;
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
                    case "[E]":
                    case "[T]":
                    case "[D]":
                        tasks.add(createTask(type, numOfTasks, command));
                        numOfTasks++;

                        break;
                    case "save":
                        saveFile(file, tasks, numOfTasks);
                        break;
                }
            } catch (DukeException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


