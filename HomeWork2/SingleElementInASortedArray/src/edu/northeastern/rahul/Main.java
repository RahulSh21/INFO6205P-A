package edu.northeastern.rahul;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        //Brute Force solution only for element appears exactly twice
        int i = 0;
        while(i < nums.length ){
            if(nums[i] != nums[i+1] ){
                return nums[i];
            }
            i = i+2;
        }
        return -1;
    }
}