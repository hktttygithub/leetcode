package hkttty.leetcode;

public class No130 {
    int row;
    int col;

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length <= 0) {
            return;
        }
        row = board.length - 1;
        col = board[0].length - 1;
        boolean[][] help = new boolean[board.length][board[0].length];
        for (int j = 0; j <= col; j++) {
            findBoard(help, 0, j, board);
            findBoard(help, row, j, board);
        }
        for (int i = 0; i <= row; i++) {
            findBoard(help, i, 0, board);
            findBoard(help, i, col, board);
        }
        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(board[i][j]=='O' && help[i][j]!=true){
                    board[i][j]='X';
                }
            }
        }
    }

    private void findBoard(boolean[][] help, int i, int j, char[][] board) {
        if (i < 0 || i > row || j < 0 || j > col || help[i][j] == true || board[i][j] == 'X') {
            return;
        }
        help[i][j] = true;
        findBoard(help, i + 1, j, board);
        findBoard(help, i - 1, j, board);
        findBoard(help, i, j + 1, board);
        findBoard(help, i, j - 1, board);
    }
}
