import java.util.Arrays;

public class pathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i ++) {
            dp[i][0] = grid[i][0] + grid[i - 1][0];
        }
        for (int i = 1; i < cols; i ++) {
            dp[0][i] = grid[0][i] + grid[0][i - 1];
        }
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        for (int i = 1; i < rows; i ++) {
            for (int j = 1; j < cols; j ++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        return dp[rows - 1][cols - 1];
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        minPathSum(matrix);
    }
}
