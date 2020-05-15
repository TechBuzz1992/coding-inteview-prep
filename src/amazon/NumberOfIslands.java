package amazon;

public class NumberOfIslands {
    public static void main(String[] args) {

    }

    public int noOfIslands(int[][] grid) {

        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                islands += dfs(grid, i, j);
            }
        }

        return islands;

    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length || j < 0 || j > grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 1;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        return 1;
    }

}