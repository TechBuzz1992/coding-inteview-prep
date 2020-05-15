package amazon;

//import java.util.*;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(new TrappingRainWater().getTrappedWater(heights));

    }

    public int getTrappedWater(int[] heights) {
        
        int water = 0;
        
        int left = 0;
        int right = heights.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;

        while(left<=right){
            leftMax = Math.max(leftMax, heights[left]);
            rightMax = Math.max(rightMax, heights[right]);

            if(leftMax < rightMax){
                water += leftMax - heights[left];
                left++;
            }
            else{
                water += rightMax - heights[right];
                right--;
            }
        }
        return water;
    }

}