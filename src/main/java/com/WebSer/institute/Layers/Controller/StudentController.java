package com.WebSer.institute.Layers.Controller;

import com.WebSer.institute.Layers.DTO.StudentDTO;
import com.WebSer.institute.Layers.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @RequestMapping(method = RequestMethod.GET , path = "/{id}")
    public StudentDTO getStudent(@PathVariable Long id)
    {
        return studentService.readStudent(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO)
    {
        return studentService.createStudent(studentDTO);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO,
                                    @PathVariable Long id)
    {
        return studentService.updateStudent(id, studentDTO);
    }

}
