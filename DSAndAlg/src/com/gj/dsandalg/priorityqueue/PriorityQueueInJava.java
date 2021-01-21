package com.gj.dsandalg.priorityqueue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author guojie
 * <p>
 * Java 自带的PriporityQueue
 */
public class PriorityQueueInJava {

    public static void main() {

        List<Student> studentList = Student.getTestList();

        PriorityQueue<Student> studentsQueue = new PriorityQueue<>(new StudentComparator());

        for (Student student : studentList) {
            studentsQueue.add(student);
        }

        System.out.println("After priorityQueue sort --- ");

        while (true) {
            Student student = studentsQueue.poll();
            if (student == null) {
                break;
            }

            System.out.println(student);
        }
    }
}
