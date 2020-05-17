package amazon;

import java.util.*;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int size;

    LRUCache(int capacity) {
        this.map = new LinkedHashMap<>();
        this.size = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.remove(key);
            map.put(key, value);
            return value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);

        } else if (map.size() + 1 > size) {
            map.remove(map.keySet().iterator().next());
        }

        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2,2);
        System.out.println(cache.map.values());
        cache.put(3,3);
        System.out.println(cache.map.values());
        cache.put(1,1);
        System.out.println(cache.map.values());
        cache.put(4,4);
        System.out.println(cache.map.values());
    }

}