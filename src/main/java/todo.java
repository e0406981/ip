/**
 * class of a to do task
 */
public class todo extends task {

    public todo(String name, boolean isDone) {
        super(name, isDone);
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
     * returns to do type
     * @return  to do type
     */
    @Override
    public String getTaskType(){
        return "[T]";
    }
    /**
     * returns the task info to be printed as string
     * @return task info in string format
     */
    @Override
    public String toString() {
        return  getTaskType() + getIsDone() + " " + getName();
    }
}
