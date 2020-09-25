import java.io.InputStream;
import java.util.Scanner;

public class Ui {

    private final Scanner in;

    public Ui(){
        this(System.in);
    }

    public Ui(InputStream in){
        this.in = new Scanner(in);
    }

    public void showWelcome(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello, what can I do for you?");
    }

    public String readInput(){
        return in.nextLine();
    }

    public void showLine(){
        System.out.println("-----------------------------------------------------");
    }
}
