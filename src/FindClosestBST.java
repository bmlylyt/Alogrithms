import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindClosestBST {
    public static void main(String[] args) {
        double num = 3.7;
        Queue<Integer> heap = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double res = Math.abs(num - o1) - Math.abs(num - o2);
                return o2 - o1 > 0 ? 1 : -1;
            }
        });
//        int n = 10;
//        while (n > 0) {
//            if (heap.size() < 3) {
//                heap.offer(n);
//            } else {
//                System.out.println(heap.peek());
//                if (Math.abs(n - num) < Math.abs(heap.peek() - num)) {
//                    heap.poll();
//                    heap.offer(n);
//                }
//            }
//            n --;
//        }
        heap.offer(1);heap.offer(10);heap.offer(5); heap.offer(7);
        while (heap.size() != 0) {
            System.out.println(heap.poll());
        }
    }
}
