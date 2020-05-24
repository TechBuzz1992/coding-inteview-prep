package google;

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate obj = new ContainsDuplicate();
        int[] nums = { 1, 2, 3, 1 };
        System.out.println("Contains duplicate? : " + obj.containsDuplicate(nums));

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }

        return false;
    }

}