package edu.northeastern.rahul;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	int[] arr = {3,2,4,1};
        System.out.println(pancakeSorting(arr));
    }

    private static List<Integer> pancakeSorting(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length; i >= 1; i--) {
            if (arr[i - 1] != i) {
                int index = 0;
                for (int j = arr.length - 1; j >= 0; j--) {
                    if (arr[j] == i) {
                        index = j;
                        break;
                    }
                }
                if (index > 0) {
                    flips(arr, index);
                    list.add(index + 1);
                }
                flips(arr, i - 1);
                list.add(i);
            }
        }
        return list;
    }

   private static void flips(int[] array, int index) {
        int left = 0, right = index;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
