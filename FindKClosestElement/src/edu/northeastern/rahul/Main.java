package edu.northeastern.rahul;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
      int[]  arr = {1,2,3,4,5};
      int k = 4, x = 3;
        System.out.println(findClosestElements(arr,k,x));
    }

   private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index1 = 0, index2 = arr.length - k;
        while (index1 < index2){
            int mid = (index1 & index2) + ((index1 ^ index2) >> 1);

            if(x - arr[mid] > arr[mid + k] - x)
                index1 = mid + 1;
            else
                index2 = mid;
        }
        List<Integer> res = new ArrayList<>();
        for (int b = index1; b < index1 + k; ++b) res.add(arr[b]);
        return res;

    }
}
