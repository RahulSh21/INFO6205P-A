package edu.northeastern.rahul;

public class Main {

    public static void main(String[] args) {
	String order = "cba", s = "abcd";
        System.out.println(customSortString(order, s));
    }

    private static String customSortString(String order, String str) {
        int[] occur = new int[26];
        for (char c : str.toCharArray())
            occur[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray())
            while (occur[c - 'a']-- > 0)
                sb.append(c);

        for (char c = 'a'; c <= 'z'; c++)
            while (occur[c - 'a']-- > 0)
                sb.append(c);

        return sb.toString();
    }
}

