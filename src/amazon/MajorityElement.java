package amazon;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 4 };
        System.out.println(new MajorityElement().majorityElement(nums));

    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i) && map.get(i) + 1 > nums.length / 2) {
                return i;
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);

            }
        }
        return -1;

    }

}