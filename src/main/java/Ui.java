import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Ui {

    private final Scanner in;
    private final PrintStream out;

    public Ui(){
        this(System.in, System.out);
    }

    public Ui(InputStream in, PrintStream out){
        this.in = new Scanner(in);
        this.out = out;
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

    public void showLoadingError(){
        System.out.println("There was a problem in loading the file!");
    }

    public void showLine(){
        System.out.println("-----------------------------------------------------");
    }
}
