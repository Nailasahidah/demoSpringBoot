package com.springboot.demospringboot_naila.Student;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpaStudent")
public class StudentJPADataAccessService implements StudentDao{

    public StudentJPADataAccessService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    private final StudentRepository studentRepository;

    @Override
    public List<Student> selectAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> selectStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void insertStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public boolean existStudentWithEmail(String email) {
        return studentRepository.existsStudentByEmail(email);
    }

    @Override
    public boolean existStudentWithId(Integer studentId) {
        return studentRepository.existsStudentById(studentId);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public void updateStudent(Student update) {
        studentRepository.save(update);
    }
}
