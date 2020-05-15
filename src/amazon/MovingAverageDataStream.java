package amazon;

import java.util.*;

public class MovingAverageDataStream {
    private Queue<Integer> queue;
    private int maxSize;
    private double sum;

    public MovingAverageDataStream(int size) {
        queue = new LinkedList<>();
        maxSize = size;
        sum = 0;
    }

    public double next(int x) {

        if (queue.size() == maxSize) {
            sum -= queue.poll();
        }

        queue.offer(x);
        sum += x;

        return sum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverageDataStream a = new MovingAverageDataStream(3);
        System.out.println(a.next(1));
        System.out.println(a.next(2));
        System.out.println(a.next(3));
        System.out.println(a.next(4));
        System.out.println(a.next(5));
        System.out.println(a.next(6));

    }

}