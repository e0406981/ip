import java.util.ArrayList;

public class TaskManager {

    private final ArrayList<task> tasks;

    public TaskManager(ArrayList<task> saveFile) {
        tasks = saveFile;
    }

    public void printTasks() {
        if (tasks.size() == 0) {
            System.out.println("List is empty!");
        } else {
            for (int i = 0; i < tasks.toArray().length; i++) {
                System.out.println( String.valueOf(i+1) + tasks.get(i));
            }
        }
    }

    public void printHelp() {
        System.out.println("inputs are \n" +
                "list : shows current tasks\n" +
                "bye : exits the program\n" +
                "done number : e.g done 2, sets the task at the number to done \n" +
                "event name/date : e.g event Birthday /tomorrow \n" +
                "todo name : e.g todo Homework\n" +
                "deadline name/date : e.g deadline Project /next Sunday\n" +
                "delete number : e.g delete 2, deletes a task\n" +
                "save number : e.g save 2, saves the current list");
    }

    public void printBye() {
        System.out.println("See you again :)");
    }

    public void setDone(int taskNum) {

        if (taskNum > tasks.size() - 1 || taskNum < 0) {//if invalid number
            System.out.println("Invalid done input, number is out of range ):");
        }else if(tasks.get(taskNum).getIsDone().equals("[✓]")){
            System.out.println(("Task is already set to done!"));
        }else{
            tasks.get(taskNum).setDone(true);
            System.out.println("Nice, the following task has been marked as done :)" + "\n" +
                    tasks.get(taskNum));
        }
    }

    public void deleteTask(int taskNum) {
        if (taskNum > tasks.size() - 1 || taskNum < 0) {//if invalid number
            System.out.println("Invalid delete input, number is out of range ):");
        } else {
            tasks.remove(taskNum);
            System.out.println("Task number " + (taskNum+1) + " has been deleted!");
        }
    }
    public void addTask(String name, String date, String type) {
        task NewTask;
        if (type.equals("event")) {
            NewTask = new event(name, false, date);
        } else if (type.equals("deadline")) {
            NewTask = new deadline(name, false, date);
        } else {
            NewTask = new todo(name, false);
        }
        System.out.println("Got it, I've added the task:" + "\n" +
                NewTask + "\n" +
                (tasks.size()+1) + " tasks are in the list");

        tasks.add(NewTask);
    }

    public void findTask(String name){
        ArrayList<task> tasksFound = new ArrayList<>();
        for (task task : tasks) {
            if (task.getName().contains(name)) {
                tasksFound.add(task);
            }
        }
        System.out.println(tasksFound.size() + " tasks were found:");
        for (int i=0; i<tasksFound.size(); i++){
            System.out.println( String.valueOf(i+1) + tasksFound.get(i));
        }
    }

    public ArrayList<task> getList(){
        return tasks;
    }

}
