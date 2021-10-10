package an.poliakov.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Основные операции при работе с map коллекцией
 * */
public class RunnerMap {
    public static void main(String[] args) {
        RunnerMap rmap = new RunnerMap();
        HashMap <String,String> map = new HashMap<>();
        map.put("S1","Привет");
        map.put("S2","Hello");
        map.put("S3","Hi");

        //прогон всех элементов map по ключ-значение
        for (Map.Entry n : map.entrySet()){
            System.out.println(n.getKey() + " -> " + n.getValue());
        }

        HashMap <String,String> newHashMap = (HashMap) map.clone();
        System.out.println(newHashMap);

        rmap.differentObjects();
    }

    //работа с различными типами в качестве значения
    private void differentObjects(){
        HashMap <String, Object> dmap = new HashMap<>();
        dmap.put("One", 22);
        dmap.put("Two", false);
        dmap.put("Tree", 1.25);

        for (Map.Entry <String, Object> n : dmap.entrySet()){
            String key = n.getKey();
            Object value = n.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
