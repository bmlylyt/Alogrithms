import java.util.*;
import java.util.ArrayList;

public class ShortestDistanceFromBuilding {
    public static int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] res = new int[rows][cols];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (grid[i][j] == 1) {
                    bfs(grid, res, queue, i, j);
                }
            }
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (grid[i][j] == 0 && res[i][j] == 0) {
                    return -1;
                }
                if (grid[i][j] == 0) {
                    minLen = Math.min(minLen, res[i][j]);
                }
            }
        }
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
    private static void bfs(int[][] grid, int[][] res, Queue<Integer> queue, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        queue.add(i * cols + j);
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                int cur = queue.poll();
                int curX = cur / cols;
                int curY = cur % cols;
                for (int[] dir : directions) {
                    int nextX = curX + dir[0];
                    int nextY = curY + dir[1];
                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols
                            && grid[nextX][nextY] == 0 && visited[nextX][nextY] == false) {
                        visited[nextX][nextY] = true;
                        res[nextX][nextY] += minLen;
                        queue.offer(nextX * cols + nextY);
                    }
                }
            }
            minLen ++;
        }
    }
    public static void main(String[] args) {

    }
}
class Student {
    public int name;
    public Student(int name) {
        name = name;
    }
}
