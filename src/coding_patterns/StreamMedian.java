package coding_patterns;

import java.util.*;

public class StreamMedian {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    StreamMedian() {
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
    }

    public void insert(int x) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= x) {
            maxHeap.add(x);
        } else {
            minHeap.add(x);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());

        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());

        }

    }

    public int getMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        

    }

}