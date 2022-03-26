package edu.northeastern.rahul;

public class BST {
    Tree root;
    public void search(int[] preOrder, int[] inOrder) {


       int point = search1(preOrder[0], inOrder, 0,preOrder.length-1);

       root = new Tree(inOrder[point]);





    }

    public int search1(int data, int[] inOrder, int start, int end) {
        int point = 0;
        for (int i = start; i <= end; i++) {
           if(inOrder[i] == data ){
               point = i;
           }
        }
        return point;
    }



}
