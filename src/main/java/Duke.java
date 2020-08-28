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

        *while(true){
            String line;
            Scanner in = new Scanner(System.in);
            line = in.nextLine();

            if(line.equals("bye")){
                System.out.println("See you again :)");
                break;
            }else{
                System.out.println(line);
            }

        }
    }
}
