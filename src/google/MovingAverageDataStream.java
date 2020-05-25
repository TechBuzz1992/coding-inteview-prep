package google;

import java.util.*;

public class MovingAverageDataStream {
    Queue<Integer> queue;
    int max;
    double sum;

    MovingAverageDataStream(int size) {
        this.queue = new LinkedList<Integer>();
        this.max = size;
        this.sum = 0.0;
    }

    public double next(int val) {
        if (queue.size() == max) {
            sum -= queue.remove();
        }
        queue.add(val);
        sum += val;
        return sum / queue.size();
    }

}