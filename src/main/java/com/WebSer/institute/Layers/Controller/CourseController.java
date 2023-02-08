package com.WebSer.institute.Layers.Controller;

import com.WebSer.institute.Layers.DTO.CourseDTO;
import com.WebSer.institute.Layers.Services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
     private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET , path = "/{id}")
    public CourseDTO getCourse(@PathVariable Long id) {return courseService.readCourse(id);}

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO)
    {
        return courseService.createCourse(courseDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id)
    {
         courseService.deleteCourse(id);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO,
                                  @PathVariable Long id)
    {
        return courseService.updateCourse(id,courseDTO);
    }

}
