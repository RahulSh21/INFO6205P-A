package edu.northeastern.rahul;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node p1 = head;
        Node p2 = head.next;

        while(p1 != p2){
            if ((p1.val <= insertVal && insertVal <= p2.val) || (p1.val > p2.val &&   (insertVal >= p1.val || insertVal <= p2.val))) {
                p1.next = new Node(insertVal, p2);
                return head;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = new Node(insertVal, p2);
        return head;
    }
}