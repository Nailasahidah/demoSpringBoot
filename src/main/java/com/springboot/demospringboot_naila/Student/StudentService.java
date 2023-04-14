package com.springboot.demospringboot_naila.Student;

import com.springboot.demospringboot_naila.Exception.DuplicateResourceException;
import com.springboot.demospringboot_naila.Exception.RequestValidationException;
import com.springboot.demospringboot_naila.Exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentDao studentDao;

    public StudentService(@Qualifier("jpaStudent") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public Student getStudents(Integer id) {
        return studentDao.selectStudentById(id)
                .orElseThrow(() -> new ResourceNotFound(
                        "student with id [%s] not found".formatted(id)
                ));
    }

    public void addStudent(
            StudentRegistrationRequest studentRegistrationRequest) {
        String email = studentRegistrationRequest.email();
        if (studentDao.existStudentWithEmail(studentRegistrationRequest.email())) {
            throw new DuplicateResourceException(
                    "student with email [%s] already exist".formatted(email)
            );
        }

        //add
        Student student = new Student(
                studentRegistrationRequest.nim(),
                studentRegistrationRequest.name(),
                studentRegistrationRequest.email(),
                studentRegistrationRequest.classroom(),
                studentRegistrationRequest.address()

        );
        studentDao.insertStudent(student);
    }

    public void deleteStudentById(Integer studentId) {
        if (!studentDao.existStudentWithId(studentId)) {
            throw new ResourceNotFound(
                    "student with id [%s] not found".formatted(studentId)
            );
        }

        studentDao.deleteStudentById(studentId);
    }

    public void updateStudent(
            Integer studentId, StudentUpdateRequest updateRequest){
        Student student = getStudents(studentId);

        boolean changes = false;
        if(updateRequest.name() != null && !updateRequest.name().equals(student.getName())) {
            student.setName((updateRequest.name()));
            changes = true;
        }
        if(updateRequest.address() != null && !updateRequest.address().equals(student.getAddress())) {
            student.setAddress((updateRequest.address()));
            changes = true;
        }
        if(updateRequest.classroom() != null && !updateRequest.classroom().equals(student.getClassroom())) {
            student.setClassroom((updateRequest.classroom()));
            changes = true;
        }
        if(updateRequest.nim() != null && !updateRequest.nim().equals(student.getNim())) {
            student.setNim((updateRequest.nim()));
            changes = true;
        }
        if(updateRequest.email() != null && !updateRequest.email().equals(student.getEmail())) {
            if(studentDao.existStudentWithEmail(updateRequest.email())) {
                throw new DuplicateResourceException(
                        "email already taken"
                );
            }
            student.setEmail(updateRequest.email());
            changes = true;
        }
        if (!changes) {
            throw new RequestValidationException(
                    "no data changes found"
            );
        }
        studentDao.updateStudent(student);

    }
}
