package google;

import java.util.*;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,5};
        int k = 3;
        ContainsDuplicateII obj = new ContainsDuplicateII();
        System.out.println(obj.containsDuplicate(nums, k));

    }

    public boolean containsDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;

    }

}