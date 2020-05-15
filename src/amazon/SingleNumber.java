package amazon;

import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3};
        System.out.println(new SingleNumber().singleNumber(nums));
        
    }

    public int singleNumber(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i : map.keySet()){
            if(map.get(i) == 1){
                return i;
            }
        }

        return -1;

    }
    
}