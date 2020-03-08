package com.subhash.hackerrank.practice.ipk.arrays;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long max = 0;
        long arr [] = new long [n + 1];
        for (int [] q : queries) {
            arr[q[0]] += q[2];
            if (q[1] < n) {
                arr[q[1] + 1] -= q[2];
            }
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 5;
        int queries [] [] = {
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        };
        System.out.println(arrayManipulation(n, queries));
    }
}
