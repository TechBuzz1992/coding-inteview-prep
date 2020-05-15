package amazon;

import java.util.*;

public class KthLargestElement {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7,8,9,11,12,13,14};
        System.out.println(getKLargestElement(nums, 5));
        
    }

    public static int getKLargestElement(int [] nums, int K){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
            if(minHeap.size() > K){
                minHeap.remove();
            }
        }

        return minHeap.remove();
    }
    
}