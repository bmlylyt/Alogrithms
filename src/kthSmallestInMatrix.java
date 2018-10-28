import java.util.*;

public class kthSmallestInMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) throw new IllegalArgumentException();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2) {
                return n2 - n1;
            }
        });
        int[][] directions = {{0, 1}, {1, 0}};
        queue.offer(0);
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / cols;
            int j = cur % cols;
            if (heap.size() < k) {
                heap.offer(matrix[i][j]);
            } else {
                if (matrix[i][j] <= heap.peek()) {
                    heap.poll();
                    heap.offer(matrix[i][j]);
                }
            }
            for (int[] dir : directions) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols && visited[nextI][nextJ] == false) {
                    queue.offer(nextI * cols + nextJ);
                    visited[nextI][nextJ] = true;
                }
            }
        }
        while (heap.size() != 0){
            System.out.println(heap.poll());
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 3, 5}, {6, 7, 12}, {11, 14, 14}};
        int res = kthSmallestInMatrix.kthSmallest(test, 6);
        int[] array = {0, 1, 2, 3, 4};



        /* System.out.println(res); */
    }
}
