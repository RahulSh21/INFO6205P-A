package edu.northeastern.rahul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = {3,2,3,};
        System.out.println((majorityElementBruteForce(nums)));
    }

    public static List<Integer> majorityElementBruteForce(int[] arr) {

        int majorityCount = arr.length/3;
        HashSet<Integer> result = new HashSet<>();

        for (int k : arr) {

            int count = 0;
            for (int i : arr) {

                if (k == i) {
                    count++;
                }
            }

            if (count > majorityCount) {
                result.add(k);
            }
        }

        return new ArrayList<>(result);
    }
}
