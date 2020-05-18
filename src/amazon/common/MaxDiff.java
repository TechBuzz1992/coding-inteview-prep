package amazon.common;

public class MaxDiff {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8};
        int[] nums2 = {9,8,7,6,5,4,3,2,1};
        int[] nums3 = {1,1,1,1,1,1,1};
        int[] nums4 = {1,2,3,8,4,9,0,0};

        System.out.println(getMaxDiff(nums1));
        System.out.println(getMaxDiff(nums2));
        System.out.println(getMaxDiff(nums3));
        System.out.println(getMaxDiff(nums4));       
    }

    public static int getMaxDiff(int[] nums){
        int start = 0;
        int end = nums.length-1;

        //int max = 0;
        while(start<end){
            end = nums.length-1;
            while(start<end){
                if(nums[end]>nums[start]){
                    return end-start;
                }
                end--;

            }
            start++;
        }

        return -1;
    }
    
}