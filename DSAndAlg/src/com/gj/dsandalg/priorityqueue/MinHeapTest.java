package com.gj.dsandalg.priorityqueue;

import com.gj.dsandalg.heap.MinHeap;

import java.util.List;

/**
 * @author guojie
 * <p>
 */
public class MinHeapTest {

    public static void main(String[] args) {
        List<Student> studentList = Student.getTestList();

        MinHeap<Student> minHeap = new MinHeap(20);

        for (Student student : studentList) {
            minHeap.offer(student);
        }

        System.out.println("After Min Heap sort ---------- ");

        minHeap.print();

        while (true) {
            Student student = minHeap.poll();
            if (student == null) {
                break;
            }

            System.out.println(student);
        }
    }

}
