package com.uniprojects.schoolsystem.repositories;

import com.uniprojects.schoolsystem.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<TimeSlot,Long> {
}
