package Events;

import org.json.JSONArray;
import org.json.JSONObject;

public class Date {
    public int year;
    public int month;
    public int day;

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public JSONObject toJson(){
        JSONObject jso = new JSONObject();
        jso.put("year",this.year);
        jso.put("month",this.month);
        jso.put("day",this.day);
        JSONObject alljso = new JSONObject();
        alljso.put("Date",jso);
        return alljso;
    }

    /*public static void main(String[] args) {
        Date date = new Date(2022,3,6);
        System.out.println(date.toJson());
    }*/

}
