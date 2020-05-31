import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++ i) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            list.add(level);
        }
        return list;

    }
}
// @lc code=end

