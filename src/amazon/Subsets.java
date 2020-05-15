package amazon;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = getSubsets(nums);
        for(List<Integer> subset : subsets){
            System.out.println(subset);
        }
        
    }

    public static List<List<Integer>> getSubsets(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubSets(0, nums,new ArrayList<Integer>(), subsets);
        return subsets;

    }

    public static void generateSubSets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets){

        subsets.add(new ArrayList<Integer>(current));
        for(int i = index;i<nums.length;i++){
            current.add(nums[i]);
            generateSubSets(i+1, nums, current, subsets);
            current.remove(current.size()-1);
        }
    }
    
}