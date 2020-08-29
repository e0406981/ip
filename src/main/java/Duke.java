import java.util.Scanner;

public class Duke {

    public static boolean isNumeric(String line) {
        if (line == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(line);
        } catch (NumberFormatException nfe) {
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
        Integer TaskNum=0;
        /*
            number of tasks currently in the list
         */

        while(true){
            String line;
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            Integer length = line.length();
            /*
            line is what the user types in
             */

            if(line.equals("bye")){
                System.out.println("See you again :)");
                break;
            }

            else if(line.equals("list")) {
                for(int i=0; i<TaskNum; i++){
                    System.out.println(tasks[i].getNumber() + "." + tasks[i].getIsDone() + " " + tasks[i].getName());
                }
            }

            else if(length >= 6){
                if (line.substring(0, 4).equals("done") && isNumeric(line.substring(5, length))){
                    Integer ToBeSet = Integer.parseInt(line.substring(5, length))-1;
                    /*
                    the task number to be set to done
                     */
                    tasks[ToBeSet].setDone(true);
                    System.out.println("Nice, the following task has been marked as done :)");
                    System.out.println(tasks[ToBeSet].getIsDone() +  " " + tasks[ToBeSet].getName());
                }else{
                    System.out.println("added: " + line);
                    task aTask =  new task(line, TaskNum+1, false);
                    tasks[TaskNum] = aTask;
                    TaskNum++;
                }
            }

            else
                {
                System.out.println("added: " + line);
                task aTask =  new task(line, TaskNum+1, false);
                tasks[TaskNum] = aTask;
                TaskNum++;
            }
            }

        }
    }

