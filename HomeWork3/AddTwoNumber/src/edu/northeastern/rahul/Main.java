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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode result = new ListNode() ;
        int carry = 0;
        ListNode p1 = l1, p2 = l2, p3 = result;


        while(p1 != null || p2 != null){
            int x = 0, y = 0;
            if(p1.val != 0){
                x=p1.val;
            }
            if(p2.val != 0){
                y=p2.val;
            }
            int sum = carry + x + y;
            carry = sum / 10;
            p3.next = new ListNode(sum % 10);
            p3 = p3.next;


            p1 = p1.next;
            p2 = p2.next;
        }
        if(carry > 0 ){
            p3.next = new ListNode(carry);
        }

        return result.next;
    }
}
