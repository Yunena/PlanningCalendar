import Events.Event;
import Events.PathList;
import org.json.JSONObject;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class EventController {
    public static Map<String,Map<Integer,String>> getPlanningType(){
        File file = new File(PathList.PlanningPath);
        StringBuffer sb = new StringBuffer();
        String s="{}";
        if (file.exists()){
            try (Reader reader = new InputStreamReader(new FileInputStream(file), "utf-8")) {
                int ch = 0;
                while ((ch = reader.read()) != -1) {
                    sb.append((char) ch);
                }
                if(!sb.isEmpty())
                    s = sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        else{
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(s);
        Map<String,Object> orimap = new JSONObject(s).toMap();
        Map<String,Map<Integer,String>> map = new HashMap<>();
        for(String key:orimap.keySet()){
            //System.out.println(key);
            Map<String,Object> orivalue = (Map<String, Object>) orimap.get(key);
            Map<Integer,String> value = new HashMap<>();
            for(String num:orivalue.keySet()){
                //System.out.println(num);
                value.put(Integer.parseInt(num),String.valueOf(orivalue.get(num)));
            }
            map.put(key,value);
        }
        return map;

    }

    public static Map<String,Map<Integer,String>> updatePlanningType(Map<String,Map<Integer,String>>map, String date, String name){
        //System.out.println(map.toString());
        int num = 0;
        Map<Integer,String> listmap = new HashMap<>();
        if(!map.isEmpty()&&map.containsKey(date)){
            listmap = map.get(date);
            num = (int) listmap.keySet().size();
            //System.out.println(num);
        }
        listmap.put(num,name);
        map.put(date,listmap);
        return map;
    }

    public static void savePlanningType(Map<String,Map<Integer,String>> map){
        File file = new File(PathList.PlanningPath);
        JSONObject data = new JSONObject(map);
        Writer writer=null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), "UTF-8"));
            writer.write(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String showPlaningType(String date){
        Map<String,Map<Integer,String>> map = EventController.getPlanningType();
        String list = "";
        if(map.containsKey(date)){
            list = "<html>";
            for(int num:map.get(date).keySet()){
                list+=map.get(date).get(num);
                list+="<br/>";
            }
            list+="</html>";
        }
        return list;
    }

    /*public static void main(String[] args) {
        //System.out.println(ec.showPlanningType());
        Map<String,Map<Integer,String>> map = EventController.updatePlanningType(EventController.getPlanningType(),"2022-3-8","yes");
        EventController.savePlanningType(map);
    }*/

}
