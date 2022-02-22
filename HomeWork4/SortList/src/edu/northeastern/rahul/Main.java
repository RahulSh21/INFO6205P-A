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
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        int length = size(head);
        ListNode result = new ListNode(0, head);

        for (int i = 1; i < length; i *= 2) {
            ListNode p1 = result.next;
            ListNode p2 = result;
            while (p1 != null) {
                ListNode l = p1;
                ListNode r = divide(l, i);
                p1 = divide(r, i);
                ListNode[] merged = merge(l, r);
                p2.next = merged[0];
                p2 = merged[1];
            }
        }

        return result.next;
    }

    private int size(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while( curr != null){
            length++;
            curr = curr.next;
        }

        return length;
    }

    private ListNode divide(ListNode head, int k) {

        while (--k > 0 && head != null)
            head = head.next;

        ListNode result1 = head == null ? null : head.next;
        if (head != null){
            head.next = null;
        }


        return result1;
    }

    private ListNode[] merge(ListNode list1, ListNode list2) {
        ListNode linkList = new ListNode(0);
        ListNode p1 = linkList;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                ListNode temp = list1;
                list1 = list2;
                list2 = temp;
            }
            p1.next = list1;
            list1 = list1.next;
            p1 = p1.next;
        }
        p1.next = list1 == null ? list2 : list1;
        while (p1.next != null){
            p1 = p1.next;
        }

        return new ListNode[] {linkList.next, p1};
    }
}

