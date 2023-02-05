package com.WebSer.institute.Layers.Services;

import com.WebSer.institute.Layers.DTO.StudentDTO;
import com.WebSer.institute.Layers.Exeptions.DataNotFoundException;
import com.WebSer.institute.Layers.Exeptions.InvalidInputException;
import com.WebSer.institute.Layers.Repository.StudentRepository;
import com.WebSer.institute.Layers.domains.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private StudentRepository stRepo;

    public StudentService(StudentRepository stRepo) {
        this.stRepo = stRepo;
    }
    public StudentDTO readStudent(Long id)
    {
        isExist(id);
        Student student = stRepo.getStudent(id);
        return new StudentDTO(student.getName(),student.getStudentNumber(),student.getHoursOfEnrollment());
    }
    public StudentDTO createStudent(StudentDTO studentDTO)
    {
        validHours(studentDTO);

        Student student = stRepo.createStudent(new Student(studentDTO.getName(),studentDTO.getStudentNumber(),studentDTO.getHoursOfEnrollment()));
        return new StudentDTO(student.getName(),student.getStudentNumber(),student.getHoursOfEnrollment());
    }

    public void deleteStudent(Long id)
    {

        isExist(id);
        stRepo.deleteStudent(id);
    }

    public StudentDTO updateStudent(Long id , StudentDTO studentDTO)
    {
        validHours(studentDTO);
        isExist(id);
        Student student = stRepo.updateStudent(id ,new Student(studentDTO.getName(),studentDTO.getStudentNumber(),studentDTO.getHoursOfEnrollment()));
        return new StudentDTO(student.getName(),student.getStudentNumber(),student.getHoursOfEnrollment());

    }
    private void isExist(Long id) {
        if (stRepo.getStudent(id) != null)
        {
            System.out.println("Student with id " + id + " is called");
        }
        else {

            throw new DataNotFoundException("Student does not exist");

        }
    }

    private static void validHours(StudentDTO studentDTO) {
        if(studentDTO.getHoursOfEnrollment() < 1 )
            throw new InvalidInputException("Hours of enrollment should be positive");
    }

}
