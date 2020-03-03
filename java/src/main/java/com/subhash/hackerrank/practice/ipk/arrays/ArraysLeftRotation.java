package com.subhash.hackerrank.practice.ipk.arrays;

public class ArraysLeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int  r = d % a.length;
        //int r = d;
        //System.out.println("r: " + r);

        int [] temp =  new int [r];
        for (int i = 0; i < r; i++) {
            temp[i] = a[i];
        }
        //System.out.println("temp: " + Arrays.toString(temp));

        for (int i = 0; i < a.length; i++) {
            a[i] = ( i < a.length - r) ? a[i+r] : temp[ i + r - a.length];
            //System.out.println("arr: " + Arrays.toString(a));
        }

        return a;
    }

}
