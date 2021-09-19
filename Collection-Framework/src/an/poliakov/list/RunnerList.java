package an.poliakov.list;

import java.util.*;

/**
 * Помимо стандартных методов, можем выполнить:
 *
 * */
public class RunnerList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 5; i <= 10; i++){
            list.add(i);
        }

        //ограниченные методы, более функциональный класс это ListIterator
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //во время работы с ListIterator не могу использовать методы List (ошибка)
        System.out.println("ListIterator: ");
        ListIterator<Integer> listIterator = list.listIterator(3); //получаю итератор уже с нужной точки
        while (listIterator.hasNext()){
            System.out.println(listIterator.nextIndex() + " = " + listIterator.next());
        }

        //TODO: Spliterator
        System.out.println(list);
    }
}
