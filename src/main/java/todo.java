public class todo extends task {
    public todo(String name, Integer number, boolean isDone) {
        super(name, number, isDone);
    }

    @Override
    public String getName() {
        return name.substring(5);
    }
    @Override
    public String getTaskType(){
        return "[T]";
    }

    @Override
    public String toString() {
        return  getNumber() + getTaskType() + getIsDone() + " " + getName();
    }
}
