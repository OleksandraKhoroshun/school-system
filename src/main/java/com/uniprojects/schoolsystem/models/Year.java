package com.uniprojects.schoolsystem.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "years")
public class Year {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long year_id;

    @OneToMany(mappedBy = "years")
    private List<Student> students;

    @OneToMany(mappedBy = "years")
    private List<LessonsYears> lessonsYears;

    public List<LessonsYears> getLessonsYears() {
        return lessonsYears;
    }

    public void setLessonsYears(List<LessonsYears> lessonsYears) {
        this.lessonsYears = lessonsYears;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Year(){

    }

    public Long getYear_id() {
        return year_id;
    }

    public void setYear_id(Long year_id) {
        this.year_id = year_id;
    }
}
