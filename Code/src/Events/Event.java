package Events;

import org.json.JSONObject;

import java.io.File;

public class Event {
    String name;
    int type;
    Date startDate;
    Date endDate;
    int repeatCycle;
    boolean isDone = false;
    //private String planPath = "planning.json";

    public Event(String name,int type){
        this.name = name;
        this.type = type;
    }

    public void setFlag(){
        this.isDone = true;
    }

    public void toJson(Date date){
        if(type==TypeList.Planningtype){
            /*File file = new File(planPath);
            JSONObject js = new JSONObject();
            if(file.exists()){
            }*/

        }
    }
}
