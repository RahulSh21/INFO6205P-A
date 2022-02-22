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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int length = size(head);
        int subLength = length / k;
        int remainder = length % k;

        ListNode p1 = null;
        ListNode p2 = head;

        for (int i = 0; i < k; i++) {
            result[i] = p2;
            for (int j = 0; j < subLength + (remainder > 0 ? 1 : 0); j++) {
                p1 = p2;
                p2 = p2.next;
            }
            if (p1 != null) {
                p1.next = null;
            }
            remainder--;
        }

        return result;
    }

    private int size(ListNode root) {
        int length = 0;
        ListNode p1 = root;
        while( p1 != null) {
            length++;
            p1 = p1.next;
        }
        return length;
    }
}