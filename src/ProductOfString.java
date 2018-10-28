import java.util.*;

public class ProductOfString {
    public static int maxProduct(String[] words) {
        if (words == null || words.length <= 1) return 0;
        int cols = words.length;
        Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return words[o2 / cols].length() * words[o2 % cols].length() - words[o1 / cols].length() * words[o2 % cols].length();
            }
        });
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        int[][] directions = {{0, 1}, {1, 0}};
        int max = 0;
        maxHeap.offer(0 * cols + 1);
        while (!maxHeap.isEmpty()) {
            int cur = maxHeap.poll();
            int curX = cur / cols;
            int curY = cur % cols;
            if (noCommon(words[curX], words[curY])) {
                max = Math.max(max, words[curX].length() * words[curY].length());
            }
            for (int[] dir : directions) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];
                if (nextX >= 0 && nextX < cols && nextY >= 0 && nextY < cols && nextX != nextY) {
                    maxHeap.offer(nextX * cols + nextY);
                }
            }
        }
        return max;
    }
    private static boolean noCommon(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        if (s1.length() < s2.length()) {
            for (Character c : s1.toCharArray()) {
                set.add(c);
            }
            for (Character c : s2.toCharArray()) {
                if (set.contains(c)) return false;
            }
        } else {
            for (Character c : s2.toCharArray()) {
                set.add(c);
            }
            for (Character c : s1.toCharArray()) {
                if (set.contains(c)) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        List<Integer> list1 = new ArrayList(Arrays.asList(array));
        List<Integer> list2 = new ArrayList(Arrays.asList(array));
        System.out.println();
    }
}
