import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class GraphAlienDic {
   private static int curLen = 0;
   private enum Status {
      INITAL,
      PROCESSING,
      DONE;
   }
   private static class V {
      public char c;
      public List<V> next;
      public Status status;
      public V(char c) {
         this.c = c;
         next = new ArrayList<>();
         status = Status.INITAL;
      }

      @Override
      public String toString() {
         return String.valueOf(c);
      }
   }
   public static String alienOrder(String[] words) {
      if (words == null) return "";
      if (words.length == 1) return words[0];

      V[] graph = new V[26];
      List<V> vs = new ArrayList<>();
      String prev = words[0];
      for (int i = 0; i < words.length; i ++) {
         String cur = words[i];
         boolean isValid = false;
         int idx1 = 0;
         int idx2 = 0;
         while (idx1 < prev.length() && idx2 < cur.length()) {
            char c1 = prev.charAt(idx1 ++);
            char c2 = cur.charAt(idx2 ++);
            if (graph[c1 - 'a'] == null) {
               graph[c1 - 'a'] = new V(c1);
               vs.add(graph[c1 - 'a']);
            }
            if (graph[c2 - 'a'] == null) {
               graph[c2 - 'a'] = new V(c2);
               vs.add(graph[c2 - 'a']);
            }
            if (c1 != c2) {
               graph[c1 - 'a'].next.add(graph[c2 - 'a']);
               isValid = true;
               break;
            }
         }
         while (idx1 < prev.length()) {
            if (!isValid) return "";

            char c1 = prev.charAt(idx1 ++);
            if (graph[c1 - 'a'] == null) {
               graph[c1 - 'a'] = new V(c1);
               vs.add(graph[c1 - 'a']);
            }
         }
         while (idx2 < cur.length()) {
            char c2 = cur.charAt(idx2 ++);
            if (graph[c2 - 'a'] == null) {
               graph[c2 - 'a'] = new V(c2);
               vs.add(graph[c2 - 'a']);
            }
         }

         prev = cur;
      }
      for (V v : vs) {
         System.out.println(v.c + " --> " + Arrays.toString(graph[v.c - 'a'].next.toArray()));
      }
      char[] res = new char[vs.size()];
      curLen = res.length - 1;
      for (V v : vs) {
         if (dfs(v, res)) {
            return "";
         }
      }
      return new String(res);
   }
   private static boolean dfs(V v, char[] res) {
      if (v.status == Status.PROCESSING) return true;
      if (v.status == Status.DONE) return false;

      v.status = Status.PROCESSING;
      for (V cur : v.next) {
         if(dfs(cur, res)) return true;
      }
      v.status = Status.DONE;
      res[curLen --] = v.c;
      return false;
   }
   public static void main(String[] args) {
      String[] input = {"z","x","z"};
      System.out.println(alienOrder(input));
   }

}

