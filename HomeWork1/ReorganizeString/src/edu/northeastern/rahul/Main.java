package edu.northeastern.rahul;

public class Main {

    public static void main(String[] args) {
	String s = "aab";
        System.out.println(reorganizeString(s));
    }

    private static String reorganizeString(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                letter = i;
            }
        }
        if (s.length() - max < max - 1) {
            return "";
        }
        char[] result = new char[s.length()];
        int id = 0;
        while (arr[letter] > 0) {
            result[id] = (char)(letter + 'a');
            id += 2;
            arr[letter]--;
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (id >= result.length) {
                    id = 1;
                }
                result[id] = (char)(i + 'a');
                id += 2;
                arr[i]--;
            }
        }
        return String.valueOf(result);
    }
}
