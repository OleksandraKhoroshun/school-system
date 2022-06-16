package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
