package an.poliakov.map.lruCache;

import java.util.Map;

/**
 *
 * Пример использования своего собственного кэша(самоочищаемый от старых элементов)
 *
 * */
public class RunnerCRU_Cache {
    public static void main(String[] args) {
        //Ограниченная по размеру LinkedHashMap с возможностью удаления старого элемента
        Map<Integer,String> map = new LRU_Cache(3);
        map.put(1,"a");
        map.put(3,"b");
        map.put(4,"f");

        map.get(3);
        map.put(5,"y");         //места нету - удалится старый элемент с key = 1
        map.put(6,"x");         //места нету - удалится старый элемент с key = 4
        System.out.println(map);
    }
}
