package com.WebSer.institute.Layers.Services;

import com.WebSer.institute.Layers.DTO.CourseDTO;
import com.WebSer.institute.Layers.Exeptions.DataNotFoundException;
import com.WebSer.institute.Layers.Exeptions.InvalidInputException;
import com.WebSer.institute.Layers.Repository.CourseRepoForJPA;
import com.WebSer.institute.Layers.Repository.CourseRepository;
import com.WebSer.institute.Layers.domains.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseServiceTest {
    @InjectMocks
    private CourseService courseService;
    @Mock
    private CourseRepoForJPA courseRepository;

    @BeforeEach
    void setUp(){ MockitoAnnotations.openMocks(this);}

    @Test
    void readCourse() {
        Instant startDate = Instant.now();
        Instant endDate = startDate.plusSeconds(515415);
        when(courseRepository.findById(24L)).thenReturn(Optional.of(new Course("Art220", 2 , "Safa",
                startDate,endDate)));
        CourseDTO courseDTO = courseService.readCourse(24L);
        assertNotNull(courseDTO);
        assertEquals("Art220",courseDTO.getName());
        assertEquals(startDate,courseDTO.getStartDate());
        assertEquals(endDate,courseDTO.getEndDate());
        assertEquals("Safa",courseDTO.getLecturer());
        assertEquals(2,courseDTO.getHours());}

    @Test
    void readCourseThrowsException(){
        when(courseRepository.findById(85L)).thenReturn(Optional.ofNullable(null));
        DataNotFoundException dataNotFoundException = assertThrows(DataNotFoundException.class ,() -> courseService.readCourse(85L));
        assertEquals("Course does not exist" , dataNotFoundException.getMessage());}

    @Test
    void createCourse(){
        Instant startDate = Instant.now();
        Instant endDate = startDate.plusSeconds(556585);
        Course course = new Course("AI85", 4 , "Baraa",startDate,endDate);
        when(courseRepository.save(course)).thenReturn(course);
        CourseDTO courseDTO = courseService.createCourse(new CourseDTO("AI85", 4 , "Baraa",
                startDate,endDate));
        assertNotNull(courseDTO);
        assertEquals("AI85",courseDTO.getName());
        assertEquals(startDate,courseDTO.getStartDate());
        assertEquals(endDate,courseDTO.getEndDate());
        assertEquals("Baraa",courseDTO.getLecturer());
        assertEquals(4,courseDTO.getHours());
        verify(courseRepository,times(1)).save(course);
        }

    @Test
    void createCourseThrowsException(){
        Instant startDate = Instant.now();
        Instant endDate = startDate.minusSeconds(556585);
        Course course = new Course("AI85", 4 , "Baraa",startDate,endDate);
        when(courseRepository.save(course)).thenReturn(course);
        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class ,
                () -> courseService.createCourse(new CourseDTO("AI85", 4 , "Baraa",
                startDate,endDate)));
        assertEquals("End Date Should be after The start date" , invalidInputException.getMessage());
        verify(courseRepository,never()).save(course);
        }

    @Test
    void deleteCourse(){
        Instant startDate = Instant.now();
        Instant endDate = startDate.plusSeconds(515415);
        when(courseRepository.findById(24L)).thenReturn(Optional.of(new Course("Art220", 2 , "Safa",
                startDate,endDate)));
        courseService.deleteCourse(24L);
        when(courseRepository.findById(24L)).thenReturn(Optional.ofNullable(null));
        assertThrows(DataNotFoundException.class,()-> courseService.readCourse(24L));
        verify(courseRepository,times(1)).deleteById(24L);
    }

    @Test
    void deleteCourseThrowsException(){
        // when(courseRepository.getCourse(8552L)).thenReturn(null);
        DataNotFoundException dataNotFoundException = assertThrows(DataNotFoundException.class ,() -> courseService.deleteCourse(8552L));
        assertEquals("Course does not exist" , dataNotFoundException.getMessage());}

    @Test
    void updateCourse(){
        Instant startDate = Instant.now();
        Instant endDate = startDate.plusSeconds(556585);
        Course courseToBeUpdated = new Course("Web", 3 , "Dawod",startDate,endDate);
        when(courseRepository.findById(244L)).thenReturn(Optional.of(new Course("AI85"
                , 4 , "Baraa",startDate,endDate)));
        when(courseRepository.save(courseToBeUpdated)).thenReturn(courseToBeUpdated);
        CourseDTO updatedCourse = courseService.updateCourse(244L,new CourseDTO("Web", 3 , "Dawod",startDate,endDate));
        assertNotNull(updatedCourse);
        assertEquals("Web" , updatedCourse.getName());
        assertEquals(3,updatedCourse.getHours());
        assertEquals("Dawod" , updatedCourse.getLecturer());
        assertEquals(startDate,updatedCourse.getStartDate());
        assertEquals(endDate,updatedCourse.getEndDate());}

    @Test
    void updateCourseThrowsDataNotFoundException(){
        DataNotFoundException dataNotFoundException = assertThrows(DataNotFoundException.class ,
                () ->  courseService.updateCourse(25956L, null));
        assertEquals("Course does not exist" , dataNotFoundException.getMessage());
        verify(courseRepository,never()).save( null);
        }

    @Test
    void updateCourseThrowsInvalidInputException(){
        Instant startDate = Instant.now();
        Instant endDate = startDate.minusSeconds(556585);
        when(courseRepository.findById(4524L)).thenReturn(Optional.of(new Course("AI85", 4 ,
                "Baraa",startDate,endDate)));
        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class ,
                () -> courseService.updateCourse(4524L ,new CourseDTO("AI85", 4 , "Baraa",
                        startDate,endDate)));
        assertEquals("End Date Should be after The start date" , invalidInputException.getMessage());
         verify(courseRepository,never()).save( null);
    }


    }




