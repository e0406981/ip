/**
 * class of an event task
 */
public class event extends task {

    private final String date;

    public event(String name, boolean isDone, String date){
        super(name, isDone);
        this.date = date;
    }

    /**
     * returns the event type
     * @return event type
     */
    @Override
    public String getTaskType(){
        return "[E]";
    }

    /**
     * returns date of task
     * @return date of task
     */
    @Override
    public String date(){
        return date;
    }

    /**
     * returns name of task
     * @return name of task
     */
    @Override
    public String getName(){
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

