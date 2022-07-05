package com.uniprojects.schoolsystem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "students")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "student_id", scope = Student.class)
public class Student extends User{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long student_id;

    private String usertype;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year;

    private String login;
    private String pass;

    public List<Lesson> getLessons(){
        List<Lesson> result = new ArrayList<>();
        List<LessonYear> lessonsYears =  year.getLessonsYears();
        if(lessonsYears!=null)
            lessonsYears.forEach(lessonYear -> {
                result.add(lessonYear.getLesson());
            });

        return result;
    }

    /*public List<LessonSchedule> getSchedule(){
        List<LessonSchedule> result = new ArrayList<>();
        List<LessonYear> lessonsYears =  year.getLessonsYears();
        if(lessonsYears!=null)
            lessonsYears.forEach(lessonYear -> {
                result.add(lessonYear.getLessonSchedules());
            });

        return result;
    }*/

    public UserType getUsertype() {
        return UserType.fromString(usertype);
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Student(){

    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
