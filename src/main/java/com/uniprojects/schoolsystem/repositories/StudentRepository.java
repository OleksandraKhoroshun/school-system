package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByLoginAndPass(@Param("login") String login,@Param("pass") String pass);
}
