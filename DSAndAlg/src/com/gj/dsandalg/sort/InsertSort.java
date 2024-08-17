package com.gj.dsandalg.sort;

public class InsertSort extends BaseSort {

    public static void bubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            // 将大于key的元素向后移动
            for (; j >= 0 && array[j] > key; j--) {
                array[j + 1] = array[j];
            }
            // 将key插入到正确位置
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 2, 1, 3, 5, 9, 10, 38, 8};
        bubbleSort(array);
        System.out.println("result ---");
        printlnArray(array);
    }

}
