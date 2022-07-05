package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
}
