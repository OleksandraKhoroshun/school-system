package com.uniprojects.schoolsystem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import java.nio.file.Files;
import javax.persistence.*;
import java.io.*;
import java.util.List;

@Entity(name = "assignments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "assignment_id", scope = Assignment.class)
public class Assignment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long assignment_id;
    private int grade;

    private String pathway;

    @OneToMany(mappedBy = "assignment")
    private List<LessonSchedule> lessonschedules;

    @Transient
    @JsonIgnore
    private String name;

    public Assignment(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void handIn(String name) throws IOException {
        this.name=name;
        File source = new File(pathway+"\\"+name);
        File dest = new File("C:\\test\\"+name);
        Files.copy(source.toPath(), dest.toPath());
    }

    @Transient
    @JsonIgnore
    public File getFile(){
        File source = new File(name);
        return source;
    }

    public List<LessonSchedule> getLessonschedules() {
        return lessonschedules;
    }

    public void setLessonschedules(List<LessonSchedule> lessonschedules) {
        this.lessonschedules = lessonschedules;
    }

    public Long getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(Long assignment_id) {
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
