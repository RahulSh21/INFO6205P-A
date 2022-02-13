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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if( n <= 0){
            return null;
        }
        if(head == null){
            return null;
        }
        int steps = size(head) - n;

        if(steps == 0 ){
            return null;
        }

        ListNode temp = head;
        for(int i = 0 ; i < size(head); i ++){
            if(i == steps-1){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }


        return head;

    }

    private int size(ListNode head){
        int count =0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}
