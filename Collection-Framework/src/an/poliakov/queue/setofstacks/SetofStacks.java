package an.poliakov.queue.setofstacks;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Основной класс который будет заниматься всем распределением обьектов по стекам
 * */
public class SetofStacks {
    private final int MAX_SIZE_STECK = 5;
    private int copacity;

    private ArrayList <PriorityQueue<String>> stacks = new ArrayList<>();

    public SetofStacks(int copacity){
        this.copacity = copacity;
    }

    //если list очередей не пуст - возвращаем последнюю Queue
    private PriorityQueue<String> getLastQeque(){
        if(stacks.size() == 0){
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    //универсальнеый метод для добавления
    public void push (String string){
        PriorityQueue <String> lastQueue = getLastQeque();
        if(lastQueue != null && lastQueue.size() < MAX_SIZE_STECK){
            lastQueue.add(string);
        }else{
            //значит нет ниодной очереди или последняя очередь заполнена
            //следовательно создаём
            PriorityQueue <String> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(string);
            stacks.add(priorityQueue);
        }
    }

    //универсальнеый метод для получения
    public String pop (){
        return null;
    }
}
