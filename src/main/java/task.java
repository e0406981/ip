public class task {
    protected String name;
    private boolean isDone;

    public task(String name, boolean isDone) {
        setName(name);
        setDone(isDone);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getName() {
        return name;
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
