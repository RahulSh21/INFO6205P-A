package edu.northeastern.rahul;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }

    private static int hIndex(int[] arr) {
        Arrays.sort(arr);
        int i = 1;
        for(; i < arr.length; i++)
            if(arr[arr.length-i] < i)
                break;
        return i-1;
    }
}
