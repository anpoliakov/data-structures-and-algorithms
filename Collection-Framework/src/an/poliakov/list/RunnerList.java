package an.poliakov.list;

import java.util.*;

/**
 * Основные операции при работе с list
 * */
public class RunnerList {
    public static void main(String[] args) {
        RunnerList runer = new RunnerList();
        List <Integer> list = new ArrayList<>(15);
        runer.fillListNumbers(5,15, list);
        runer.fillListNumbers(10,20, list);
        runer.showList(list);
    }

    private void showList(List <Integer> list){
        System.out.println(list);
    }

    //заполняет массив не повторяющимися значениями
    private void fillListNumbers(int start, int end, List <Integer> list){
        for (int i = start; i <= end; i++){
            if (!list.contains(i)){
                list.add(new Integer (i));
            }
        }
    }

    //удаляет обьект из списка, если список не пуст
    private void deleteElement(Integer number, List <Integer> list){
        if(!list.isEmpty()){
            if(list.remove(number)){
                System.out.println("Элемент - " + number + " удалён");
            }
        }
        System.out.println(list);
    }
}

//TODO: поработать с итератором 
