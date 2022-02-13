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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = middle(head);
        ListNode secondList = mid.next;
        mid.next = null;
        secondList = reverse(secondList);
        head = reorderList(head, secondList, true);
    }

    private ListNode middle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode back = head;
        ListNode front = head;
        while(front != null && front.next != null){
            front = front.next.next;
            if(front == null){
                break;
            }
            back = back.next;
        }
        return back;
    }

    private ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        if(node.next.next == null){
            ListNode second = node.next;
            ListNode first = node;
            first.next = null;
            second.next = first;
            return second;
        }

        ListNode back = null;
        ListNode mid = node;
        ListNode front = node.next;

        while(front != null){
            mid.next = back;
            back = mid;
            mid = front;
            front = front.next;
        }
        mid.next = back;
        node = mid;

        return node;
    }


    private ListNode reorderList(ListNode n1, ListNode n2, boolean flip){
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }
        ListNode result = null;

        if(flip){
            result = n1;
            result.next = reorderList(n1.next, n2, false);
        }else{
            result = n2;
            result.next = reorderList(n1, n2.next, true);
        }
        return result;
    }
}