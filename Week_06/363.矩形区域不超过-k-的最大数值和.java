/*
 * @lc app=leetcode.cn id=363 lang=java
 *
 * [363] 矩形区域不超过 K 的最大数值和
 */

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int m = Integer.MIN_VALUE;

        for (int l = 0; l < col; ++ l) {
            int [] rowSum = new int[row];
            for (int r = l; r < col; ++ r) {
                for (int i = 0; i < row; ++ i) {
                    rowSum[i] += matrix[i][r];
                }
                m = Math.max(m, helper(rowSum, k));
                if (m == k) {
                    return k;
                }
            }
        }
        return m;
    }

    private int helper (int [] arr, int k) {
        int dSum = arr[0];
        int dMax = dSum;

        for (int i = 1; i < arr.length; ++ i) {
            if (dSum >= 0) {
                dSum += arr[i];
            }else {
                dSum = arr[i];
            }

            if (dSum > dMax) {
                dMax = dSum;
            }

        }

        if (dMax <= k) {
            return dMax;
        }
        int max = Integer.MIN_VALUE;

        for (int l = 0; l < arr.length; ++ l) {
            int sum = 0;
            for (int r = l; r < arr.length; ++ r) {
                sum += arr[r];

                if (sum > max && sum <= k) {
                    max = sum;
                }

                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }
}
// @lc code=end

