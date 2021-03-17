package by.anpoliakov;

public class GoodVersion {
    public static void main(String[] args) {
        System.out.println(goodFib(100));
    }

    /* Отличная реализация, нет повторных вычислений за счёт промежуточного хранения результатов
    плата за это - дополнительная занимаемая память */
    private static long goodFib(int n){
        long [] mas = new long[n + 1];

        //постоянные, которые всегда присутствуют при нахождении числа Фибоначи
        mas[0] = 0;
        mas[1] = 1;

        for (int i = 2; i <= n; i++)
            mas[i] = mas[i-1] + mas[i-2];

        return mas[n];
    }
}
