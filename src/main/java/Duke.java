import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private Parser parser;
    private final Storage storage;
    private final TaskManager tasks;
    private final Ui ui;

    public Duke() {
        parser = new Parser();
        storage = new Storage(parser);
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




