package coding_patterns;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        System.out.println(obj.getSlidingWindowMax(nums, k));

    }

    public List<Integer> getSlidingWindowMax(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            System.out.println(maxHeap.toString());
            if (maxHeap.size() == k) {
                ans.add(maxHeap.peek());
            }
            else if (maxHeap.size() > k) {
                maxHeap.remove(nums[i - k]);
                ans.add(maxHeap.peek());
            }
            // System.out.println(minHeap.toString());

        }

        return ans;

    }

}