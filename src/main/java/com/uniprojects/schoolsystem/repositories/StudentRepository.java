package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value="select * from Student h where h.first_name = :first_name and h.last_name = :last_name",nativeQuery=true)
    Student findByFirst_nameAndLast_name(@Param("first_name") String First_name,@Param("last_name") String Last_name);
}
