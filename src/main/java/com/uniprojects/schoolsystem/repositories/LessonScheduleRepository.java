package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.LessonSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonScheduleRepository extends JpaRepository<LessonSchedule,Long> {

}
