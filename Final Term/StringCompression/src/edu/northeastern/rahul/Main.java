package edu.northeastern.rahul;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String inputString = "aabcccccaaa";
        String inputString1 = "ab";
        String output = "a2b1c5a3";
        System.out.println(compressString(inputString));
        System.out.println(compressString(inputString1));

    }

    public static String compressString(String str) {
        if (str == null) {
            return null;
        }
        char[] ans = new char[str.length()];
        String result = "";
        int p1 = 0;
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ) {
            char letter = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == letter) {
                count++;
                i++;
            }
            result = result + letter + count;

        }
        if (result.length() > str.length()) {
            return str;
        } else {
            return result;
        }
    }

}


