package an.poliakov.task3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Пример жадного алгоритма - на каждом этапе выполняется оптимальное решение
 * - в итоге получаем оптимальное решение всей задачи
 *
 * ЗАДАЧА 2: Есть рюкзак и набор придметов с обьявленной стоимостью,
 * предметы можно делить, в итоге цель: заполнить рюкзак предметами
 * для получения максимальной ценности.
 *
 * */
public class FractionalKnapsack {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);

        final Item [] items = {item1, item2, item3};

        // сложность сортировки будет = O(n * log(n));
        // от большей ценности предмета -> к меньшей
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());
        System.out.println(Arrays.toString(items));

        final int W = 7;            //вместимость рюкзака

        int weightSoFar = 0;        //текущий вес
        double valueSoFar = 0;      //текущая ценность
        int currentItem = 0;        //текущий предмет

        while (currentItem < items.length && weightSoFar != W){
            if(weightSoFar + items[currentItem].getWeight() < W){
                //берём обьект целиком
                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();

            }else {
                //берём часть обьекта (рюкзак почти полный)
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight())
                                * items[currentItem].getValue();
                weightSoFar = W;
            }
            currentItem++;
        }

        System.out.println("Ценность наилучшего набора = " + valueSoFar);
    }
}

class Item {
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    //метод предоставляет ценность предмета
    public double valuePerUnitOfWeight(){
        return value / (double) weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{w =" + weight + ", v =" + value + "}";
    }
}
