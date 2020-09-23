public class event extends task {

    private final String date;

    public event(String name, Integer number, boolean isDone){
        super(name, number, isDone);
        this.date = name.substring(name.indexOf('/'));
    }
    @Override
    public String getTaskType(){
        return "[E]";
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
        return  getNumber()+ getTaskType() + getIsDone() + " " + getName() + " " + date;
    }
}

