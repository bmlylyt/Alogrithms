import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        for (char[] a : grid){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("");

        int rows = grid.length;
        int cols = grid[0].length;
        int islandNum = 0;
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (grid[i][j] == '1') {
                    islandNum ++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * cols + j);
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        int curI = cur / cols;
                        int curJ = cur % cols;
                        grid[curI][curJ] = '0';
                        for (int[] dir : directions) {
                            int nextI = curI + dir[0];
                            int nextJ = curJ + dir[1];
                            if (nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols && grid[nextI][nextJ] == '1') {
                                queue.offer(nextI * cols + nextJ);
                            }
                        }
                    }
                }
            }
        }
        for (char[] a : grid){
            System.out.println(Arrays.toString(a));
        }
        return islandNum;
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid2));
    }
}
