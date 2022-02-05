package edu.northeastern.rahul;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = -1;
        for(int i = 0; i<nums.length-1; i++){
            int p1=i+1, p2=nums.length-1;
            while(p1<p2){
                int sum = nums[i]+nums[p1]+nums[p2];
                if (Math.abs(sum - target) <= target) {
                    ans = sum;
                }

                if (sum > target){
                    p2--;
                }
                else if (sum < target) {
                    p1++;
                }
                else return target;
            }
        }
        return ans;
    }
}