package com.subhash.hackerrank.practice.ipk.arrays;

import java.util.ArrayList;
import java.util.List;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribes = 0;
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        for (int i = 0; i < q.length; i++) {
            //System.out.println("i: " + i + ", list: " + expectedList + ", q[i] = " + q[i] + ", bribes: " + bribes);
            if (!expectedList.contains(q[i])) {
                System.out.println("Too chaotic");
                return;
            }
            int expectedNum = expectedList.get(0);
            int nextNumToAdd = i + 4;
            if (q[i] != expectedNum) {
                if (q[i] == expectedList.get(1)) {
                    expectedList.remove(1);
                    bribes++;
                } else if (q[i] == expectedList.get(2)) {
                    expectedList.remove(2);
                    bribes += 2;
                }
                expectedList.add(nextNumToAdd++);
            } else {
                expectedList.remove(0);
                expectedList.add(nextNumToAdd);
            }
            //System.out.println("i: " + i + ", list: " + expectedList + ", q[i] = " + q[i] + ", bribes: " + bribes);
        }
        System.out.println(bribes);
    }

    public static void main(String[] args) {
        minimumBribes(new int [] {1, 2, 5, 3, 7, 8, 6, 4});
    }
}
