package edu.northeastern.rahul;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        final String[] vals = data.split(" ");
        Queue<String> q = new LinkedList<>(Arrays.asList(vals));
        return preorder(q);

    }

    public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("n ");
            return;
        }

        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode preorder(Queue<String> q) {
        final String s = q.poll();
        if (s.equals("n"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = preorder(q);
        root.right = preorder(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));