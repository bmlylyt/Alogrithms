import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class oneZeroMatrix {
    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return null;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[rows][cols];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (matrix[i][j] == 0) {
                    queue.add(i * cols + j);
                }
            }
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                int cur = queue.poll();
                int curX = cur / rows;
                int curY = cur % cols;
                for (int[] dir : directions) {
                    int nextX = curX + dir[0];
                    int nextY = curY + dir[1];
                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols
                            && matrix[nextX][nextY] == 1 && res[nextX][nextY] == 0) {
                        queue.offer(nextX * cols + nextY);
                        res[nextX][nextY] = minLen;
                    }
                }
                for (int[] i : res) {
                    System.out.println(Arrays.toString(i));
                }
                System.out.println();
            }
            minLen ++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] input = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        int[][] res = updateMatrix(input);
    }
}
