package google;

import java.util.*;

public class NoOfIslands {
    public static void main(String[] args) {
        int[][] nums = {
            {1,0,0,1},
            {0,1,0,0},
            {1,0,0,1}
        };

        NoOfIslands obj = new NoOfIslands();
        System.out.println(obj.noOfIslands(nums));

    }

    public int noOfIslands(int[][] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 1) {
                    count += dfs(nums, i, j);
                    // count++;
                }

            }
        }

        return count;

    }

    public int dfs(int[][] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[i].length || nums[i][j] == 0) {
            return 0;
        }
        nums[i][j] = 0;
        dfs(nums, i + 1, j);
        dfs(nums, i - 1, j);
        dfs(nums, i, j + 1);
        dfs(nums, i, j - 1);

        return 1;

    }

}