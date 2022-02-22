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
    private ListNode head;
    private Random rand = new Random();

    public Solution(ListNode head) {
        this.head = head;
    }
    public int getRandom() {
        int ans = -1;
        int i = 1;
        ListNode p1 = head;
        while( p1 != null) {
            if (rand.nextInt(i) == i - 1) {
                ans = p1.val;
            }
            p1 = p1.next;
            i++;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
