package amazon;

public class BattleshipsInABoard {

    public static void main(String[] args) {
        char[][] board = {{'x','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        
        BattleshipsInABoard instance = new BattleshipsInABoard();
        int ships = instance.countBattleShips(board);

        System.out.println("Number of ships: "+ships);
    }

    public int countBattleShips(char[][] board) {
        int ships = 0;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'X'){
                    ships++;
                    sink(board,i,j,ships);
                }
            }
        }

        return ships;

    }

    public void sink(char[][] board, int i, int j,int ships) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X') {
            return;
        }

        board[i][j] = '.';

        sink(board,i+1,j,ships+1);
        sink(board,i,j+1,ships+1);
    }

}