package an.poliakov.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RunnerQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("Сравниваю " + o1 + " и " + o2 + ", где o1 - " + o1 % 2 + ", и о2 - " + o2 % 2);
                int val = 0;

                if(o1 % 2 == 0 && o2 % 2 == 0){
                    val =  o1 - o2;
                }

                if(o1 % 2 != 0 && o2 % 2 != 0){
                    val =  o1 - o2;
                }

                if(o1 % 2 == 0 && o2 % 2 != 0){
                    val =  -1;
                }

                if(o1 % 2 != 0 && o2 % 2 == 0){
                    val =  1;
                }

                // OR JUST (o1 % 2) - (o2 % 2) == 0 ? (o1 - o2) : (o1 % 2) - (o2 % 2);

                return val;
            }
        });


        q.add(5);
        q.add(2);
        q.add(1);
        q.add(4);

        while (!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
