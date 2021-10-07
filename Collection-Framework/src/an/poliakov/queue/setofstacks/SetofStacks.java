package an.poliakov.queue.setofstacks;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Основной класс который будет заниматься всем распределением обьектов по стекам
 * */
public class SetofStacks {
    private final int MAX_SIZE_STECK = 5;
    private int copacity;

    private ArrayList <PriorityQueue<String>> stacks = new ArrayList<>(copacity);

    public SetofStacks(int copacity){
        this.copacity = copacity;
    }

    //ищем в list очередь с хотя бы 1 элементом и возвращаем эту очередь - в противном null
    private PriorityQueue<String> getLastQeque(){
        PriorityQueue <String> lastQueue = null;

        if(stacks.size() == 0){
            return null;
        }

        do{
            lastQueue = stacks.get(stacks.size() - 1);
        }while(!isQueueCompleted(lastQueue) && stacks.size() > 0);

        return lastQueue;
    }

    //универсальнеый метод для добавления
    public void push(String string){
        //TODO ограничение по созданию списков в list
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
    //если последняя очередь пуста - удалить её
    public String pop(){
        PriorityQueue <String> lastQueue = getLastQeque();
        if(lastQueue != null){ //следовательно содержит queue с хотя бы 1 элементом - получаем его
            return lastQueue.poll();
        }
        return null;
    }

    //не хорошая идея - но если переданная queue пустая, она её удаляет из list
    //и сообщает что данная queue не готова к работе
    //метод доступен только в этом классе
    private boolean isQueueCompleted(PriorityQueue priorQueue){
        boolean flag = false;

        if(priorQueue != null){
            if(priorQueue.size() > 0){
                flag = true;
            }else {
                stacks.remove(priorQueue);
                stacks.trimToSize();
            }
        }

        return flag;
    }
}
