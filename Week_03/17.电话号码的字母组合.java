import sun.misc.Queue;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        Queue<String> q = new LinkedList<>();
        q.offer("");
        String [] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); ++ i) {
            String str = dict [digits.charAt(i) - '0'];
            while (q.peek().length() == i) {
                String temp = q.poll();
                for (char c : str.toCharArray()) {
                    q.offer (temp + String.valueOf(c));
                }
            }
        }

        List<String> list = new ArrayList<>();
        while (!q.isEmpty()) {
            list.add(q.poll());
        }

        return list;
    }
}
// @lc code=end

