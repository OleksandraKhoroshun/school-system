package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Teacher findByLogin(@Param("login") String login);
}
