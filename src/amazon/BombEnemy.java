//Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
// The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
// Note that you can only put the bomb at an empty cell.

// Example:
// For the given grid

// 0 E 0 0
// E 0 W E
// 0 E 0 0

// return 3. (Placing a bomb at (1,1) kills 3 enemies)

package amazon;

public class BombEnemy {
    public static void main(String[] args) {
        char[][] grid = {
            {'0','E','0','0'},
            {'E','0','W','E'},
            {'0','E','0','0'}
        };

        int max = new BombEnemy().maxEnemiesKill(grid);

        System.out.println(max);

    }

    public int maxEnemiesKill(char[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'W') {
                    continue;
                }

                int row = killEnemiesRow(grid, i, j);
                int col = killEnemiesCol(grid, i, j);

                max = (row + col > max) ? row + col : max;
            }

        }

        return max;
    }

    public int killEnemiesRow(char[][] grid, int i, int j) {
        int num = 0;
        while (j <= grid[i].length - 1 && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') {
                num++;
            }
            j++;
        }

        return num;
    }

    public int killEnemiesCol(char[][] grid, int i, int j) {
        int num = 0;
        while (i <= grid.length - 1 && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') {
                num++;
            }
            i++;
        }

        return num;

    }

}