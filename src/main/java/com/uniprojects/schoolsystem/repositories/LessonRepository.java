package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
    @Query(value="select * from Lesson h where h.lesson_name = :lesson_name",nativeQuery=true)
    Lesson findByLesson_name(@Param("lesson_name") String Lesson_name);
}
