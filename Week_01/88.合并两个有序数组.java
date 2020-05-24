/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;

        while (m - 1 >= 0 || n - 1 >= 0) {
            int x = m - 1 < 0 ? Integer.MIN_VALUE : nums1[m - 1];
            int y = n - 1 < 0 ? Integer.MIN_VALUE : nums2[n - 1];

            if (x > y) {
                nums1[end--] = x;
                m--;
            }

            else {
                nums1[end--] = y;
                n--;
            }

        }
    }
}
// @lc code=end

