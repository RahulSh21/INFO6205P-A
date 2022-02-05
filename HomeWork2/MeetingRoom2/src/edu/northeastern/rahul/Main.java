package edu.northeastern.rahul;

import java.util.Arrays;

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int result = 0, endPointer = 0, room = 0;

        for(int i=0; i<=starts.length-1; i++) {
            if(starts[i] < ends[endPointer]) {
                room++;
            } else {
                endPointer++;
            }
        }
        return room;
    }
}