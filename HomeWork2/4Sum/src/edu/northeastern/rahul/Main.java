package edu.northeastern.rahul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums == null){
            return null;
        }
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int newTarget = target - nums[i] - nums[j];
                int p1 = j + 1;
                int p2 = nums.length - 1;
                while (p1 < p2) {
                    if ((nums[p1] + nums[p2]) == newTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[p1++], nums[p2--]));
                    }
                    else if ((nums[p1] + nums[p2]) < newTarget) {
                        p1++;
                    }
                    else {
                        p2--;
                    }
                }
            }
        }
        return result;
    }
}