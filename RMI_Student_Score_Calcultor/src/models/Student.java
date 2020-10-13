package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private Integer id;
    private String fullName;
    private Integer age;
    private List<Exam> exams;

    public Student(Integer id, String fullName, Integer age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;

        this.exams = new ArrayList<Exam>();
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getId() {
        return id;
    }

    public List<Exam> getExams() {
        return exams;
    }
}
