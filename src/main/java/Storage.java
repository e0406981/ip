import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {

    private final Parser parser;

    public Storage(Parser parser) {
        this.parser = parser;
    }

    public void saveFile(ArrayList<task> tasks) throws IOException {
        String filePath = "data/saveData.txt";
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < tasks.size(); i++) {
            fw.write(i + 1 + tasks.get(i).getTaskType()
                    + tasks.get(i).getIsDone() + tasks.get(i).getName() + tasks.get(i).date() +
                    System.lineSeparator());
        }
        fw.close();
        System.out.println("File has been saved!");
    }

    public ArrayList<task> readFile() {

        ArrayList<task> tasks = new ArrayList<>();
        String filePath = "data/saveData.txt";

        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
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

    public task loadTask(String line) {
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
