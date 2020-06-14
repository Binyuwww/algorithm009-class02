/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int x = matrix.length;
        int y = matrix[0].length;
        int l = 0;
        int r = x * y - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int temp = matrix[mid / y][mid % y];
            
            if (temp == target) {
                return true;
            }
            else if (temp < target) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return false;

    }
}
// @lc code=end

