import java.util.Scanner;

public class Duke {

    public static boolean isNumeric(String command){
        if(command == null){
            return false;
        }
        try{
            double d = Double.parseDouble(command);
        }catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    /*
    function to check whether is numeric
     */

    public static String checkType(String command) {

        String type = "invalid command";

        if (command.length() >= 10) {
            if (command.startsWith("deadline")) {
                type = "[D]";
                return type;
            }
        }
        if (command.length() >= 7) {
            if (command.startsWith("event")) {
                type = "[E]";
                return type;
            }
        }
        if (command.length() >= 6){
            if (command.startsWith("todo")) {
                type = "[T]";
                return type;
            }
            if (command.startsWith("done") && isNumeric(command.substring(5, command.length()))){
                type = "done command";
            }
        }

        return type;
    }
    /*
    function to check the command type
     */

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello, what can I do for you?");

        task[] tasks = new task[100];
        /*
            array to store the tasks
         */
        Integer NumOfTasks=0;
        /*
            number of tasks currently in the list
         */

        while(true){
            String command;
            Scanner in = new Scanner(System.in);
            command = in.nextLine();
            Integer length = command.length();
            String type ="?";
            /*
            command is what the user types in
            type is the type of task, event/to do/deadlines
             */

            if(command.equals("bye")){
                System.out.println("See you again :)");
                break;
            }

            else if(command.equals("list")) {
                for(int i=0; i<NumOfTasks; i++){
                    System.out.println(tasks[i].getNumber() + "." + tasks[i].getIsDone() + " " + tasks[i].getName()
                                        + tasks[i].date());
                }
            }

            else if(checkType(command).equals("done command")){
                    /*
                    check if first 4 words are done followed by a numeral
                     */
                    Integer ToBeSet = Integer.parseInt(command.substring(5, length))-1;
                    /*
                    the task number to be set to done
                     */
                    if(ToBeSet > NumOfTasks-1){
                        System.out.println("Invalid done command ):");
                        continue;
                        /*
                        to catch if the user tries to enters an invalid task number
                         */
                    }
                    tasks[ToBeSet].setDone(true);
                    System.out.println("Nice, the following task has been marked as done :)");
                    System.out.println(tasks[ToBeSet].getIsDone() +  " " + tasks[ToBeSet].getName());
            }

            else if(checkType(command).equals("[E]")) {
                type = checkType(command);
                task aTask =  new event(command, NumOfTasks+1, false, type);
                tasks[NumOfTasks] = aTask;
                NumOfTasks++;
                System.out.println("Got it, I've added the task:\n"
                        + type + aTask.getIsDone()+ " " + aTask.getName() + aTask.date() + "\n"
                        + NumOfTasks + " tasks are in the list");
            }

            else if(checkType(command).equals("[D]")) {
                type = checkType(command);
                task aTask =  new deadline(command, NumOfTasks+1, false, type);
                tasks[NumOfTasks] = aTask;
                NumOfTasks++;
                System.out.println("Got it, I've added the task:\n"
                        + type + aTask.getIsDone()+ " " + aTask.getName() + aTask.date() +  "\n"
                        + NumOfTasks + " tasks are in the list");
            }

            else if(checkType(command).equals("[T]")) {
                type = checkType(command);
                task aTask =  new todo(command, NumOfTasks+1, false, type);
                tasks[NumOfTasks] = aTask;
                NumOfTasks++;
                System.out.println("Got it, I've added the task:\n"
                        + type + aTask.getIsDone()+ " " + aTask.getName() + aTask.date() + "\n"
                        + NumOfTasks + " tasks are in the list");
            }
            }

        }
    }

