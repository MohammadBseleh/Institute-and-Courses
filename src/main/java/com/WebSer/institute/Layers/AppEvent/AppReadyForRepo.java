package com.WebSer.institute.Layers.AppEvent;

import com.WebSer.institute.Layers.Repository.CourseRepository;
import com.WebSer.institute.Layers.Repository.TeacherRepository;
import com.WebSer.institute.Layers.domains.Teacher;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

//@Component
public class AppReadyForRepo {
    private CourseRepository courseRepsitory;
    private TeacherRepository teacherRepository;
    public AppReadyForRepo(CourseRepository courseRepsitory, TeacherRepository teacherRepository) {
        this.courseRepsitory = courseRepsitory;
        this.teacherRepository = teacherRepository;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStart()
    {
        Teacher teacherToBeCreated = new Teacher("Mohammad",8,true,"SWER");
        teacherRepository.createTeacher(teacherToBeCreated);
    }

}
