package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Year;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepository extends JpaRepository<Year,Long> {
}
