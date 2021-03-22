package an.poliakov;

import java.util.Arrays;

/**
 * ЗАДАЧА: из ряда цифр, получить максимально возможное число
 *
 * Простой пример работы жадного алгоритма:
 * на каждом шаге выбираем оптимальное(жадное) решение,
 * в итоге получим - оптимальное общее решение данной задачи
 *
 * */
public class Runner {
    public static void main(String[] args) {
        int [] digits = {3,1,7,5,9,9,8};
        System.out.println(maxNumberFromDigits(digits));
    }

    // общая сложность О(n * log(n))
    public static String maxNumberFromDigits(int [] digits){    // [3,1,7,5,9,9,8]
        Arrays.sort(digits);                                    // [1,3,5,7,8,9,9] простая сортировка и массив готов
        String result = "";

        for (int i = digits.length - 1; i >= 0; i--)
            result += digits[i];

        return result;

        /*
        *
        * Более красивое решение, используя Java 8:
        * return: String.join("", Arrays.stream(digits).boxed()
        *           .sorted(Collections.reverseOrder())
        *           .map(String::valueOf).toArray(String[]::new));
        *
        * */
    }
}
