package edu.northeastern.rahul;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode p1 = result;
        while (p1.next != null && p1.next.next != null) {
            if (p1.next.val == p1.next.next.val) {
                int val = p1.next.val;
                while (p1.next != null && p1.next.val == val) {
                    p1.next = p1.next.next;
                }
            }
            else {
                p1 = p1.next;
            }
        }
        return result.next;
    }
}