import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
        public static List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            if (n == 0) return res;
            char[][] sol = new char[n][n];
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    sol[i][j] = '.';
                }
            }
            dfs(n, 0, sol, res);
            return res;
        }
        private static void dfs(int n, int level, char[][] sol, List<List<String>> res) {
            if (level == n) {
                res.add(addToRes(sol));
                return;
            }
            for (int i = 0; i < sol[0].length; i ++) {
                if (isValid(sol, level, i)) {
                    sol[level][i] = 'Q';
                    dfs(n, level + 1, sol, res);
                    sol[level][i] = '.';
                }
            }
        }
        private static boolean isValid(char[][] sol, int level, int index) {
            for (int i = 0; i < level ; i ++) {
                for (int j = 0; j < sol[0].length; j ++) {
                    if (sol[i][j] == 'Q' && (index == j || (Math.abs(level - i) == Math.abs(index - j)))) {
                        return false;
                    }
                }
            }
            return true;
        }
        private static List<String> addToRes(char[][] sol) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < sol.length; i ++) {
                String s = new String(sol[i]);
                list.add(s);
            }
            return list;
        }

        public static void main(String[] args) {
            List<List<String>> res = NQueen.solveNQueens(4);
            for(List<String> list : res){
                System.out.println(Arrays.toString(list.toArray()));
            }
        }

}
