package com.uniprojects.schoolsystem.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long student_id;

    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year_id;

    public Year getYear_id() {
        return year_id;
    }

    public void setYear_id(Year year_id) {
        this.year_id = year_id;
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
