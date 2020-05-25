package google;

import java.util.*;

public class FindNumberDisappered {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,8,9};
        FindNumberDisappered obj = new FindNumberDisappered();
        System.out.println(obj.getMissingNumbers(nums));

    }

    public List<Integer> getMissingNumbers(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> ans = new ArrayList<Integer>();

        for (int i : nums) {
            if (i <= min) {
                min = i;
            }
            if (i >= max) {
                max = i;
            }
            set.add(i);

        }

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }

        }

        return ans;

    }

}