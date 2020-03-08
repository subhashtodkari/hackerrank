package com.subhash.hackerrank.practice.ipk.arrays;

import java.util.Arrays;

public class MinSwaps2 {

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == i + 1) {
                i++;
                continue;
            }
            int temp = arr[i];
            arr[i] = arr[temp-1];
            arr[temp-1] = temp;
            swaps++;
        }
        return swaps;
    }

    public static void main(String[] args) {
        int arrs [] []  = {
                {7, 1, 3, 2, 4, 5, 6},
                {4, 3, 1, 2},
                {1, 3, 5, 2, 4, 6, 7},
                {2, 3, 4, 1, 5}
        };
        for (int [] arr : arrs) {
            System.out.println(Arrays.toString(arr) + " : " + minimumSwaps(arr));
        }
    }

}
