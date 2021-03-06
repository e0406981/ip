import java.io.*;
import java.util.ArrayList;

public class Duke {

    private final Parser parser;
    private final Storage storage;
    private final TaskManager tasks;
    private final Ui ui;
    private static final String FILE_LOCATION = "./data/";
    private static final String FILE_NAME = "duke.txt";

    public Duke() {
        parser = new Parser();
        storage = new Storage(parser, FILE_LOCATION, FILE_NAME);
        ArrayList<task> data = storage.readFile();
        tasks = new TaskManager(data);
        ui = new Ui();
    }

    public static void main(String[] args) {
        new Duke().run();
    }

    public void run() {
        boolean programIsRunning = true;

        ui.showWelcome();
        while (programIsRunning) {
            try {
                String input = ui.readInput();
                parser.checkType(input, tasks, storage);
                ui.showLine();
                if (input.equals("bye")) {
                    programIsRunning = false;
                }
            } catch (DukeException | IOException e) {
                System.out.println(e.getMessage());
                ui.showLine();
            }
        }
    }
}




