import java.util.ArrayList;

/**
 * handles tasks, also holds the tasks
 */
public class TaskManager {

    private final ArrayList<task> tasks;

    public TaskManager(ArrayList<task> saveFile) {
        tasks = saveFile;
    }

    /**
     * print all tasks
     */
    public void printTasks() {
        if (tasks.size() == 0) {
            System.out.println("List is empty!");
        } else {
            for (int i = 0; i < tasks.toArray().length; i++) {
                System.out.println( String.valueOf(i+1) + tasks.get(i));
            }
        }
    }

    /**
     * show valid commands
     */
    public void printHelp() {
        System.out.println("inputs are \n" +
                "list : shows current tasks\n" +
                "bye : exits the program\n" +
                "done number : e.g done 2, sets the task at the number to done \n" +
                "event name/date : e.g event Birthday /tomorrow \n" +
                "todo name : e.g todo Homework\n" +
                "deadline name/date : e.g deadline Project /next Sunday\n" +
                "delete number : e.g delete 2, deletes a task\n" +
                "find description : e.g find birthday, checks task's names for description\n"+
                "save: e.g save, saves the current list");
    }

    /**
     * print bye message
     */
    public void printBye() {
        System.out.println("See you again :)");
    }

    /**
     * set a task to done
     * @param taskNum the number of the task in the list
     */
    public void setDone(int taskNum) {

        if (taskNum > tasks.size() - 1 || taskNum < 0) {//if invalid number
            System.out.println("Invalid done input, number is out of range ):");
        }else if(tasks.get(taskNum).getIsDone().equals("[Y]")){
            System.out.println(("Task is already set to done!"));
        }else{
            tasks.get(taskNum).setDone(true);
            System.out.println("Nice, the following task has been marked as done :)" + "\n" +
                    tasks.get(taskNum));
        }
    }

    /**
     * deletes a task from the list
     * @param taskNum the number of the task in the list
     */
    public void deleteTask(int taskNum) {
        if (taskNum > tasks.size() - 1 || taskNum < 0) {//if invalid number
            System.out.println("Invalid delete input, number is out of range ):");
        } else {
            tasks.remove(taskNum);
            System.out.println("Task number " + (taskNum+1) + " has been deleted!");
        }
    }

    /**
     * add a task to the list
     * @param name description of the task
     * @param date date of the task
     * @param type type of the task(event,etc)
     */
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

    /**
     * find a task with the given description
     * @param description what we're trying to find in the list
     */
    public void findTask(String description){
        ArrayList<task> tasksFound = new ArrayList<>();
        for (task task : tasks) {
            if (task.getName().contains(description)) {
                tasksFound.add(task);
            }
        }
        System.out.println(tasksFound.size() + " tasks found:");
        for (int i=0; i<tasksFound.size(); i++){
            System.out.println( String.valueOf(i+1) + tasksFound.get(i));
        }
    }

    /**
     * returns the whole list of tasks
     * @return list of tasks is returned
     */
    public ArrayList<task> getList(){
        return tasks;
    }

}
