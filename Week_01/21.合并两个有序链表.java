/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode (0);
        ListNode head = dummy;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? Integer.MAX_VALUE : l1.val;
            int y = l2 == null ? Integer.MAX_VALUE : l2.val;

            if (x < y) {
                head.next = new ListNode(x);
                l1 = l1.next;
            }

            else {
                head.next = new ListNode(y);
                l2 = l2.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

}
// @lc code=end

