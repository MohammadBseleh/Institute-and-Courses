package com.WebSer.institute.Layers.Services;

import com.WebSer.institute.Layers.DTO.TeacherDTO;
import com.WebSer.institute.Layers.Exeptions.DataNotFoundException;
import com.WebSer.institute.Layers.Repository.TeacherRepository;
import com.WebSer.institute.Layers.domains.Teacher;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    public TeacherDTO readTeacher(Long id)
    {
        isExist(id);
        Teacher teacher = teacherRepository.getTeacher(id);
        return new TeacherDTO(teacher.getName(),teacher.getWorkingHours(),teacher.isFullTime(),teacher.getCourse());
    }
    public TeacherDTO createTeacher(TeacherDTO teacherDTO)
    {

        Teacher teacher = teacherRepository.createTeacher(new Teacher(teacherDTO.getName(),teacherDTO.getWorkingHours(),teacherDTO.isFullTime(),teacherDTO.getCourse()));
        return new TeacherDTO(teacher.getName(),teacher.getWorkingHours(),teacher.isFullTime(),teacher.getCourse());
    }
    public void deleteTeacher(Long id)
    {
        isExist(id);
        teacherRepository.deleteTeachers(id);
    }
    public TeacherDTO updateTeacher(Long id , TeacherDTO teacherDTO)
    {
        isExist(id);
        Teacher teacher = teacherRepository.updateTeacher(id ,new Teacher(teacherDTO.getName(),teacherDTO.getWorkingHours(),teacherDTO.isFullTime(),teacherDTO.getCourse()));
        return new TeacherDTO(teacher.getName(),teacher.getWorkingHours(),teacher.isFullTime(),teacher.getCourse());

    }

    private void isExist(Long id) {
        if (teacherRepository.getTeacher(id) != null)
        {
            System.out.println("Teacher with id " + id + " is called");
        }
        else {

            throw new DataNotFoundException("Teacher does not exist");

        }
    }
}
