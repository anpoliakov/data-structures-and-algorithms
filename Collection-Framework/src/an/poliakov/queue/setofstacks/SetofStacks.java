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
    //если последняя очередь пуста - удалить её
    public String pop (){
        PriorityQueue <String> lastQueue = getLastQeque(); //null - если list пуст
        boolean queueisEmpty = true;

        if(lastQueue != null){ // если что то получил
            do {
                if(lastQueue.size() == 0 && stacks.size() != 0){ //полученный список пуст => удаляем его
                    stacks.remove(lastQueue);
                    stacks.trimToSize();
                    lastQueue = getLastQeque();
                }else {
                    queueisEmpty = false;
                }
            }while (queueisEmpty);

            return lastQueue.poll();
            //TODO проверка опустела ли очередь - если да то удалить её и
        }else {
            System.out.println("-- LIST is EMPTY --");
            return null;
        }
    }
}
