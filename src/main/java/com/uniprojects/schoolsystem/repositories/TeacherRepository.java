package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Query(value="select * from Teacher h where h.first_name = :first_name and h.last_name = :last_name",nativeQuery=true)
    Teacher findByFirst_nameAndLast_name(@Param("first_name")String First_name, @Param("last_name") String Last_name);
}
