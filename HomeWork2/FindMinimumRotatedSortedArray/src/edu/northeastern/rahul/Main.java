package edu.northeastern.rahul;

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int p1 = 0;
        int p2 = nums.length - 1;

        while(p1<p2){
            int mid = (p1+p2)/2;
            if(nums[mid] > nums[p2]){
                p1 = mid+1;
            }
            else if(nums[mid] < nums[p2]){
                p2 = mid;
            }
            else return nums[p2];
        }
        return nums[p1];
    }
}