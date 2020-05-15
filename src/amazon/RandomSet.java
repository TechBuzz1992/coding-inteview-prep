package amazon;

import java.util.*;

public class RandomSet {
    ArrayList<Integer> values = new ArrayList<Integer>();
    HashMap<Integer, Integer> map = new HashMap<>();

    public boolean insert(int x) {
        if (!map.containsKey(x)) {
            values.add(x);
            map.put(x, x);
            return true;
        }

        return false;

    }

    public boolean remove(int x) {
        if (map.containsKey(x)) {
            values.remove(x);
            map.remove(x);
            return true;

        }

        return false;
    }

    public int getRandom() {
        int random = (int) (Math.random() * values.size());
        System.out.println("Random value is:"+random);
        int valueToReturn = values.get(random);
        return map.get(valueToReturn);
    }

    public void printSetValue(){
        System.out.println(Arrays.asList(values));
        System.out.println(map.values());
    }

    public static void main(String[] args) {
        RandomSet set = new RandomSet();
        set.insert(1);
        set.insert(3);
        set.printSetValue();
        System.out.println(set.getRandom());

        set.insert(14);
        set.insert(56);
        set.insert(1);
        set.printSetValue();

        System.out.println(set.getRandom());

        set.remove(1);
        set.remove(45);
        set.printSetValue();

        System.out.println(set.getRandom());
    }

}