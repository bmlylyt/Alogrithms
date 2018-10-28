public class QuickSelection {
   public static void main(String[] args) {
      int[] array = {3, 3, 2, 4, 5, 9, 7};
      int res = findKth(array, 0, array.length - 1, 2);
      System.out.println(res);

   }

   public static int findKth(int[] nums, int start, int end, int k) {
      if (nums[start] == nums[end]) {
         return nums[start];
      }
      int q = partition(nums, start, end);
      int rank = q - start + 1;
      if (rank == k) {
         return nums[q];
      } else if (rank < k) {
         return findKth(nums, q + 1, end, k - rank);
      } else {
         return findKth(nums, start, q - 1, k);
      }
   }
   public static int partition(int[] nums, int start, int end) {
      int pivot = nums[end];
      int left = start - 1;
      for (int i = 0; i < end; i ++) {
         if (nums[i] < pivot) {
            swap(nums, i, ++ left);
         }
      }
      swap(nums, ++ left, end);
      return left;
   }
   public static void swap(int[] nums, int left, int right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
   }
}
