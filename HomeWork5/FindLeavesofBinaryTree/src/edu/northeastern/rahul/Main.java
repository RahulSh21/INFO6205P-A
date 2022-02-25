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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        depth(root, result);
        return result;
    }

    public int depth(TreeNode root, List<List<Integer>> list){
        if(root==null){
            return -1;
        }
        int left = depth(root.left, list);
        int right = depth(root.right, list);
        int curr = 1+Math.max(left, right);
        if (list.size()<=curr){
            list.add(new ArrayList<Integer>());
            }
        list.get(curr).add(root.val);
        return curr;
    }
}