import java.util.*;
import java.util.ArrayList;

public class KPairSmallestSum {
   public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<int[]> res = new ArrayList<>();
      int rows = nums1.length;
      int cols = nums2.length;
      int[][] matrix = new int[rows][cols];
      for (int i = 0; i < rows; i ++) {
         for (int j = 0; j < cols; j ++) {
            matrix[i][j] = nums1[i] + nums2[j];
         }
      }
      for (int i = 0; i < rows; i ++) {
         System.out.println(Arrays.toString(matrix[i]));
      }
      Queue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
         @Override
         public int compare(Integer index1, Integer index2) {
            return matrix[index1 / cols][index1 % cols] - matrix[index2 / cols][index2 % cols];
         }
      });
      Set<Integer> visited = new HashSet<>();
      visited.add(0);
      minHeap.offer(0);
      while (k -- > 0) {
         if (minHeap.isEmpty()) break;
         int cur = minHeap.poll();
         int curX = cur / cols;
         int curY = cur % cols;
         res.add(new int[]{nums1[curX], nums2[curY]});
         int below = (curX + 1) * cols + curY;
         int right = curX * cols + curY + 1;
         if (curX + 1 < rows && !visited.add(below)) {
            minHeap.offer(below);
         }
         if (curY + 1 < cols && !visited.add(right)) {
            minHeap.offer(right);
         }
      }
      return res;
   }
   public static void main(String[] args) {
      int n = 4;
      System.out.println(n >>> 1);
   }
}
