package edu.northeastern.rahul;

public class LinkList {

    Node result = new Node(0);

        public void add(int data){

        }

        public Node addTwoLinkLisk(Node l1, Node l2){
            int size1 = size(l1);
            int size2 = size(l2);
            if(size1 > size2){
                addTwoLinkLisk(l1,l2,size1,size2);
            } else {
                addTwoLinkLisk(l2,l1,size2,size1);
            }

            return result;
        }

        public int size (Node l1){
            int count = 0;
            while(l1.next != null){
                count++;
            }
            return count;
        }

        public Node addTwoLinkLisk(Node l1, Node l2, int size1, int size2){
            Node point1 = l1;
            Node point2 = l2;
            while(point1.next != null){
                int carry = 0; int d = 0;
                if(point2 != null){
                    d = point2.data;
                }
                int sum = point1.data + d + carry;

                    carry = sum / 10;

                point1 = point1.next;
                point2 = point2.next;
                result = new Node(sum);
            }
            return result;


        }
}
