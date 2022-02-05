package edu.northeastern.rahul;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> counts = new HashMap();
        int[] result = new int[k];

        for (int i=0; i<=nums.length-1 ; i++) {
            counts.putIfAbsent(nums[i], 0);
            counts.put(nums[i], counts.get(nums[i]) + 1);
        }

        PriorityQueue<Integer> PQ = new PriorityQueue<>((O1, O2) -> counts.get(O2) - counts.get(O1));

        for(int i: counts.keySet()){
            PQ.add(i);
        }

        for(int i = 0; i < k; ++i)
            result[i] = PQ.poll();
        return result;
    }
}

