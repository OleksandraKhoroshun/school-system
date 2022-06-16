package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
