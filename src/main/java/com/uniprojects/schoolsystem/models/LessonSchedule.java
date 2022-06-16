package com.uniprojects.schoolsystem.models;

import javax.persistence.*;
import java.sql.Time;

@Entity(name="lesson_schedule")
public class LessonSchedule {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long schedule_id;

    private String room;

    @ManyToOne
    @JoinColumn(name="time_slot_id")
    private TimeSlot timeSlot;
    @ManyToOne
    @JoinColumn(name="day_id")
    private Day day;
    @ManyToOne
    @JoinColumn(name="lesson_year_id")
    private LessonYear lessonYear;

    public LessonSchedule(){

    }

    public Long getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Long schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public LessonYear getLessonYear() {
        return lessonYear;
    }

    public void setLessonYear(LessonYear lessonYear) {
        this.lessonYear = lessonYear;
    }
}
