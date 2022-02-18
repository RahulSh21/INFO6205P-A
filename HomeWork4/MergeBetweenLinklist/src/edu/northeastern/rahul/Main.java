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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1 == null || list2 == null){
            return null;
        }
        ListNode p1 = list1, p2 = list1;
        a= a-1;
        while(a != 0){
            p1 = p1.next;
            a--;
        }
        while(b != 0){
            p2 = p2.next;
            b--;
        }
        p1.next = list2;

        while(p1.next != null ){
            p1 = p1.next;

        }
        p1.next = p2.next;
        return list1;

    }
}