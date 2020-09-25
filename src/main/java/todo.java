public class todo extends task {

    public todo(String name, boolean isDone) {
        super(name, isDone);
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getTaskType(){
        return "[T]";
    }

    @Override
    public String toString() {
        return  getTaskType() + getIsDone() + " " + getName();
    }
}
