package com.uniprojects.schoolsystem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Entity(name = "assignments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "assignment_id", scope = Assignment.class)
public class Assignment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int assignment_id;
    private int grade;

    private String pathway;

    @OneToMany(mappedBy = "assignment")
    private List<LessonSchedule> lessonschedules;

    public Assignment(){

    }

    public void createFile(){
        try {
            File myObj = new File(pathway);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<LessonSchedule> getLessonschedules() {
        return lessonschedules;
    }

    public void setLessonschedules(List<LessonSchedule> lessonschedules) {
        this.lessonschedules = lessonschedules;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPathway() {
        return pathway;
    }

    public void setPathway(String pathway) {
        this.pathway = pathway;
    }
}
