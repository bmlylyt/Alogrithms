import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class subset {
        public static List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            dfs(nums, 0, new ArrayList<>(), res);
            return res;
        }
        private static void dfs(int[] nums, int index, List<Integer> sol, List<List<Integer>> res) {
            res.add(new ArrayList<>(sol));
            Set<Integer> set = new HashSet<>();
            for (int i = index; i < nums.length; i ++) {
                if (!set.add(nums[i])) continue;
                sol.add(nums[i]);
                dfs(nums, index + 1, sol, res);
                sol.remove(sol.size() - 1);
            }
        }
        public static void main(String[] args) {
            int[] nums = {1, 2, 2};
            subsetsWithDup(nums);
    }
}
