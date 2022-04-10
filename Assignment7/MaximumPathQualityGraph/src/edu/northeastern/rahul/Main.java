package edu.northeastern.rahul;

class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {

        final int length = values.length;
        List<Pair<Integer, Integer>>[] listGraph = new List[length];
        int[] seen = new int[length];
        seen[0] = 1;

        for (int i = 0; i < length; ++i)
            listGraph[i] = new ArrayList<>();

        for (int[] e : edges) {
            final int first = e[0];
            final int second = e[1];
            final int time = e[2];
            listGraph[first].add(new Pair<>(second, time));
            listGraph[second].add(new Pair<>(first, time));
        }

        dfs(listGraph, values, 0, values[0], maxTime, seen);
        return ans;
    }

    private int ans = 0;

    private void dfs(List<Pair<Integer, Integer>>[] graph, int[] values, int first, int quality,
                     int remainingTime, int[] seen) {
        if (first == 0)
            ans = Math.max(ans, quality);
        for (var pair : graph[first]) {
            final int v = pair.getKey();
            final int time = pair.getValue();
            if (time > remainingTime)
                continue;
            final int newQuality = quality + values[v] * (seen[v] == 0 ? 1 : 0);
            ++seen[v];
            dfs(graph, values, v, newQuality, remainingTime - time, seen);
            --seen[v];
        }

    }
}