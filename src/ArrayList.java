import java.util.Arrays;
import java.util.Scanner;

public class ArrayList {
    private int[] nums;
    private int size;

    public ArrayList() {
        nums = new int[2];
        size = 0;
    }
    public void add(int value) {
        if (size == nums.length) {
            int[] newArray = new int[nums.length * 2];
            newArray = Arrays.copyOf(nums, nums.length * 2);
            nums = newArray;
        }
        nums[size ++] = value;
    }
    public int get(int i) {
        return nums[i];
    }
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (int i = 0; i < list.size; i ++) {
            System.out.println(list.get(i));
        }
       System.out.println(Integer.MAX_VALUE);
    }
}
