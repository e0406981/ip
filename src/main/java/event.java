public class event extends task {

    public event(String name, Integer number, boolean isDone, String taskType){
        super(name,number,isDone,taskType);
    }
    @Override
    public String date(){
        return "(at: " + name.substring(name.indexOf('/')+4) + ")";
    }
    @Override
    public String getName(){
        return name.substring(6, name.indexOf('/'));
    }
}
