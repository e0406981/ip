public class deadline extends task {

    protected String date;

    public deadline(String name, Integer number, boolean isDone, String taskType) {
        super(name, number, isDone, taskType);
        this.date = "(by: " + name.substring(name.indexOf('/')+4) + ")";
    }

    @Override
    public String date() {
        return "(by: " + name.substring(name.indexOf('/') + 4) + ")";
    }

    @Override
    public String getName() {
        return name.substring(9, name.indexOf('/'));
    }

    @Override
    public String toString() {
        return  getTaskType() + getIsDone() + getName() + date;
    }
}
