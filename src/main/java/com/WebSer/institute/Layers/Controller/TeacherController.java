package com.WebSer.institute.Layers.Controller;

import com.WebSer.institute.Layers.DTO.TeacherDTO;
import com.WebSer.institute.Layers.Services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @RequestMapping(method = RequestMethod.GET , path = "/{id}")
    public TeacherDTO getTeacher(@PathVariable Long id)
    {
        return teacherService.readTeacher(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacherDTO)
    {
        return teacherService.createTeacher(teacherDTO);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable Long id)
    {
        teacherService.deleteTeacher(id);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TeacherDTO updateTeacher(@RequestBody TeacherDTO teacherDTO,
                                    @PathVariable Long id)
    {
        return teacherService.updateTeacher(id, teacherDTO);
    }
}
