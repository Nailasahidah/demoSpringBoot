package com.springboot.demospringboot_naila.Student;

import com.springboot.demospringboot_naila.Customer.Customer;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    List<Student> selectAllStudents();

    Optional<Student> selectStudentById(Integer id);

    void insertStudent(Student student);

    boolean existStudentWithEmail(String email);

    boolean existStudentWithId(Integer studentId);

    void deleteStudentById(Integer studentId);

    void updateStudent(Student update);
}
