package com.springboot.demospringboot_naila.Student;

import com.springboot.demospringboot_naila.Customer.CustomerController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("{studentId}")
    public Student getStudent(
            @PathVariable("studentId") Integer studentId) {
        return studentService.getStudents(studentId);
    }

    @PostMapping
    public void registerStudent(
            @RequestBody StudentRegistrationRequest request) {
        studentService.addStudent(request);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(
            @PathVariable ("studentId") Integer studentId
    ) {
        studentService.deleteStudentById(studentId);
    }

    @PutMapping("{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Integer studentId,
            @RequestBody StudentUpdateRequest updateRequest
    ) {
        studentService.updateStudent(studentId, updateRequest);
    }
}
