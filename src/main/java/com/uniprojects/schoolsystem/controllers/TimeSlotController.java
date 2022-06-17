package com.uniprojects.schoolsystem.controllers;

import com.uniprojects.schoolsystem.models.TimeSlot;
import com.uniprojects.schoolsystem.repositories.TimeSlotRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/time_slots")
public class TimeSlotController {
    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @GetMapping
    public List<TimeSlot> list(){
        return timeSlotRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public TimeSlot get(@PathVariable Long id){
        return timeSlotRepository.getReferenceById(id);
    }


    @PostMapping
    public TimeSlot create(@RequestBody final TimeSlot timeSlot){
        return timeSlotRepository.saveAndFlush(timeSlot);
    }

    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //possible implementation?
        timeSlotRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public TimeSlot update(@PathVariable Long id, @RequestBody TimeSlot timeSlot){
        //add validation?
        TimeSlot existingTimeSlot = timeSlotRepository.getReferenceById(id);
        BeanUtils.copyProperties(timeSlot,existingTimeSlot,"time_slot_id");
        return timeSlotRepository.saveAndFlush(existingTimeSlot);
    }
}
