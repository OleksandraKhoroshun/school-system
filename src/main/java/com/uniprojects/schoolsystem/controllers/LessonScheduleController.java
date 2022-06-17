package com.uniprojects.schoolsystem.controllers;

import com.uniprojects.schoolsystem.models.Lesson;
import com.uniprojects.schoolsystem.models.LessonSchedule;
import com.uniprojects.schoolsystem.repositories.LessonScheduleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lesson_schedule")
public class LessonScheduleController {
    @Autowired
    private LessonScheduleRepository lessonScheduleRepository;

    @GetMapping
    public List<LessonSchedule> list(){
        return lessonScheduleRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public LessonSchedule get(@PathVariable Long id){
        return lessonScheduleRepository.getReferenceById(id);
    }

    @PostMapping
    public LessonSchedule create(@RequestBody final LessonSchedule lessonSchedule){
        return lessonScheduleRepository.saveAndFlush(lessonSchedule);
    }

    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //possible implementation?
        lessonScheduleRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public LessonSchedule update(@PathVariable Long id, @RequestBody LessonSchedule lessonSchedule){
        //add validation?
        LessonSchedule existingLessonSchedule = lessonScheduleRepository.getReferenceById(id);
        BeanUtils.copyProperties(lessonSchedule,existingLessonSchedule,"lesson_schedule_id");
        return lessonScheduleRepository.saveAndFlush(existingLessonSchedule);
    }
}
