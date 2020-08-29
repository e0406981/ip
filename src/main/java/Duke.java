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


    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello, what can I do for you?");

        task tasks[] = new task[100];
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
            /*
            command is what the user types in
             */

            if(command.equals("bye")){
                System.out.println("See you again :)");
                break;
            }

            else if(command.equals("list")) {
                for(int i=0; i<NumOfTasks; i++){
                    System.out.println(tasks[i].getNumber() + "." + tasks[i].getIsDone() + " " + tasks[i].getName());
                }
            }

            else if(length >= 6){
                if (command.substring(0, 4).equals("done") && isNumeric(command.substring(5, length))){
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
                }else{
                    System.out.println("added: " + command);
                    task aTask =  new task(command, NumOfTasks+1, false);
                    tasks[NumOfTasks] = aTask;
                    NumOfTasks++;
                }
            }

            else
                {
                System.out.println("added: " + command);
                task aTask =  new task(command, NumOfTasks+1, false);
                tasks[NumOfTasks] = aTask;
                    NumOfTasks++;
            }
            }

        }
    }

