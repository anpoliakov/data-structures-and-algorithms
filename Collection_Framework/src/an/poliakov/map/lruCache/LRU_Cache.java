package an.poliakov.map.lruCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Свой LRU-Cache - ограничеснная коллекция LinkedHashMap, которая распологает элементы в зависимости
 * от частоты их использования и соответственно удаляет реже используемые элементы (при нехватке места)
 *
 * */
public class LRU_Cache <K, V> extends LinkedHashMap <K, V>{
    private final int capacity;

    public LRU_Cache(int capacity) {
        super(capacity + 1, 1.1f,true);
        this.capacity = capacity;
    }

    //ОСНОВНОЙ метод
    //метод который вызывается ПОСЛЕ того как добавили какой либо элемент в коллекцию
    //"сейчас нужно удалить старый элемент? так как возможно добавление нового элемента?"
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > capacity;
    }
}
