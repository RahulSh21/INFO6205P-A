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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1)
            return reverseNode(head, right);
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reverseNode(ListNode head, int n) {
        if (n == 1) {
            return head;
        }
        ListNode result = reverseNode(head.next, n - 1);
        ListNode resultNext = head.next;
        head.next = resultNext.next;
        resultNext.next = head;

        return result;
    }
}

