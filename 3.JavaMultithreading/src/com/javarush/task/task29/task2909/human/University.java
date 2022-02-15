package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University{
     String name;
     int age;
     private List<Student> students = new ArrayList<>();


    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student result = null;
        for (Student student : students){
            if (student.getAverageGrade() == averageGrade){
                result =  student;
            }
        }
        return result;

    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student result = null;
        double max = 0.0;
        for (Student student : students){
            if (student.getAverageGrade() > max){
                max = student.getAverageGrade();
            }
        }

        for (Student student : students){
            if (student.getAverageGrade() == max){
                result =  student;
            }
        }
        return result;
    }

    public Student getStudentWithMinAverageGrade(){
        Student result = students.get(0);
        double min = result.getAverageGrade();
        for (Student student : students){

            if (student.getAverageGrade() < min){
                min = student.getAverageGrade();
            }
        }

        for (Student student : students){
            if (student.getAverageGrade() == min){
                result =  student;
            }
        }
        return result;
    }

    public void expel(Student student){
        students.remove(student);
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}