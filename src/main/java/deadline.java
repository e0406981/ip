public class deadline extends task {

    protected String date;

    public deadline(String name ,boolean isDone, String date) {
        super(name, isDone);
        this.date = date;
    }
    @Override
    public String getTaskType(){
        return "[D]";
    }
    @Override
    public String date() {
        return date;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  getTaskType() + getIsDone() + " " + getName() + " " + date;
    }
}
