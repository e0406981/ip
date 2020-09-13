public class todo extends task {
    public todo(String name, Integer number, boolean isDone, String taskType) {
        super(name, number, isDone, taskType);
    }

    @Override
    public String getName() {
        return name.substring(5);
    }

    @Override
    public String toString() {
        return  getTaskType() + getIsDone() + getName();
    }
}
