package com.gj.dsandalg.sort;

public class BaseSort {
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            System.out.println("i is same as j, the value is " + i);
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public static void printlnArray(int[] array) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                sb.append("[");
            }
            sb.append(array[i]);
            if (i == array.length - 1) {
                sb.append(']');
            } else {
                sb.append(",");
            }
        }

        System.out.println(sb);

    }
}
