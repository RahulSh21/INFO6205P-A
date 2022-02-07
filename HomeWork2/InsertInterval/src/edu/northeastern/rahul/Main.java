package edu.northeastern.rahul;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0])
        {
            result.add(intervals[i++]);
        }
        int[] nI = newInterval;
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            nI[0] = Math.min(nI[0], intervals[i][0]);
            nI[1] = Math.max(nI[1], intervals[i++][1]);
        }
        result.add(nI);

        while(i < intervals.length) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][2]);


    }
}


