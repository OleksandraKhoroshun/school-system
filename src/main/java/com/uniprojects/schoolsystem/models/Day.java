package com.uniprojects.schoolsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity(name="days")
public class Day {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long day_id;
    private String day_name;

    @OneToMany(mappedBy = "day", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<LessonSchedule> lessonSchedules;

    public List<LessonSchedule> getLessonSchedules() {
        return lessonSchedules;
    }

    public void setLessonSchedules(List<LessonSchedule> lessonSchedules) {
        this.lessonSchedules = lessonSchedules;
    }

    public Day(){

    }

    public Long getDay_id() {
        return day_id;
    }

    public void setDay_id(Long day_id) {
        this.day_id = day_id;
    }

    public String getDay_name() {
        return day_name;
    }

    public void setDay_name(String day_name) {
        this.day_name = day_name;
    }
}
