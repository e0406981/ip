public class task {
    private String name;
    private Integer number;
    private boolean isDone;

    public task(String name, Integer number, boolean isDone){
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

    public String getName(){
        return name;
    }

    public Integer getNumber(){
        return number;
    }

    public boolean getIsDone(){
        return isDone;
    }
}
