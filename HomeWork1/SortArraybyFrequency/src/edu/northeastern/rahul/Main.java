package edu.northeastern.rahul;

import java.util.*;

public class Main {

    public static void main(String[] args) {
      int[]  nums = {1,1,2,2,2,3};
        System.out.println(Arrays.toString( arrayFrequencySort(nums)));
    }

    private static int[] arrayFrequencySort(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            int count = hashMap.getOrDefault(num, 0) + 1;
            hashMap.put(num, count);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);
        list.sort((num1, num2) -> {
            int count1 = hashMap.get(num1), count2 = hashMap.get(num2);
            if (count1 != count2)
                return count1 - count2;
            else
                return num2 - num1;
        });
        int length = nums.length;
        int[] sorted = new int[length];
        for (int i = 0; i < length; i++)
            sorted[i] = list.get(i);
        return sorted;
    }
}
