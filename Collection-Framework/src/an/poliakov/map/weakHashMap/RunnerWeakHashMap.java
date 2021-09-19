package an.poliakov.map.weakHashMap;

import java.util.Map;
import java.util.WeakHashMap;

/**
 *
 * Фишка данного класса в том - что при удалении ссылки на ключ в коллекции,
 * элемент удаляется сборщиком мусора
 *
 * */
public class RunnerWeakHashMap {
    public static void main(String[] args) {
        Map<Object,String> map = new WeakHashMap<>();
        Object o1 = new Object();
        map.put(o1, "myObj");

        o1 = null; //теперь GC получил доступ и может удалить элемент из коллекции
        System.gc();

        for (int i = 0; i <= 1000; i++){
            if(map.isEmpty()){
                System.out.println("Map is empty! iter = " + i);
                break;
            }
        }
    }
}
