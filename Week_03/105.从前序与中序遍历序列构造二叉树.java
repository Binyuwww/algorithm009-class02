/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; ++ i) {
            map.put(inorder[i], i);
        }
        

        return helper (preorder, inorder, 0, 0, inorder.length - 1, map);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);

        root.left = helper(preorder, inorder, preStart + 1, inStart, index - 1, map);
        root.right = helper(preorder, inorder, preStart + index - inStart + 1, index + 1, inEnd, map);
    
        return root;
    }
}
// @lc code=end

