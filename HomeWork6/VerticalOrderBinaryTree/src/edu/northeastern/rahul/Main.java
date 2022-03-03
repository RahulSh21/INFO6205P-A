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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<int[]>> xToSortedPairs = new TreeMap<>(); // {x: {(-y, val)}}

        verticalTraversal(root, 0, 0, xToSortedPairs);

        for (List<int[]> pairs : xToSortedPairs.values()) {
            Collections.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<Integer> vals = new ArrayList<>();
            for (int[] pair : pairs)
                vals.add(pair[1]);
            result.add(vals);
        }

        return result;
    }

    private void verticalTraversal(TreeNode root, int x, int y, TreeMap<Integer, List<int[]>> xToSortedPairs) {
        if (root == null)
            return;

        xToSortedPairs.putIfAbsent(x, new ArrayList<>());
        xToSortedPairs.get(x).add(new int[] {y, root.val});
        verticalTraversal(root.left, x - 1, y + 1, xToSortedPairs);
        verticalTraversal(root.right, x + 1, y + 1, xToSortedPairs);
    }
}