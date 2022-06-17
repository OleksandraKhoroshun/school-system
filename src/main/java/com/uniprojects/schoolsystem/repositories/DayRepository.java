package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DayRepository extends JpaRepository<Day,Long> {
    @Query(value="select * from Day h where h.day_name = :day_name",nativeQuery=true)
    Day findByDay_name(@Param("day_name") String day_name);
}
