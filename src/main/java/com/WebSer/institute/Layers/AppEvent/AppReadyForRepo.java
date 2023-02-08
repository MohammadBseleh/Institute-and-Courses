package com.WebSer.institute.Layers.AppEvent;

import com.WebSer.institute.Layers.Repository.CourseRepoForJPA;
import com.WebSer.institute.Layers.Repository.CourseRepository;
import com.WebSer.institute.Layers.Repository.TeacherRepository;
import com.WebSer.institute.Layers.domains.Course;
import com.WebSer.institute.Layers.domains.Teacher;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppReadyForRepo {
    private final CourseRepoForJPA courseRepsitory;
    private TeacherRepository teacherRepository;
    public AppReadyForRepo(CourseRepoForJPA courseRepsitory) {
        this.courseRepsitory = courseRepsitory;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStart()
    {
        Course course = courseRepsitory.findById(16L).get();
        System.out.println(course);
        System.out.println("SSSS");

    }

}
