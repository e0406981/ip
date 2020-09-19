public class event extends task {

    private String date;

    public event(String name, Integer number, boolean isDone, String taskType){
        super(name, number, isDone, taskType);
        this.date = name.substring(name.indexOf('/'));
    }
    @Override
    public String date(){
        return name.substring(name.indexOf('/'));
    }
    @Override
    public String getName(){
        return name.substring(name.indexOf(' ')+1, name.indexOf('/'));
    }

    @Override
    public String toString() {
        return  getTaskType() + getIsDone() + getName() + " " + date;
    }
}

