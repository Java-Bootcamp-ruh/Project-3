package com.example.demo.Time;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(path="time")
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping
    public List<Time> getTimes(){
        return timeService.getTimes();

    }

    @GetMapping("/{id}")
    public Time getTime(@PathVariable String id){
        return timeService.getTime(id);

    }


//    @PutMapping("/{id}")
//    public void updateTime(@PathVariable String id, @RequestBody Time data){
//
//        timeService.updateTime(id, data);
//    }

    @PostMapping()
    public Time addTime(@RequestBody Form form){
        return timeService.saveTime(form.getTime(),form.getIdDoctor());
    }


}


class Form{
    private Time time;
    private Long idDoctor;

    public Long getIdDoctor() {return idDoctor;}
    public Time getTime(){return time;}



}
