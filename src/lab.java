import java.util.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class lab {
    public static void main(String[] args) {

    }

    public static int[] solution(int D, int[] A) {
       int[] res = new int[A.length];
       for (int i = 0; i < res.length; i ++) {
          int cur = A[i];
          int count = D;
          while (count -- > 1) {
             if (cur == -1) {
                res[i] = -1;
                break;
             }
             cur = A[cur];
          }
          res[i] = cur;
       }
       return res;
    }

}