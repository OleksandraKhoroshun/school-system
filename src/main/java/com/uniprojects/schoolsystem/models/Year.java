package com.uniprojects.schoolsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "years")
public class Year {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long year_id;

    @OneToMany(mappedBy = "year")
    @JsonIgnore
    private List<Student> students;

    @OneToMany(mappedBy = "year", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<LessonYear> lessonsYears;

    public List<LessonYear> getLessonsYears() {
        return lessonsYears;
    }

    public void setLessonsYears(List<LessonYear> lessonsYears) {
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
