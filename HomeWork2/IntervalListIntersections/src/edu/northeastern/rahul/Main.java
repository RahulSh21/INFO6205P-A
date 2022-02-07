package edu.northeastern.rahul;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> result = new ArrayList();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int a0 = firstList[i][0], a1 = firstList[i][1];
            int b0 = secondList[j][0], b1 = secondList[j][1];

            if (a0 > b1) {
                j++;
                continue;
            }
            if (b0 > a1) {
                i++;
                continue;
            }

            result.add(new int[]{Math.max(a0, b0), Math.min(a1, b1)});

            if (a1 > b1) j++;
            else i++;
        }

        return result.toArray(new int[result.size()][]);

    }
}
