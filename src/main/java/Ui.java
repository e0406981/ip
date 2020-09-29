import java.io.InputStream;
import java.util.Scanner;

/**
 * handles UI,and what is shown to the user
 */
public class Ui {

    private final Scanner in;

    public Ui(){
        this(System.in);
    }

    public Ui(InputStream in){
        this.in = new Scanner(in);
    }

    /**
     * prints welcome message
     */
    public void showWelcome(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello, what can I do for you?");
    }

    /**
     * returns user input
     * @return user input
     */
    public String readInput(){
        return in.nextLine();
    }

    /**
     * prints line
     */
    public void showLine(){
        System.out.println("-----------------------------------------------------");
    }
}
