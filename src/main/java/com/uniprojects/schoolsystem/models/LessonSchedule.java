package com.uniprojects.schoolsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;

@Entity(name="lesson_schedule")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class LessonSchedule {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long schedule_id;

    private String room;
    private String topic;
    private String task;

    @ManyToOne
    @JoinColumn(name="time_slot_id")
    private TimeSlot timeSlot;
    @ManyToOne
    @JoinColumn(name="day_id")
    private Day day;
    @ManyToOne
    @JoinColumn(name="lesson_year_id")
    private LessonYear lessonYear;
    @ManyToOne
    @JoinColumn(name="assignment_id")
    private Assignment assignment;

    public LessonSchedule(){

    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
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

    public String toString() {
        return "Topic: " + topic + ", due " + day.getDay_name();
    }
}
