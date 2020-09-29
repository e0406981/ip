import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * handles writing/saving file
 */
public class Storage {

    private final Parser parser;
    private final String fileLocation;
    private final String fileName;

    public Storage(Parser parser, String fileLocation, String fileName) {
        this.parser = parser;
        this.fileLocation = fileLocation;
        this.fileName = fileName;
    }

    /**
     * check is file exists
     * @throws IOException in case of error
     */
    private void checkIfFileExists() throws IOException {
        if (!Files.exists(Path.of(fileLocation))) {
            Files.createDirectories(Path.of(fileLocation));
        }
        if (!Files.exists(Path.of(fileLocation + fileName))) {
            Files.createFile(Path.of(fileLocation + fileName));
        }
    }

    /**
     * saves the file
     *
     * @param tasks tasks to be saved
     * @throws IOException in case of saving error
     */
    public void saveFile(ArrayList<task> tasks) throws IOException {
        FileWriter fw = new FileWriter(fileLocation + fileName);
        for (int i = 0; i < tasks.size(); i++) {
            fw.write(i + 1 + tasks.get(i).getTaskType()
                    + tasks.get(i).getIsDone() + tasks.get(i).getName() + tasks.get(i).date() +
                    System.lineSeparator());
        }
        fw.close();
        System.out.println("File has been saved!");
    }

    /**
     * read a text file to return it in ArrayList form
     *
     * @return ArrayList of tasks
     */
    public ArrayList<task> readFile() {

        try {
            checkIfFileExists();
        } catch (IOException e) {
        System.out.println("There was an error in loading the tasks!");
        }
        ArrayList<task> tasks = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileLocation + fileName));
            String line;

            while ((line = in.readLine()) != null) {
                task newTask = loadTask(line);
                tasks.add(newTask);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tasks;

    }

    /**
     * load a task from a SINGLE line in the text file
     *
     * @param line a SINGLE line in the text file
     * @return the task.
     */
    private task loadTask(String line) {
        task NewTask;
        String name = parser.parseNameFromSave(line);
        String date = parser.parseDateFromSave(line);
        boolean isDone = parser.parseDoneFromSave(line);
        String type = parser.parseTypeFromSave(line);

        if (type.equals("[E]")) {
            NewTask = new event(name, isDone, date);
        } else if (type.equals("[D]")) {
            NewTask = new deadline(name, isDone, date);
        } else {
            NewTask = new todo(name, isDone);
        }
        return NewTask;
    }

}
