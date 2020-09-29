/**
 * class for a task
 */
public class task {
    protected String name;
    private boolean isDone;

    public task(String name, boolean isDone) {
        setName(name);
        setDone(isDone);
    }

    /**
     * sets name of task
     * @param name name of task
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets task to done or not
     * @param isDone whether task is done
     */
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * gets name of task
     * @return name of task
     */
    public String getName() {
        return name;
    }

    /**
     * returns date of task
     * @return date of task
     */
    public String getIsDone() {
        if (isDone) {
            return "[✓]";
        } else {
            return "[✗]";
        }
    }

    public String getTaskType(){
        return "";
    }

    public String date() {
        return "";
    }

    @Override
    public String toString() {
        return isDone + name;
    }
}
