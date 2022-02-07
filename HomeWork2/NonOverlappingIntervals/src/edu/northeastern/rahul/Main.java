package edu.northeastern.rahul;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals.length < 2){
            return 0;
        }
        Arrays.sort(intervals, (a, b)->(a[0] - b[0]));

        int count = 0, lastIncluded = 0;
        for(int i = 1; i < intervals.length; ++i){
            if(intervals[i][0] < intervals[lastIncluded][1]){
                count++;
                if(intervals[i][1] < intervals[lastIncluded][1]) {
                    lastIncluded = i;
                }
            } else{
                lastIncluded = i;
            }
        }
        return count;
    }
}


