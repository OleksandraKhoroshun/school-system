package com.uniprojects.schoolsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "teachers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long teacher_id;

    private String first_name;
    private String last_name;
    private String title;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] teacher_photo;
    private String email;
    private String phone_number;

    private String login;
    private String pass;

    public byte[] getTeacher_photo() {
        return teacher_photo;
    }

    public void setTeacher_photo(byte[] teacher_photo) {
        this.teacher_photo = teacher_photo;
    }

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<LessonYear> lessonsYears;

    public List<LessonYear> getLessonsYears() {
        return lessonsYears;
    }

    public void setLessonsYears(List<LessonYear> lessonsYears) {
        this.lessonsYears = lessonsYears;
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

    public Teacher(){

    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
