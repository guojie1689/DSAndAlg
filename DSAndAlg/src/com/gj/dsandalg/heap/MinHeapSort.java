package com.gj.dsandalg.heap;


import java.util.Arrays;

/**
 * 堆排序，从小到大
 *
 * @param <T>
 */
public class MinHeapSort<T extends Comparable<T>> {
    public static void sort(Comparable[] source) {
        Comparable[] dest = new Comparable[source.length + 1];
        //构建堆
        createHeap(source, dest);
        //定义一个变量，记录未排序的集合中最大的索引
        int maxIndex = dest.length - 1;
        //通过循环，交换索引1和集合中最大的索引位置
        while (maxIndex != 1) {
            //交换元素
            swap(dest, 1, maxIndex);
            maxIndex--;
            //需要对索引1处的元素进行堆的下沉调整
            sink(dest, 1, maxIndex);
        }

        System.arraycopy(dest, 1, source, 0, source.length);
    }

    private static void createHeap(Comparable[] source, Comparable[] dest) {
        //拷贝
        System.arraycopy(source, 0, dest, 1, source.length);
        //目前无序，对dest数组进行下沉调整(从长度的一半处开始)
        for (int i = dest.length / 2; i > 0; i--) {
            sink(dest, i, dest.length - 1);
        }

    }

    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private static void swap(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private static void sink(Comparable[] heap, int target, int range) {
        while (2 * target <= range) {
            //1. 找出当前节点中的较大子节点
            int max = 0;
            if (2 * target + 1 <= range) {
                if (less(heap, 2 * target, 2 * target + 1)) {
                    max = 2 * target + 1;
                } else {
                    max = 2 * target;
                }
            } else {
                max = 2 * target;
            }

            //2. 找出当前节点的值和较大子节点的值
            if (!less(heap, target, max)) {
                break;
            }

            swap(heap, target, max);
            target = max;
        }
    }

    public static void main(String[] args) {
        String[] heap = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(heap);
        System.out.println(Arrays.toString(heap));
    }

}
