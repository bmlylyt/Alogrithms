import java.util.HashMap;
import java.util.Map;

public class UnionFind_Division {
   public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
      if (queries == null || queries.length == 0 || queries[0] == null || queries[0].length == 0) {
         return new double[0];
      }
      UnionFind uf = new UnionFind();
      int lenE = equations.length;
      int lenQ = queries.length;
      Map<String, V> map = new HashMap<>();
      double[] res = new double[lenQ];

      for (int i = 0; i < lenE; i ++) {
         String[] str = equations[i];
         String s1 = str[0];
         String s2 = str[1];
         if (!map.containsKey(s1)) {
            map.put(s1, new V(s1));
         }
         if (!map.containsKey(s2)) {
            map.put(s2, new V(s2));
         }
         V v1 = map.get(s1);
         V v2 = map.get(s2);
         if (uf.find(v1, v2)) {
            uf.union(v1, v2, values[i]);
         }
      }

      for (int i = 0; i < lenQ; i ++) {
         String[] str = queries[i];
         String s1 = str[0];
         String s2 = str[1];
         if (!map.containsKey(s1) || !map.containsKey(s2)) {
            res[i] = -1;
         } else {
            V v1 = map.get(s1);
            V v2 = map.get(s2);
            if (uf.find(v1, v2)) {
               res[i] = uf.division(v1, v2);
            } else {
               res[i] = -1;
            }
         }
      }
      return res;
   }

   static class UnionFind {
      private boolean find(V v1, V v2) {
         return root(v1) == root(v2);
      }

      private void union (V v1, V v2, double d) {
         V root1 = root(v1);
         V root2 = root(v2);
         if (root1.size > root2.size) {
            root2.parent = root1;
            root2.val = v1.val * d / v2.val;
            root1.size += root1.size;
         } else {
            root1.parent = root2;
            root1.val = v2.val / (v1.val * d);
            root2.size += root1.size;
         }
      }

      private V root(V v) {
         V cur = v;
         double d = 1.0;
         while (cur.parent != cur) {
            cur.val *= cur.parent.val;
            d *= cur.val;
            cur.parent = cur.parent.parent;

            cur = cur.parent;
         }
         v.parent = cur;
         v.val = d;

         return cur;
      }

      private double division (V v1, V v2) {
         return v2.val / v1.val;
      }

   }

   static class V {
      public String name;
      public V parent;
      public double val;
      public int size;

      public V (String name) {
         this.name = name;
         this.val = 1.0;
         this.size = 1;
         this.parent = this;
      }
   }
   public static void main(String[] args) {
      String[][] equations = { {"a", "b"}, {"b", "c"} };
      double[] values = {2.0, 3.0};
      String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
      double[] res = UnionFind_Division.calcEquation(equations, values, queries);
      for (double i : res) {
         System.out.println(i);
      }
   }
}
