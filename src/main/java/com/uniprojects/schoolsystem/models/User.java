package com.uniprojects.schoolsystem.models;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class User {
    private String usertype;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;

    private String login;
    private String pass;

    public static UserType getUserType(String login){
        String GET_URL = "http://localhost:8080/api/v1/students/login/" + login;

        User user;
        RestTemplate restTemplate = new RestTemplate();
        try {
            user = restTemplate.getForObject(GET_URL, Student.class);
            if(user!=null)return UserType.Student;
        } catch (HttpClientErrorException ex) {

        }
        GET_URL = "http://localhost:8080/api/v1/teachers/login/" + login;

        try {
            user = restTemplate.getForObject(GET_URL, Teacher.class);
            if(user!=null) return UserType.Teacher;
        } catch (HttpClientErrorException ex1) {

        }
        return null;
    }

        public UserType getUsertype() {
        return UserType.fromString(usertype);
    }

    public void setUsertype(String userType) {
        this.usertype = userType;
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

    public abstract List<Lesson> getLessons();
}
