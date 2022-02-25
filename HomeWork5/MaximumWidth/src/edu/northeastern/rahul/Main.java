package edu.northeastern.rahul;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 1;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();

        root.val = 0;
        nodeQueue.offer(root);

        while(!nodeQueue.isEmpty()){

            int no = nodeQueue.size();
            int start = nodeQueue.peek().val;
            int end = 0;
            for(int i = 0; i<no;i++){

                TreeNode node = nodeQueue.poll();

                if(node.left != null){
                    node.left.val = (node.val * 2);
                    nodeQueue.offer(node.left);
                }
                if(node.right != null){
                    node.right.val = (node.val * 2) +1;
                    nodeQueue.offer(node.right);
                }
                if(i == no-1){
                    end = node.val;
                }
            }

            max = Math.max(max,end - start + 1);

        }

        return max;
    }
    }
}