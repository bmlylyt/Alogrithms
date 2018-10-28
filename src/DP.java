import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class DP {
        public static boolean canJump(int[] nums) {
            if (nums == null || nums.length <= 1) return true;
            int len = nums.length;
            boolean[] dp = new boolean[len];
            dp[len - 1] = true;
            for (int i = len - 2; i >= 0; i --) {
                for (int j = 1; j <= nums[i]; j ++) {
                    if (i + j < len && dp[i + j] == true ) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(dp));
            return dp[0];
        }
   public static int minimumTotal(List<List<Integer>> triangle) {
      if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) {
         return 0;
      }
      int rows = triangle.size();
      int cols = triangle.get(rows - 1).size();
      int[][] dp = new int[rows][cols];
      for (int i = 0; i < cols; i ++) {
         dp[rows - 1][i] = triangle.get(rows - 1).get(i);
      }
      for (int i = rows - 2; i >= 0; i --) {
         for (int j = 0; j <= i; j ++) {
            dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
         }
      }
      for (int[] a : dp) {
         System.out.println(Arrays.toString(a));
      }
      return dp[0][0];
   }

        public static void main(String[] args) {
            List<List<Integer>> input = new ArrayList<>();
            input.add(new ArrayList<>(Arrays.asList(2)));
           input.add(new ArrayList<>(Arrays.asList(3, 4)));
           input.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
           input.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
           System.out.println(input);
           System.out.println(minimumTotal(input));
        }

}
