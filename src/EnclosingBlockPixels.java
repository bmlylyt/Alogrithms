public class EnclosingBlockPixels {
   public static int minArea(char[][] image, int x, int y) {
      if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) return 0;
      int rows = image.length;
      int cols = image[0].length;
      int left = 0, right = 0, top = 0, bottom = 0;

      int start = 0;
      int end = y;
      if (start <= end) {
         int mid = start + (end - start) / 2;
         int i = 0;
         for (i = 0; i < rows; i ++) {
            if (image[i][mid] == '1') {
               end = mid - 1;
               break;
            }
         }
         if (i == rows) start = mid + 1;
      }
      left = start;

      start = y;
      end = cols - 1;
      while (start <= end) {
         int mid = start + (end - start) / 2;
         int i = 0;
         for (i = 0; i < rows; i ++) {
            if (image[i][mid] == '1') {
               start = mid + 1;
               break;
            }
         }
         if (i == rows) end = mid - 1;
      }
      right = end;

      start = 0;
      end = x;
      while (start <= end) {
         int mid = start + (end - start) / 2;
         int i = 0;
         for (i = 0; i < cols; i ++) {
            if (image[mid][i] == '1') {
               end = mid - 1;
               break;
            }
         }
         if (i == cols) start = mid + 1;
      }
      top = start;

      start = x;
      end = rows - 1;
      while (start <= end) {
         int mid = start + (end - start) / 2;
         int i = 0;
         for (i = 0; i < cols; i ++) {
            if (image[mid][i] == '1') {
               start = mid + 1;
               break;
            }
         }
         if (i == cols) end = mid - 1;
      }
      bottom = end;

      System.out.print(left + " ");
      System.out.print(right + " ");
      System.out.print(top + " ");
      System.out.println(bottom + " ");
      return (right - left + 1) * (bottom - top + 1);

   }
   public static void main(String[] args) {
      char[][] test = { {'0', '0', '1', '0'},
                        {'0', '1', '1', '0'},
                        {'0', '1', '0', '0'}};
      System.out.println(minArea(test, 0, 2));
   }
}
