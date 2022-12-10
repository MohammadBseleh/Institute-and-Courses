package com.WebSer.institute.Layers.AppEvent;

import com.WebSer.institute.Layers.Repository.CourseRepository;
import com.WebSer.institute.Layers.domains.Course;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppReady {
    private CourseRepository courseRepsitory;

    public AppReady(CourseRepository courseRepsitory) {
        this.courseRepsitory = courseRepsitory;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStart()
    {
        Course course = courseRepsitory.getCourse(2l);
        System.out.println(course);
        
    }

}
