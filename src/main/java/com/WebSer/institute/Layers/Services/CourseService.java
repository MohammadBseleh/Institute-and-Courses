package com.WebSer.institute.Layers.Services;

import com.WebSer.institute.Layers.DTO.CourseDTO;
import com.WebSer.institute.Layers.Exeptions.DataNotFoundException;
import com.WebSer.institute.Layers.Exeptions.InvalidInputException;
import com.WebSer.institute.Layers.Repository.CourseRepoForJPA;
import com.WebSer.institute.Layers.Repository.CourseRepository;
import com.WebSer.institute.Layers.domains.Course;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepoForJPA courseRepository;

    public CourseService(CourseRepoForJPA courseRepository) {
        this.courseRepository = courseRepository;
    }
    public CourseDTO readCourse(Long id)
    {
         return courseRepository.findById(id)
                .map(e ->
                        (new CourseDTO(e.getName(),e.getHours()
                           ,e.getLecturer(),e.getStartDate(),e.getEndDate())
                )).orElseThrow(()-> new DataNotFoundException("Course does not exist"));
    }
    public CourseDTO createCourse(CourseDTO courseDTO)
    {
        validDate(courseDTO);
        Course course = courseRepository.save(new Course(courseDTO.getName(),courseDTO.getHours(),
                courseDTO.getLecturer(),courseDTO.getStartDate(),courseDTO.getEndDate()));
        return new CourseDTO(course.getName(),course.getHours(),course.getLecturer(),course.getStartDate(),course.getEndDate());
    }
    public CourseDTO updateCourse(Long id , CourseDTO courseDTO)
    {
        isExist(id);
        validDate(courseDTO);
        return courseRepository.findById(id).map( course -> {
            Course foundCourse = new Course(courseDTO.getName(),courseDTO.getHours(),courseDTO
                    .getLecturer(),courseDTO.getStartDate(),courseDTO.getEndDate());
            foundCourse.setId(course.getId());
            return courseRepository.save(foundCourse);
        }).map(savedCourse -> new CourseDTO(savedCourse.getName(),savedCourse.getHours(),
                savedCourse.getLecturer(),savedCourse.getStartDate(),savedCourse.getEndDate())).
                orElseThrow(()-> new DataNotFoundException("Course does not exist"));
        //Course course = courseRepository.updateCourse(id , new Course(courseDTO.getName(),courseDTO.getHours(),courseDTO.getLecturer(),courseDTO.getStartDate(),courseDTO.getEndDate()));
        //return new CourseDTO(course.getName(),course.getHours(),course.getLecturer(),course.getStartDate(),course.getEndDate());
    }
    public void deleteCourse(Long id)
    {
        isExist(id);
        courseRepository.deleteById(id);
    }

    private void isExist(Long id) {
        courseRepository.findById(id).map(e -> {
            System.out.println("Course with id " + id + " is called");
            return e;
        } ).orElseThrow(()-> new DataNotFoundException("Course does not exist"));

    }

    private void validDate(CourseDTO courseDTO) {
        //Check if the date is valid
        if (courseDTO.getStartDate().isAfter(courseDTO.getEndDate()))
        {
            throw new InvalidInputException("End Date Should be after The start date");
        }
    }

}
