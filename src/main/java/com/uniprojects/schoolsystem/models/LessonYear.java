package com.uniprojects.schoolsystem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity(name = "lessons_years")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "lesson_year_id")
public class LessonYear {
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
    @JoinTable(
            name="lessons_years_teachers",
            joinColumns = @JoinColumn(name = "lesson_year_id"),
            inverseJoinColumns = @JoinColumn(name="teacher_id")
    )
    private Teacher teacher;

    @OneToMany(mappedBy = "lessonYear", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<LessonSchedule> lessonSchedules;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<LessonSchedule> getLessonSchedules() {
        return lessonSchedules;
    }

    public void setLessonSchedules(List<LessonSchedule> lessonSchedules) {
        this.lessonSchedules = lessonSchedules;
    }

    public LessonYear() {

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
