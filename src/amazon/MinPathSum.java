package amazon;

public class MinPathSum {
    public static void main(String[] args) {

    }

    public int getMinPathSum(int[][] grid) {
       // int min = Integer.MAX_VALUE;

        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i - 1] += grid[0][i - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

}