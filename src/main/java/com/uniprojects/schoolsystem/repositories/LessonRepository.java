package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
}
