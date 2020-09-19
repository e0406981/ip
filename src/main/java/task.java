public class task {
    protected String name;
    private Integer number;
    private boolean isDone;
    private String taskType;

    public task(String name, Integer number, boolean isDone, String taskType) {
        setName(name);
        setNumber(number);
        setDone(isDone);
        setTaskType(taskType);
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getTaskType() {
        return taskType;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public String getIsDone() {
        if (isDone) {
            return "[✓]";
        } else {
            return "[✗]";
        }
    }

    public String date() {
        return "";
    }

    @Override
    public String toString() {
        return  taskType + isDone + name;
    }
}