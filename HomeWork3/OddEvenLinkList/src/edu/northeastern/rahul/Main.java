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


    public ListNode oddEvenList(ListNode head) {

        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddNode = odd;
        ListNode evenNode = even;
        boolean toggle = true;
        while( head != null ) {
            if (toggle) {
                oddNode.next = head;
                oddNode = oddNode.next;
                toggle = !toggle;
            } else {
                evenNode.next = head;
                evenNode = evenNode.next;
                toggle = !toggle;
            }
            head = head.next;
        }
        oddNode.next = even.next;
        evenNode.next = null;
        return odd.next;
    }
}
