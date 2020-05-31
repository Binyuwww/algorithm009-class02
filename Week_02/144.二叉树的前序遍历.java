/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper (TreeNode root, List<Integer> list) {
        list.add(root.val);
        
        if (root.left != null) {
            helper(root.left, list);
        }

        if (root.right != null) {
            helper (root.right, list);
        }
    }
}
// @lc code=end

