import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {

    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> diag1 = new HashSet<>();
    HashSet<Integer> diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        dfs(ans, list, 0, n);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> list, int row, int n) {
        if (n == row) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < n; ++ i) {
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) {
                continue;
            }

            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[i] = 'Q';
            String rowStr = new String(arr);

            list.add(rowStr);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);

            dfs(ans, list, row + 1, n);

            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }

    }
}
// @lc code=end

