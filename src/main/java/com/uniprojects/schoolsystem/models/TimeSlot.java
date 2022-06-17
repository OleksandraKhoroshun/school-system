package com.uniprojects.schoolsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity(name = "time_slots")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class TimeSlot {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long time_slot_id;

    private Time start_time;
    private Time end_time;
    private boolean is_keynote_time_slot;

    @OneToMany(mappedBy = "timeSlot", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<LessonSchedule> lessonSchedules;

    public List<LessonSchedule> getLessonSchedules() {
        return lessonSchedules;
    }

    public void setLessonSchedules(List<LessonSchedule> lessonSchedules) {
        this.lessonSchedules = lessonSchedules;
    }

    public TimeSlot(){

    }

    public Long getTime_slot_id() {
        return time_slot_id;
    }

    public void setTime_slot_id(Long time_slot_id) {
        this.time_slot_id = time_slot_id;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public boolean isIs_keynote_time_slot() {
        return is_keynote_time_slot;
    }

    public void setIs_keynote_time_slot(boolean is_keynote_time_slot) {
        this.is_keynote_time_slot = is_keynote_time_slot;
    }
}
