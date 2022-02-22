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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode p1 = head;
        int group = 1;
        while(p1 != null){
            int count = 0;
            ListNode start = p1;
            Stack<Integer> stack = new Stack<>();
            while(count != group && p1 != null){
                stack.push(p1.val);
                p1 = p1.next;
                count++;
            }
            if(count%2 == 0){
                while(start != p1){
                    start.val = stack.pop();
                    start = start.next;
                }
            }
            group++;
        }
        return head;
    }
}