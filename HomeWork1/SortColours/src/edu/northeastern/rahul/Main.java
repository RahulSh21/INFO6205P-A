package edu.northeastern.rahul;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	int[] nums ={2,0,2,1,1,0};
        System.out.println(Arrays.toString(sortColours(nums)));
    }

    private static void swap(int[] arr, int pointer1, int pointer2){
        int temp = arr[pointer1];
        arr[pointer1] = arr[pointer2];
        arr[pointer2] = temp;

    }

    private static int[] sortColours(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        if (arr.length == 1){
            return arr;
        }
        int pointer1 = 0;
        int pointer2 = arr.length-1;
        while(pointer1 <= pointer2){
            if(arr[pointer1] > arr[pointer2]){
                swap(arr, pointer1,pointer2);
                pointer1++;
            }else if(arr[pointer1] == arr[pointer2]){
                pointer2--;
            }else if (arr[pointer1] < arr[pointer2]){
                pointer1++;
            }
        }
        return arr;
    }
}
