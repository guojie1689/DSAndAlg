package com.gj.dsandalg.priorityqueue;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author guojie
 * <p>
 * Java 自带的PriporityQueue
 */
public class BlockingPriorityQueueInJava {

    public static void main() {

        List<Student> studentList = Student.getTestList();

        PriorityBlockingQueue<Student> studentsQueue = new PriorityBlockingQueue<Student>(100, new StudentComparator());

        for (Student student : studentList) {
            studentsQueue.add(student);
        }

        System.out.println("After Blocking priorityQueue  sort ----");

        while (true) {
            Student student = studentsQueue.poll();
            if (student == null) {
                break;
            }

            System.out.println(student);
        }
    }
}
