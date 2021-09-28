package an.poliakov.list;

import java.util.*;

/**
 * Основные операции при работе с list
 * */
public class RunnerList {
    public static void main(String[] args) {
        RunnerList runer = new RunnerList();

        List<Integer> list = new ArrayList<>();
        for(int i = 5; i <= 10; i++){
            list.add(i);
        }

        runer.deleteElement(new Integer(6),list);

//        //ограниченные методы, более функциональный класс это ListIterator
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        //во время работы с ListIterator не могу использовать методы List (ошибка)
//        System.out.println("ListIterator: ");
//        ListIterator<Integer> listIterator = list.listIterator(3); //получаю итератор уже с нужной точки
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.nextIndex() + " = " + listIterator.next());
//        }
//
//        //TODO: Spliterator
//        System.out.println(list);
    }

    public void deleteElement(Integer number, List <Integer> list){
        if(!list.isEmpty()){
            if(list.remove(number)){
                System.out.println("Элемент - " + number + " удалён");
            }
        }
        System.out.println(list);
    }
}
