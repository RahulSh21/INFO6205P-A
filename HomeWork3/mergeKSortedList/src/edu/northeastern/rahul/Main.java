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
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length-1);
    }

    private ListNode divide(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }

        if (start < end){
            int mid = start +((end - start)/2);
            ListNode n1 = divide(lists, start, mid);
            ListNode n2 = divide(lists, mid+1, end);
            return merge(n1, n2);
        } else {
            return null;
        }
    }

    private ListNode merge(ListNode n1, ListNode n2){
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }
        if(n1.val < n2.val){
            n1.next = merge(n1.next, n2);
            return n1;
        } else {
            n2.next = merge(n1, n2.next);
            return n2;
        }
    }
}



