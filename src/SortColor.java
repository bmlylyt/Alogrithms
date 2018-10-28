import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SortColor {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) count0 ++;
            if (nums[i] == 1) count1 ++;
            if (nums[i] == 2) count2 ++;
        }
        System.out.println(count0 + " " + count1 + " "  + count2);
        for (int i = 0; i < nums.length; i ++) {
            if (count0 -- > 0) {
                nums[i] = 0;
            } else if (count1 -- > 0) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
        return;
    }
    private static void sortFour(int[] nums, int start, int end) {
        if (start > end) return;

        int pivot = partition(nums, start, end);
        sortFour(nums, start, pivot - 1);
        sortFour(nums, pivot + 1, end);
    }
    private static int partition(int[] nums, int start, int end) {
        Random rand = new Random();
        int left = start, right = end - 1;
        int pivot = start + rand.nextInt(end - start + 1);
        swap(nums, pivot, end);
        int pivotNum = nums[end];
        while (left <= right) {
            if (nums[left] <= pivotNum) {
                left ++;
            } else if (nums[right] > pivotNum) {
                right --;
            } else {
                swap(nums, left ++, right --);
            }
        }
        swap(nums, left, end);
        System.out.println(pivotNum + " --> " + Arrays.toString(nums));
        System.out.println("");
        return left;
    }
    private static void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {


    }
}
