package google;

import java.util.*;

public class PeakElement {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 2, 3, 1, 1, 1, 4, 5, 1, 2, 3 };
        PeakElement obj = new PeakElement();
        System.out.println(obj.getPeakElement(nums));

    }

    public int getPeakElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > nums.length / 2) {
                return i;
            }

        }

        return -1;

    }

}