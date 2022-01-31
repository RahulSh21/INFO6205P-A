package edu.northeastern.rahul;

import java.util.*;

public class Main {

    public static void main(String[] args) {
      String[]  words = {"i","love","leetcode","i","love","coding"};
      int k = 2;
        System.out.println(topKFrequent(words, k));
    }

  private static List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
      PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

      for (int i = 0; i < k; i++) {
          ans.add(0, pq.poll().getKey());
      }
      return ans;

  }
}
