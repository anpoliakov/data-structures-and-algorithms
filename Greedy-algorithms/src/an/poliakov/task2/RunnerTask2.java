package an.poliakov.task2;

/**
 * ЗАДАЧА: Дана общая протяжённость участка, обьём бака авто и растояния до заправок на всём пути,
 * определить наименьшее кол-во остановок для дозаправки авто что бы достичь конца пути.
 *
 *
 * */
public class RunnerTask2 {
    public static void main(String[] args) {
        int [] stations = {0, 200, 375, 550, 750, 950};
        System.out.println(minStops(stations, 400));
    }

    public static int minStops(int [] stations, int tankCapacity){
        int result = 0;                                             // оптимальное кол-во остановок
        int currentStop = 0;                                        // текущая остановка

        while (currentStop < stations.length - 1){
            int nextStop = currentStop;

            // пока не доедем до конца И пока бака хватает до следующей заправки
            while (nextStop < stations.length - 1 && stations[nextStop + 1] - stations[currentStop] <= tankCapacity){
                nextStop++;
            }

            // если невозможно добраться до следующей заправки (невозможно добраться до конца пути)
            if (currentStop == nextStop){
                return -1;
            }

            if (nextStop < stations.length - 1)
                result++;

            currentStop = nextStop;
        }


        return result;
    }
}
