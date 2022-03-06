package Events;

public class Event {
    String name;
    int type;
    Date startDate;
    Date endDate;
    int repeatCycle;
    boolean isDone = false;

    public void setFlag(){
        this.isDone = true;
    }
}
