package com.gj.dsandalg.heap;


public class Heap<T extends Comparable<T>> {
    /**
     * items[0]占位
     */
    private T[] items;
    private int N;

    public Heap(int capcity) {
        items = (T[]) new Comparable[capcity + 1];
        this.N = 0;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void swap(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T item) {
        items[++N] = item;
        swim(N);
    }

    /**
     * 上浮函数
     */
    private void swim(int k) {
        //通过循环，不断的比较当前节点的值和父节点的值，如果发现父节点的值比当前节点的值小，则交换位置
        while (k > 1) {
            //比较当前节点和父节点
            if (less(k / 2, k)) {
                swap(k / 2, k);
            }

            k = k / 2;
        }
    }

    public T delMax() {
        T max = items[1];
        //使用最后一个一个元素进行上移，替换掉根节点，然后开始下沉调整堆，重新有序
        swap(1, N);
        items[N] = null;
        N--;
        sink(1);
        return max;

    }

    private void sink(int K) {
        //通过循环不断对比当前K节点和其左子节点2K以及右子节点2K+1中的较大值的元素大小,如果当前节点小则需要交换位置
        while (2 * K <= N) {
            //获取当前节点中的较大结点
            int max = 0;
            if (2 * K + 1 <= N) {
                if (less(2 * K, 2 * K + 1)) {
                    max = 2 * K + 1;
                } else {
                    max = 2 * K;
                }
            } else {
                max = 2 * K;
            }

            //比较当前节点与子节点最大值的关系
            if (!less(K, max)) {//已经满足当前节点比2个子节点大的关系了
                break;
            }

            swap(K, max);
            K = max;
        }
    }

    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");

        String result = "";
        while ((result = heap.delMax()) != null) {
            System.out.print(result + " ");
        }

    }
}
