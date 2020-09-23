public class task {
    protected String name;
    private Integer number;
    private boolean isDone;

    public task(String name, Integer number, boolean isDone) {
        setName(name);
        setNumber(number);
        setDone(isDone);
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

    public String getTaskType(){
        return "";
    }

    public String date() {
        return "";
    }

    @Override
    public String toString() {
        return isDone + name;
    }
}
