package by.andrew.bubbleSort;

public class Runner {

    public static void main(String[] args) {
        int [] mas = new int[]{1,2,3,4,6,5,8,7,7,9};
        //startBubbleSort(mas);
        //startShakerSort(mas);

        startCombSort(mas);
        showMas(mas);
    }
    

    // стандартная сортировка пузырьком
    //TODO: что бы часть массива (отсортированного) не перебиралось, хранить точку в массиве с которой пересматриваю элементы
    public static void startBubbleSort(int [] mas){
        for(int i = 0; i < mas.length; i++){
            for(int j = 0; j < mas.length - 1 - i; j++){
                if(mas[j] > mas[j+1]){
                    int temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                }
            }
        }
        showMas(mas);
    }


    //шейкерная сортировка (более быстрый аналог пузырьковой)
    public static void startShakerSort(int [] mas){
        int leftIndex = 0;
        int rightIndex = mas.length - 1;

        while (leftIndex <= rightIndex){
            //тяжёлые элементы в конец
            for(int i = leftIndex; i < rightIndex; i++){
                if(mas[i] > mas[i + 1]){
                    int temp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = temp;
                }
            }
            rightIndex --;

            //лёгкие элементы в начало
            for(int j = rightIndex; j > leftIndex; j--){
                if(mas[j] < mas[j - 1]){
                    int temp = mas[j];
                    mas[j] = mas[j - 1];
                    mas[j - 1] = temp;
                }
            }
            leftIndex ++;
        }
        showMas(mas);
    }



    /* раз у нас большие элементы могут тормозить весь процесс, то можно их перекидывать
     не на соседнее место, а подальше. Так мы уменьшим количество перестановок,
     а с ними сэкономим и процессорное время, нужное на их обработку https://thecode.media/comb-sort/ */

    //сортировка расчёской (ещё более быстрый вариант)
    public static void startCombSort(int [] mas){
        int gap = mas.length; //инициализируем шаг между сравн. знач
        boolean swapped = true;

        while (gap != 1 || swapped == true){
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < mas.length - gap; i++) {
                if (mas[i] > mas[i + gap]) {
                    int temp = mas[i];
                    mas[i] = mas[i + gap];
                    mas[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    //метод для получения шага между проверяемыми элементами (сортировка расчёской)
    public static int getNextGap(int gap){
        gap = (gap * 10)/13;
        int temp;

            if(gap < 1){
                temp = 1;
            }else {
                temp = gap;
            }

        return temp;
    }

    public static void showMas(int [] mas){
        System.out.print("MAS: [ ");
        for (int n : mas){
            System.out.print(n + " ");
        }
        System.out.print("];");
    }
}



