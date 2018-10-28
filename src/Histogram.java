import java.util.Arrays;

public class Histogram {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = -1;
        right[right.length - 1] = len;

        for (int i = 1; i < len; i ++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = left[p];
            }
            left[i] = p;
        }
        System.out.println(Arrays.toString(left));
        for (int i = len - 2; i >= 0; i --) {
            int p = i + 1;
            while (p <= len - 1 && heights[p] >= heights[i]) {
                p = right[p];
            }
            right[i] = p;
        }
        System.out.println(Arrays.toString(right));
        int max = 0;
        for (int i = 0; i < len; i ++) {
            Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
    public static void main(String[] args) {
        int num1 = 127;
        Integer num2 = 127;
        System.out.println(num1 == num2);
    }
}
