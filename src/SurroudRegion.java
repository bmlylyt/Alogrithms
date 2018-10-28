import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroudRegion {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        Queue<Integer> queue = new LinkedList<>();
        findEdgeZero(board, queue);
        removeEdge(board, queue);
        findZero(board, queue);
        int cols = board[0].length;
        int rows = board.length;
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / cols;
            int j = cur % cols;
            board[i][j] = 'X';
            for (int[] dir : directions) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols && board[nextI][nextJ] == 'O') {
                    queue.add(nextI * cols + nextJ);
                }
            }
        }
        recover(board);

    }
    private static void findEdgeZero(char[][] board, Queue<Integer> queue) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < cols - 1; i ++){
            if (board[0][i] == 'O') queue.add(0 * cols + i);
        }
        for (int i = 0; i < rows - 1; i ++) {
            if (board[i][cols - 1] == 'O') queue.add(i * cols + cols - 1);
        }
        for (int i = 0; i < cols - 1; i ++) {
            if (board[rows - 1][cols - 1 - i] == 'O') queue.add((rows - 1) * cols + cols- 1 - i);
        }
        for (int i = 0; i < rows - 1; i ++) {
            if (board[rows - 1 - i][0] == 'O') queue.add((rows - 1 - i) * cols + 0);
        }
    }
    private static void removeEdge(char[][] board, Queue<Integer> queue) {
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int cols = board[0].length;
        int rows = board.length;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / cols;
            int j = cur % cols;
            board[i][j] = '.';
            for (int[] dir : directions) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols && board[nextI][nextJ] == 'O') {
                    queue.add(nextI * cols + nextJ);
                }
            }
        }
        for (char[] a : board) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("");
    }
    private static void findZero(char[][] board, Queue<Integer> queue) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == 'O') queue.add(i * board[0].length + j);
            }
        }
    }
    private static void recover(char[][] board) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == '.') board[i][j] = 'O';
            }
        }
        for (char[] a : board) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        char[][] matrix1 = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };

        char[][] matrix2 = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        solve(matrix2);
    }
}
