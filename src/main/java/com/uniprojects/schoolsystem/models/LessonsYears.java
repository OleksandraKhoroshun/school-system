package com.uniprojects.schoolsystem.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "lessons_years")
public class LessonsYears {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long lesson_year_id;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year_id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson_id;

    public LessonsYears() {

    }

    public Long getLesson_year_id() {
        return lesson_year_id;
    }

    public void setLesson_year_id(Long lesson_year_id) {
        this.lesson_year_id = lesson_year_id;
    }

    public Year getYear_id() {
        return year_id;
    }

    public void setYear_id(Year year_id) {
        this.year_id = year_id;
    }

    public Lesson getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Lesson lesson_id) {
        this.lesson_id = lesson_id;
    }
}
