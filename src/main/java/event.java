public class event extends task {

    private final String date;

    public event(String name, boolean isDone, String date){
        super(name, isDone);
        this.date = date;
    }
    @Override
    public String getTaskType(){
        return "[E]";
    }
    @Override
    public String date(){
        return date;
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return  getTaskType() + getIsDone() + " " + getName() + " " + date;
    }
}

