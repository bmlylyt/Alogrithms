import java.util.*;
import java.util.ArrayList;

class GraphValidTree {
   private enum Status {
      INITIAL,
      PROCESSING,
      DONE;
   }
   private static class V {
      public int val;
      public List<Integer> next;
      public Status status;
      public V(int val) {
         this.val = val;
         status = Status.INITIAL;
         next = new ArrayList<Integer>();
      }
   }
   public static boolean validTree(int n, int[][] edges) {
      if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) return true;
      Map<V, List<V>> graph = new HashMap<>();
      Set<Integer> set = new HashSet<>();
      V[] array = new V[n];
      for (int i = 0; i < n; i ++) {
         array[i] = new V(i);
      }
      for (int[] each : edges) {
         V prev = array[each[0]];
         V next = array[each[1]];
         if (!graph.containsKey(prev)) {
         }
         graph.get(prev).add(next);
      }
      for (V cur : graph.keySet()) {
         System.out.println(cur.next);
      }
      for (V cur : graph.keySet()) {
         if (cur.next != null) {
            for (Integer each : cur.next) {
               if (!set.add(each)) {
                  return false;
               }
            }
         }
      }
      return true;
   }
   public static void main(String[] args) {
      List<Integer> list1 = new ArrayList<>();
      list1.add(1);list1.add(2);
      List<Integer> list2 = new ArrayList<>();
      list2.add(1);list2.add(2);
      Set<List<Integer>> set = new HashSet<>();
      set.add(list1);
      System.out.println(set.add(list2));
   }
}
