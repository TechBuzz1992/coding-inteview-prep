package coding_patterns.heaps;

import java.util.*;

public class TopKFrequentElements {
    PriorityQueue<Integer> maxHeap;
    Map<Integer, Integer> map;

    TopKFrequentElements() {
        map = new HashMap<Integer, Integer>();
        maxHeap = new PriorityQueue<Integer>((a, b) -> map.get(b).equals(map.get(a)) ? b - a : map.get(b) - map.get(a));
    }

    public void insert(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (maxHeap.contains(val)) {
            maxHeap.remove(val);
            // maxHeap.add(val);
        }
        maxHeap.add(val);

    }

    public List<Integer> getTopKElements(int k) {
        Iterator<Integer> it = maxHeap.iterator();
        List<Integer> ans = new ArrayList<Integer>();
        while (it.hasNext() && k > 0) {
            ans.add(it.next());
            k--;

        }
        return ans;

    }

    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        int k = 3;
        System.out.println(obj.getTopKElements(k));
        obj.insert(4);
        obj.insert(3);
        obj.insert(1);
        obj.insert(1);
        obj.insert(2);
        obj.insert(2);
        System.out.println(obj.getTopKElements(k));

    }

}