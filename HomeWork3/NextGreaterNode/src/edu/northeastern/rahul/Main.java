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
    public int[] nextLargerNodes(ListNode head) {


        int[] result = new int[size(head)];
        int i = 0;
        while(head != null){
            result[i++] = findLargerNode(head, head.val);
            head = head.next;
        }
        return result;
    }

    public static int findLargerNode(ListNode node, int val){
        int nodeVal = 0;
        while(node != null) {
            if(node.val > val) {
                nodeVal = node.val;
                break;
            }
            node = node.next;
        }
        return nodeVal;
    }

    private int size(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}