package by.anpoliakov;

public class BedVersion {
    public static void main(String[] args) {
        System.out.println(bedFib(5));
    }

    //Плохая реализация, код долго выполняется в рекурсивном цикле (N = 100 -> около 50000 лет)
    //Очень много дублирующегося кода
    private static long bedFib(int n){
        if(n <= 1)
            return n;

        return bedFib(n - 1) + bedFib(n - 2);
    }
}
