package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;

    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name,age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }


    @Override
    public String getPosition() {
        return "Студент";
    }

    public void live() {
        learn();
    }

    public void learn() {
    }


    public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }

    public void setCourse(int value){
        course = value;
    }

    public void setAverageGrade( double value){
        averageGrade = value;

    }

    public int getCourse() {
        return course;
    }

    public void setBeginningOfSession(int day, int month, int year) {
        beginningOfSession = new Date(year, month, day);
    }

    public void setEndOfSession(int day, int month, int year) {
        endOfSession = new Date(year, month, day);
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}