package com.uniprojects.schoolsystem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "lessons")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "lesson_id", scope = Lesson.class)
public class Lesson {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long lesson_id;
    private String lesson_name;
    private String lesson_description;
    private Integer lesson_length;


    @OneToMany(mappedBy = "lesson", orphanRemoval = true, cascade = CascadeType.PERSIST)
   // @JsonIgnore
    private List<LessonYear> lessonsYears;

    /*public List<LessonSchedule> getSchedule(){
        List<LessonSchedule> result = new ArrayList<>();
        if(lessonsYears!=null)
            lessonsYears.forEach(lessonYear -> {
                result.add(lessonYear.getLessonSchedules());
            });

        return result;
    }*/

    public List<LessonYear> getLessonsYears() {
        return lessonsYears;
    }

    public void setLessonsYears(List<LessonYear> lessonsYears) {
        this.lessonsYears = lessonsYears;
    }

    public Lesson(){

    }

    public Long getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Long lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public String getLesson_description() {
        return lesson_description;
    }

    public void setLesson_description(String lesson_description) {
        this.lesson_description = lesson_description;
    }

    public Integer getLesson_length() {
        return lesson_length;
    }

    public void setLesson_length(Integer lesson_length) {
        this.lesson_length = lesson_length;
    }

    public String toString() {
        return lesson_name;
    }
}
