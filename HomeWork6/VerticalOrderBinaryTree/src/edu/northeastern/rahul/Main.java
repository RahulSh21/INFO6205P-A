package edu.northeastern.rahul;

public class Main {

    static ArrayList<Integer> verticalOrder(Node root) {
        //final list which will be returned
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        //map to track nodes for each HD
        Map<Integer, List<Integer>> mp = new HashMap<>();
        //index of each nodes stored in q(queues)
        Queue<Integer> indices = new LinkedList<>();
        indices.offer(0);
        int minIndex = 0, maxIndex = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                int index = indices.poll();

                mp.putIfAbsent(index, new ArrayList<>());
                mp.get(index)
                        .add(node.data);

                if (node.left != null) {
                    q.offer(node.left);
                    indices.offer(index - 1);
                    minIndex = Math.min(minIndex, index - 1);
                }

                if (node.right != null) {
                    q.offer(node.right);
                    indices.offer(index + 1);
                    maxIndex = Math.max(maxIndex, index + 1);
                }
        
        for (int i = minIndex; i <= maxIndex; i++) { //Collections.sort(mp.get(i));
            int size = mp.get(i)
                    .size();
            for (int ii = 0; ii < size; ii++)
                res.add(mp.get(i)
                        .get(ii));
        }
        //final list containing number of nodes traversed in Vertical Order
        return res;
    }
}
