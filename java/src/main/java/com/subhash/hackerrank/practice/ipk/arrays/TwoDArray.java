package com.subhash.hackerrank.practice.ipk.arrays;

public class TwoDArray {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        Integer max =  null;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum =
                        arr[i][j] +
                                arr[i][j+1] +
                                arr[i][j+2] +
                                arr[i+1][j+1] +
                                arr[i+2][j] +
                                arr[i+2][j+1] +
                                arr[i+2][j+2];

                max = max == null ? sum : (sum > max ? sum :  max);
            }
        }
        return max;

    }
}
