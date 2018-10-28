import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Solution {
    //SelectionSort
    public static int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) return array;
        for (int i = 0; i < array.length; i ++) {
            int minIndex = i;
            for (int j = i; j < array.length; j ++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
        return array;
    }
    public static void swap(int[] array, int minIndex, int j) {
        int temp = array[minIndex];
        array[minIndex] = array[j];
        array[j] = temp;
    }

    /* ********************* MergeSort *********************** */

    public static void mergeSort(int[] array) {
        if (array == null || array.length == 0) return;
        int[] cache = array.clone();
        divideAndMerge(array, cache, 0, array.length - 1);
        return;
    }
    public static void divideAndMerge(int[] array, int[] cache, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        divideAndMerge(array, cache, left, mid);
        divideAndMerge(array, cache, mid + 1, right);
        merge(array, cache, left, right, mid);
        copyArray(array, cache, right);
    }
    public static void merge(int[] array, int[] cache, int left, int end, int mid) {
        int leftStart = left;
        int rightStart = mid + 1;
        for (int i = leftStart; i <= end; i ++) {
            if (leftStart > mid) array[i] = cache[rightStart++];
            else if (rightStart > end) array[i] = cache[leftStart++];
            else if (cache[leftStart] > cache[rightStart]) array[i] = cache[rightStart++];
            else array[i] = cache[leftStart++];
        }
    }
    public static void copyArray(int[] array, int[] cache, int n) {
        for (int i = 0; i <= n; i ++) {
            cache[i] = array[i];
        }
    }

    /* ************************ MergeSort ********************** */
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> array) {
        if (array == null || array.size() <=1) return array;
        return divideAndMerge(array, 0, array.size() - 1);
    }
    public static ArrayList<Integer> divideAndMerge(List<Integer> array, int start, int end) {
        ArrayList<Integer> res = new ArrayList<>();
        if (start == end) {
            res.add(array.get(start));
            return res;
        }
        int mid = start + (end - start) / 2;
        ArrayList<Integer> leftResult = divideAndMerge(array, start, mid);
        ArrayList<Integer> rightResult = divideAndMerge(array, mid + 1, end);
        return merge(leftResult, rightResult);
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> leftResult, ArrayList<Integer> rightResult) {
        ArrayList<Integer> result = new ArrayList<>();
        int p = 0, q = 0;
        while (p < leftResult.size() && q < rightResult.size()) {
            if (leftResult.get(p) < rightResult.get(q)) {
                result.add(leftResult.get(p ++));
            } else {
                result.add(rightResult.get(q ++));
            }
        }
        while (q < rightResult.size()) {
            result.add(rightResult.get(q ++));
        }
        while (p < leftResult.size()) {
            result.add(leftResult.get(p ++));
        }
        return result;
    }

    /* **********************  QuickSort ************************  */
    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) return;

        sort(array, 0, array.length - 1);
        return;
    }
    public static void sort(int[] array, int start, int end) {
        if (start >= end) return;

        int pivot = partition(array, start, end);
        sort(array, start, pivot - 1);
        sort(array, pivot + 1, end);
        return;
    }
    public static int partition(int[] array, int start, int end) {
        Random ran = new Random();
        int ranNum = start + ran.nextInt(end - start + 1);
        int pivot = array[ranNum];
        swap(array, ranNum, end);
        int left = start, right = end - 1;
        while (left <= right) {
            if (array[left] <= pivot) {
                left ++;
            } else if (array[right] > pivot) {
                right --;
            } else {
                swap(array, left ++, right --);
            }
        }
        swap(array, left, end);
        System.out.println(Arrays.toString(array) + " -- " + pivot + " -- " + ranNum);
        return left;
    }
    public static void main(String[] args) {
        int[] test = {3, 4, 1, 2, 7, 6, 5};
        Solution.quickSort(test);
        System.out.println(Arrays.toString(test));

    }
}

