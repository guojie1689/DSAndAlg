package com.gj.dsandalg.sort;

public class PopSort extends BaseSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.println("====="+i+"======");
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换相邻的两个元素
                    swap(array, j, j + 1);
                    System.out.println("swap[" + array[j] + "][" + array[j + 1] + "]");
                    swapped = true;
                }
            }

            printlnArray(array);

            // 如果没有发生交换，数组已经有序，提前退出
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 2, 1, 3, 5, 9, 10, 38, 8};
        bubbleSort(array);
        System.out.println("result ---");
        printlnArray(array);
    }

}
