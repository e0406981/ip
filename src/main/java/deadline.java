public class deadline extends task {

    protected String date;

    public deadline(String name, Integer number, boolean isDone, String taskType) {
        super(name, number, isDone, taskType);
        this.date = name.substring(name.indexOf('/')+1);
    }

    @Override
    public String date() {
        return name.substring(name.indexOf('/'));
    }

    @Override
    public String getName() {
        return name.substring(9, name.indexOf('/'));
    }

    @Override
    public String toString() {
        return  getTaskType() + getIsDone() + getName() + " " + date;
    }
}
