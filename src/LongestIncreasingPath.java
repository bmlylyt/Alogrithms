public class LongestIncreasingPath {
   public static int longestIncreasingPath(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
         return 0;
      }
      int rows = matrix.length;
      int cols = matrix[0].length;
      int max = 0;
      for (int i = 0; i < rows; i ++) {
         for (int j = 0; j < cols; j ++) {
//            int temp = dfs(matrix, i, j, 0);
//            System.out.println(temp);
//            max = Math.max(max, temp)
         }
      }
      max = Math.max(max, dfs(matrix, 2, 2, -1));
      return max;
   }
   private static int dfs(int[][] matrix, int i, int j, int prev) {
      if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
              || matrix[i][j] <= prev) {
         return 0;
      }
      int max =  0;
      max = Math.max(max, dfs(matrix, i + 1, j, matrix[i][j]));
      max = Math.max(max, dfs(matrix, i - 1, j, matrix[i][j]));
      max = Math.max(max, dfs(matrix, i, j + 1, matrix[i][j]));
      max = Math.max(max, dfs(matrix, i, j - 1, matrix[i][j]));
      return max + 1;
   }
   public static void main(String[] args) {
      int[][] matrix = {{7, 7, 5}, {2, 4, 6}, {8, 2, 0}};
      System.out.println(longestIncreasingPath(matrix));
   }
}
