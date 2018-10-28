import java.util.List;

public class kthSmallestTwoArray {
    public static int kthSmallest(int[] arr1, int[] arr2, int k) {
        int len = arr1.length;
        return kthSmallestTwoArray(arr1, 0, arr2, 0, k);
    }
    private static int kthSmallestTwoArray (int[] arr1, int aleft, int[] arr2, int bleft, int k) {
        if (k == 1) {
            return arr1[aleft] > arr2[bleft] ? arr2[bleft] : arr1[aleft];
        }
        int midA = arr1[aleft + k / 2 - 1];
        int midB = arr2[bleft + k / 2 - 1];
        if (midA < midB) {
            return kthSmallestTwoArray(arr1, aleft + k / 2, arr2, bleft, k - k / 2);
        } else {
            return kthSmallestTwoArray(arr1, aleft, arr2, bleft + k / 2, k - k / 2);
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 13};
        int[] arr2 = {7, 8, 9, 10, 11, 12,15};
        System.out.println(kthSmallest(arr1, arr2, 6));
    }
}
