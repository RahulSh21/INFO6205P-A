package edu.northeastern.rahul;

public class Main {

    public static void main(String[] args) {

        ListNode result = new ListNode(0, head);
        ListNode p1 = result;
        ListNode p2 = head;
        ListNode p3 = head.next;
        int groupLength = 1;

        while (true) {
            if ((groupLength & 1) == 1) {
                p1.next = head;
                p1 = p2;
            } else {
                p2.next = null;
                p1.next = reverse(head);

                head.next = p3;
                p1 = head;
            }
            if (p3 == null)
                break;
            head = p3;
            var res = getTailAndLength(head, groupLength + 1);
            p2 = res.getKey();
            p3 = p2.next;
            groupLength = res.getValue();
        }

        return result.next;
    }

    private Pair<ListNode, Integer> getTailAndLength(ListNode head, int groupLength) {
        int length = 1;
        ListNode end = head;
        while (length < groupLength && end.next != null) {
            end = end.next;
            ++length;
        }
        return new Pair<>(end, length);
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
