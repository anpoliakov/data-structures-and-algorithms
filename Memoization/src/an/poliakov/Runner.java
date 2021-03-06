package an.poliakov;

import java.util.Arrays;

/**
 * Мемоизация - способ ускорение работы программы, за счёт хранения результатов выполнения функций в памяти,
 * (не будем повторять вычесления, как в плохой реализации нахождения чисела фибаночачи)
 * больше используем памяти - быстрее скорость работы (чаще всего) и наоборот.
 * Иногда это более эффективно чем придумать более изощрённый способ ускорения программы.
 * */
public class Runner {
    public static void main(String[] args) {
        int n = 300;                                //число Фибоначи от 100
        long [] mas = new long[n + 1];              //собственно сам массив который хранит результаты вычислений
        Arrays.fill(mas, -1);                   //заполнение массива определённым элементом (-1) что бы понимать места в которых метод не проходил

        System.out.println(getFib(n, mas));
    }

    /* будем запоминать с какими аргументами вызывали данный метод,
    если уже вызывался с подобными аргументами - идём дальше */
    private static long getFib(int n, long[] mas) {
        if(mas[n] != -1)
            return mas[n];

        if(n <= 1)
            return n;

        return mas[n] = getFib(n-1, mas) + getFib(n-2, mas);
    }
}
