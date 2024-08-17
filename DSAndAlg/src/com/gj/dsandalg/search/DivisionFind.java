package com.gj.dsandalg.search;

/**
 * 对于二分法查找元素，首先要保证元素必须是有序的，从小到大，或者从大到小都是可以的。
 * <p>
 * 如果是无序的，也可以先进行排序（排序算法后面会说）；
 * <p>
 * 但是会存在一个问题，当你进行排序之后，会改变原有数据的顺序，如果此时要求返回索要查找到的数字的索引，此时就会使得数字位置因为排序而打乱。
 * <p>
 * 基本思想：用给定值先与中间结点比较。比较完之后有三种情况：
 * <p>
 * 相等：说明找到了
 * 要查找的数据比中间节点小：说明要查找的数字在中间节点左边
 * 要查找的数据比中间节点大：说明要查找的数字在中间节点右边
 *
 * 优点是比较次数少，查找速度快，平均性能好；
 * 其缺点是要求待查表为有序表，且插入删除困难。
 * 因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
 * 使用条件：查找序列是顺序结构，有序。
 */
public class DivisionFind {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 9, 12, 14, 16, 18, 19, 21, 23, 34, 35, 40, 46, 49, 51, 52, 53, 56, 57, 58, 59};

        int index = binarySearch(array, 2);

        System.out.println("index:" + index);
    }

    public static int binarySearch(int[] arr, int number) {
        int min = 0;
        int max = arr.length - 1;
        while (true) {
            if (min > max) {
                return -1;
            }
            int mid = (min + max) / 2;
            if (arr[mid] > number) {
                max = mid - 1;
            } else if (arr[mid] < number) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
    }
}
