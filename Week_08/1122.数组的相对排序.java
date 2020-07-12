/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        if (len1 == 0 || len2 == 0) {
            return new int[0];
        }

        int[] bucket = new int[1001];
        for (int num : arr1) {
            bucket[num] ++;
        }
        int index = 0;

        for (int num : arr2) {
            while(bucket[num] > 0){
                bucket[num]--;
                arr1[index ++] = num;
            }
        }

        for (int i = 0; i < 1001; ++ i) {
            while (bucket[i] > 0) {
                bucket[i]--;
                arr1[index ++] = i;
            }
        }

        return arr1;
    }
}
// @lc code=end

