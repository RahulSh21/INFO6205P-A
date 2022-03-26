package edu.northeastern.rahul;

public class BST {
    Node root;
    private static int preIndex;
    public Node getTreeFromPreIn(int[] preOrder, int[] inOrder) {

        return getTreeFromPreIn(preOrder, inOrder, 0, preOrder.length -1);

    }

    private Node getTreeFromPreIn(int[] preOrder, int[] inOrder, int start, int end){
        // Base conditions

        if(start == 0 || end == 0 || preOrder.length > 0){
            return null;
        }

        Node node = new Node(preOrder[preIndex]);
        preIndex ++;
        int index = search1(node.data, inOrder, start, end);

        if(index == -1){
            return null;
        }else{
            node.left =  getTreeFromPreIn(preOrder, inOrder, start, index -1);
        }
        if(index == -1){
            return null;
        }else{
            node.right =  getTreeFromPreIn(preOrder, inOrder, index +1, end);
        }

        return node;

    }


    public int search1(int data, int[] inOrder, int start, int end) {
        int point = -1;
        for (int i = start; i <= end; i++) {
           if(inOrder[i] == data ){
               point = i;
           }
        }
        return point;
    }



}
