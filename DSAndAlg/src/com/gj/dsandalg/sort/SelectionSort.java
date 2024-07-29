package com.gj.dsandalg.sort;

public class SelectionSort {

    public static void selection_sort(int[] array, int n) {
        int i, j, min;

        for (i = 0; i < n - 1; i++) {
            min = i;
            for (j = i + 1; j < n; j++) {
                if (array[j] < array[min])
                    min = j;
            }
            swap(array, min, i);
            printlnArray(array);
        }
    }

    public static void printlnArray(int[] array) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                sb.append("[");
            }
            sb.append(array[i]);
            sb.append(",");
            if (i == array.length - 1) {
                sb.append(']');
            }
        }

        System.out.println(sb);

    }

    public static void swap(int[] array, int min, int i) {
        int temp = array[i];

        array[i] = array[min];
        array[min] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10, 2, 1, 3, 5, 9, 10, 38, 8};

        selection_sort(array, array.length);
    }

}
