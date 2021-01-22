package com.gj.dsandalg.heap;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * @author guojie
 * <p>
 */
public class MinHeap<E extends Comparable<E>> extends AbstractQueue<E> {

    private E[] heap;
    private int size;

    public MinHeap(int capacity) {
        this.heap = (E[]) new Comparable[capacity];
        this.size = 0;
    }

    private int parent(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private void swap(int parentIndex, int childIndex) {
        E temp = heap[parentIndex];
        heap[parentIndex] = heap[childIndex];
        heap[childIndex] = temp;
    }

    private void minHeap(int i) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int min = i;

        if (left < size && heap[min].compareTo(heap[left]) > 0) {
            min = left;
        } else if (right < size && heap[min].compareTo(heap[right]) > 0) {
            min = right;
        }

        if (min != i) {
            swap(min, i);
            minHeap(i);
        }
    }

    public void printArray() {

        for (E element : heap) {
            System.out.print(element + " ");
        }
        System.out.println("");
    }

    // EODO: print parent nodes with their left child and right child
    // 0. Seviye    Parent: 4       Left Child: 8       Right Child: 12
    // 1. Seviye    Parent: 8       Left Child: 48      Right Child: 16
    // 1. Seviye    Parent: 12      Left Child: 24      Right Child: 32
    // 2. Seviye    Parent: 48      Left Child: 54      Right Child: 72
    // 2. Seviye    Parent: 16      Left Child: 20      Right Child: -
    public void print() {

        int parentCount = (size - 1) / 2;

        for (int i = 0; i <= parentCount; i++) {

            if ((2 * i + 2) >= size) {
                System.out.println(i + ".Seviye  Parent: " + heap[i] + " Left Child: " + heap[2 * i + 1] + " Right Child: -");

            } else {
                System.out.println(i + ".Seviye  Parent: " + heap[i] + " Left Child: " + heap[2 * i + 1] + " Right Child: " + heap[2 * i + 2]);
            }
        }
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E t) {
        if (size < heap.length) {

            heap[size] = t;
            int current = size++;

            while (heap[current].compareTo(heap[parent(current)]) < 0) {
                swap(parent(current), current);
                current = parent(current);
            }

            return true;

        } else {
            System.out.println("heap is full !");

            return false;
        }
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }

        E deletedElement = heap[0];

        heap[0] = heap[size - 1];
        size--;

        // EODO: control from root to end, on a specific path
        minHeap(0);

        return deletedElement;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }

        return heap[0];
    }

}
