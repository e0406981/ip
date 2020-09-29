/**
 * class for a deadline task
 */
public class deadline extends task {

    protected String date;

    public deadline(String name ,boolean isDone, String date) {
        super(name, isDone);
        this.date = date;
    }

    /**
     * returns deadline type
     * @return deadline type
     */
    @Override
    public String getTaskType(){
        return "[D]";
    }

    /**
     * returns date of task
     * @return date of task
     */
    @Override
    public String date() {
        return date;
    }

    /**
     * return name of task
     * @return name of task
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * returns the task info to be printed as string
     * @return task info in string format
     */
    @Override
    public String toString() {
        return  getTaskType() + getIsDone() + " " + getName() + " " + date;
    }
}
