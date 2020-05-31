import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || nums == null) {
            return new int[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        
        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] ans = new int[heap.size()];
        
        for (int i = ans.length - 1; i >= 0; -- i) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
// @lc code=end

