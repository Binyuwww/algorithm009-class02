import org.w3c.dom.ls.LSInput;

import sun.java2d.pipe.AAShapePipe;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        helper(root, list);
        return list;
    }

    private void helper (TreeNode root, List<Integer> list) {
        if (root.left != null) {
            helper(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            helper (root.right, list);
        }
    }
}
// @lc code=end

