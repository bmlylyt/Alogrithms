public class GameOfLife {
   public static void gameOfLife(int[][] board) {
      if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;

      int rows = board.length, cols = board[0].length;
      int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
      int[][] newBoard = new int[rows][cols];
      for (int i = 0; i < rows; i ++) {
         for (int j = 0; j < cols; j ++) {
            int count = 0;
            for (int[] dir : directions) {
               int nextX = i + dir[0];
               int nextY = j + dir[1];
               if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols) {
                  if (board[nextX][nextY] == 1) {
                     count++;
                  }
               }
            }
            if (board[i][j] == 0) {
               if (count == 3) newBoard[i][j] = 1;
            } else {
               if (count > 3 || count < 2) newBoard[i][j] = 0;
               if (count == 3) {
                  System.out.println(i + " " + j);
                  System.out.println(newBoard[i][j]);
               }
            }
         }
      }
      for (int i = 0; i < rows; i ++) {
         for (int j = 0; j < cols; j ++) {
            board[i][j] = newBoard[i][j];
         }
      }
   }
   public static void main(String[] args) {
      int[][] input = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
      gameOfLife(input);
   }
}
