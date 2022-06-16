package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day,Long> {
}
