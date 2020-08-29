import java.util.Scanner;

public class Duke {

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

            if(line.equals("bye")){
                System.out.println("See you again :)");
                break;
            }else if(line.equals("list")) {
                for(int i=0; i<TaskNum; i++){
                    System.out.println(tasks[i].getNumber() + ". " + tasks[i].getName());
                }
            }else{
                System.out.println("added: " + line);
                task aTask =  new task(line, TaskNum+1, false);
                tasks[TaskNum] = aTask;
                TaskNum++;
            }
            }

        }
    }

