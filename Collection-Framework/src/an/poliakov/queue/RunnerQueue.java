package an.poliakov.queue;

import an.poliakov.queue.setofstacks.SetofStacks;

import java.util.*;

/**
 *  Основные операции при работе с очередью
 * */

//TODO на 05.10 - структура данных SetofStacks которая при заполнение стека создаёт новый и заполнение продолжается в новый стек
public class RunnerQueue {
    public static void main(String[] args) {
        SetofStacks st = new SetofStacks(5);
        st.push("Str11");
        st.push("Str12");
        st.push("Str13");
        st.push("Str14");
        st.push("Str15");
        st.push("Str16");

        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
    }
}
