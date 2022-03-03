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
    public   int path = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null || (root.left==null && root.right==null )){
            return 0;
        }
        int lenght=0;

        if(root.left!=null){
            int temp=1+longestUnivaluePath(root.left);
            if(root.left.val==root.val){
                lenght+=temp;

            }
        }

        if(root.right!=null){
            int temp=1+longestUnivaluePath(root.right);
            if(root.right.val==root.val){
                lenght+=temp;
            }
        }

        path=Math.max(path,lenght);
        return path;


    }
}