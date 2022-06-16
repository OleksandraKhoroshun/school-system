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
    private Year year;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "teachers")
    private Teacher teacher;

    public LessonsYears() {

    }

    public Long getLesson_year_id() {
        return lesson_year_id;
    }

    public void setLesson_year_id(Long lesson_year_id) {
        this.lesson_year_id = lesson_year_id;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
