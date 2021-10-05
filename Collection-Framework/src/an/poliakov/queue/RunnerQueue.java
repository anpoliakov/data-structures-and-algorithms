package an.poliakov.queue;

import java.util.*;

/**
 *  Основные операции при работе с очередью
 * */

//TODO на 05.10 - структура данных SetofStacks которая при заполнение стека создаёт новый и заполнение продолжается в новый стек
public class RunnerQueue {
    public static void main(String[] args) {
        ArrayDeque <Integer> queue = new ArrayDeque<>();
        Stack<Integer> steck = new Stack<>();
        steck.add(133);
        steck.add(144);
        steck.add(155);
        Integer peek = steck.search(144);
        System.out.println("ID = " + peek);
        System.out.println(steck);

        LinkedList <Integer> list = new LinkedList<>();

    }
}
