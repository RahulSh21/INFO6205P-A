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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>(Arrays.asList(root));

        while (!nodeQueue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            for (int size = nodeQueue.size(); size > 0; size--) {
                TreeNode node = nodeQueue.poll();
                currLevel.add(node.val);
                if (node.left != null)
                    nodeQueue.offer(node.left);
                if (node.right != null)
                    nodeQueue.offer(node.right);
            }
            result.add(currLevel);
        }

        Collections.reverse(result);
        return result;
    }
}