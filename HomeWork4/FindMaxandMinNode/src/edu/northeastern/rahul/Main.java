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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDistance = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1, index = 1;
        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2.next != null) {
            if (p2.val > p1.val && p2.val > p2.next.val ||
                    p2.val < p1.val && p2.val < p2.next.val) {
                if (index1 == -1) {
                    index1 = index;
                }
                if (index2 != -1) {
                    minDistance = Math.min(minDistance, index - index2);
                }
                index2 = index;
            }
            p1 = p2;
            p2 = p2.next;
            index++;
        }

        if (minDistance == Integer.MAX_VALUE)
            return new int[] {-1, -1};
        return new int[] {minDistance, index2 - index1};
    }
}