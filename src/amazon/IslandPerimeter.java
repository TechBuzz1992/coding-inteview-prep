
// You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

// Example:

// [[0,1,0,0],••••••••••
//  [1,1,1,0],••••••••••
//  [0,1,0,0],
//  [1,1,0,0]]••••••••••
// Answer: 16••••••••••

package amazon;

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}};

        System.out.println("The perimeter is: "+new IslandPerimeter().isLandPerimeter(grid));

    }

    public int isLandPerimeter(int[][] grid) {
        int perimeter = 0;

        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += dfs(grid, i, j);
                    return perimeter;
                }
            }
        }

        return perimeter;

    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length | j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 1;
        }

        if (grid[i][j] == -1) {
            return 0;
        }

        grid[i][j] = -1;

        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);

    }

}