package com.WebSer.institute.Layers.AppEvent;

import com.WebSer.institute.Layers.DTO.CourseDTO;
import com.WebSer.institute.Layers.DTO.StudentDTO;
import com.WebSer.institute.Layers.Services.CourseService;
import com.WebSer.institute.Layers.Services.StudentService;
import com.WebSer.institute.Layers.domains.Teacher;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class AppReadyForService {
    public StudentService studentService;
    public CourseService courseService;

    public AppReadyForService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStart()
    {
        try {


        }catch (RuntimeException e)
        {
        }
    }
}
