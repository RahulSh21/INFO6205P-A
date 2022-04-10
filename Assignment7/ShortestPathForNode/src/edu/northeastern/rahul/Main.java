package edu.northeastern.rahul;

class Solution {
    public int shortestPathLength(int[][] graph) {
        final int lenght = graph.length;
        final int goal = (1 << lenght) - 1;

        int ans = 0;
        Queue<Pair<Integer, Integer>> arrayDeque = new ArrayDeque<>();
        boolean[][] seen = new boolean[lenght][1 << lenght];

        for (int i = 0; i < lenght; ++i)
            arrayDeque.offer(new Pair<>(i, 1 << i));

        while (!arrayDeque.isEmpty()) {
            for (int i = arrayDeque.size(); i > 0; --i) {
                final int u = arrayDeque.peek().getKey();
                final int state = arrayDeque.poll().getValue();
                if (state == goal)
                    return ans;
                if (seen[u][state])
                    continue;
                seen[u][state] = true;
                for (final int v : graph[u])
                    arrayDeque.offer(new Pair<>(v, state | (1 << v)));
            }
            ++ans;
        }

        return -1;
    }
}