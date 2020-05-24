package google;

//import java.util.*;

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
                    count += bfs(nums, i, j);
                    // count++;
                }

            }
        }

        return count;

    }

    public int bfs(int[][] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[i].length || nums[i][j] == 0) {
            return 0;
        }
        nums[i][j] = 0;
        bfs(nums, i + 1, j);
        bfs(nums, i - 1, j);
        bfs(nums, i, j + 1);
        bfs(nums, i, j - 1);

        return 1;

    }

}