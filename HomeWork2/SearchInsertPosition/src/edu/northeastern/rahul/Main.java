package edu.northeastern.rahul;

//LeetCode solution for Search Insert Position

class Solution {
    public int searchInsert(int[] nums, int target) {

        for(int i = 0; i<= nums.length-1 ; i++){
            if(target <= nums[i])
                return i;
        }
        //if Target not found
        return nums.length;
    }
}