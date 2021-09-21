package by.andrew.bubbleSort;

public class Runner {

    public static void main(String[] args) {
        int [] mas = new int[]{4,1,3,5,2,0,9,6,7,8};
        startBubbleSort(mas);
    }

    // стандартная сортировка пузырьком
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

    public static void showMas(int [] mas){
        System.out.print("MAS: [ ");
        for (int n : mas){
            System.out.print(n + " ");
        }
        System.out.print("];");
    }
}
