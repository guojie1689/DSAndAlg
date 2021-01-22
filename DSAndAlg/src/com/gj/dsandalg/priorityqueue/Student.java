package com.gj.dsandalg.priorityqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guojie
 * <p>
 */
public class Student implements Comparable<Student> {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static List<Student> getTestList() {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("张三", 10));
        studentList.add(new Student("李四", 8));
        studentList.add(new Student("王五", 12));
        studentList.add(new Student("赵六", 16));
        studentList.add(new Student("张强", 13));

        return studentList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student destStudent) {

        if (getAge() > destStudent.getAge()) {
            return 1;
        } else if (getAge() < destStudent.getAge()) {
            return -1;
        }

        return 0;
    }
}
