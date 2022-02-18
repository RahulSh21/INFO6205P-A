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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = new ListNode(), p2 = new ListNode() , temp1 = p1, temp2 = p2;

        while(head != null){
            if(head.val < x){
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }

        p1.next = temp2.next;
        p2.next = null;
        temp1 = temp1.next;

        if(temp1 == null){
            return temp2;
        } else
            return temp1;
    }
}