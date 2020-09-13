public class event extends task {

    private String date;

    public event(String name, Integer number, boolean isDone, String taskType){
        super(name,number,isDone,taskType);
        this.date = "(at: " + name.substring(name.indexOf('/')+4) + ")";
    }
    @Override
    public String date(){
        return "(at: " + name.substring(name.indexOf('/')+4) + ")";
    }
    @Override
    public String getName(){
        return name.substring(6, name.indexOf('/'));
    }

    @Override
    public String toString() {
        return  getTaskType() + getIsDone() + getName() + date;
    }
}

