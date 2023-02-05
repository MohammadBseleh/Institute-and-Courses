package com.WebSer.institute.Layers.Services;

import com.WebSer.institute.Layers.DTO.CourseDTO;
import com.WebSer.institute.Layers.Exeptions.DataNotFoundException;
import com.WebSer.institute.Layers.Exeptions.InvalidInputException;
import com.WebSer.institute.Layers.Repository.CourseRepository;
import com.WebSer.institute.Layers.domains.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public CourseDTO readCourse(Long id)
    {
        isExist(id);
        Course course = courseRepository.getCourse(id);
        return new CourseDTO(course.getName(),course.getHours(),course.getLecturer(),course.getStartDate(),course.getEndDate());

    }
    public CourseDTO createCourse(CourseDTO courseDTO)
    {
        validDate(courseDTO);
        Course course = courseRepository.createCourse(new Course(courseDTO.getName(),courseDTO.getHours(),courseDTO.getLecturer(),courseDTO.getStartDate(),courseDTO.getEndDate()));
        return new CourseDTO(course.getName(),course.getHours(),course.getLecturer(),course.getStartDate(),course.getEndDate());
    }
    public CourseDTO updateCourse(Long id , CourseDTO courseDTO)
    {
        isExist(id);
        validDate(courseDTO);
        Course course = courseRepository.updateCourse(id , new Course(courseDTO.getName(),courseDTO.getHours(),courseDTO.getLecturer(),courseDTO.getStartDate(),courseDTO.getEndDate()));
        return new CourseDTO(course.getName(),course.getHours(),course.getLecturer(),course.getStartDate(),course.getEndDate());

    }
    public void deleteCourse(Long id)
    {
            isExist(id);
            courseRepository.deleteCourse(id);
    }

    private void isExist(Long id) {
        if (courseRepository.getCourse(id) != null)
        {
            System.out.println("Course with id " + id + " is called");
        }
        else {
            throw new DataNotFoundException("Course does not exist");
        }
    }

    private void validDate(CourseDTO courseDTO) {
        //Check if the date is valid
        if (courseDTO.getStartDate().isAfter(courseDTO.getEndDate()))
        {
            throw new InvalidInputException("End Date Should be after The start date");
        }
    }

}
