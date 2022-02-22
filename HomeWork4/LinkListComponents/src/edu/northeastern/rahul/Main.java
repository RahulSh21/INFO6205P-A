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
    public int numComponents(ListNode head, int[] nums) {
        int count = 0;
        HashSet<Integer> hashSet = new HashSet<>();

        for (final int i : nums)
            hashSet.add(i);

        while (head != null) {
            if (hashSet.contains(head.val) && (head.next == null || !hashSet.contains(head.next.val)))
                ++count;
            head = head.next;
        }
        return count;
    }
}
