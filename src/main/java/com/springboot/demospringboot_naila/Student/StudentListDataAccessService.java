package com.springboot.demospringboot_naila.Student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("listStudent")
public class StudentListDataAccessService implements StudentDao{

    private static List<Student> students;

    static {
        students = new ArrayList<>();
        Student naila = new Student(
                1,
                "Naila sahidah",
                "LAB2",
                "naila@gmail.com",
                "Cikijing"
        );
        students.add(naila);

        students = new ArrayList<>();
        Student nayra = new Student(
                2,
                "Nayra Sajdah",
                "LAB2",
                "nayra@gmail.com",
                "Cikampek"
        );
        students.add(nayra);

    }
    @Override
    public List<Student> selectAllStudents() {
        return students;
    }

    @Override
    public Optional<Student> selectStudentById(Integer id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public void insertStudent(Student student) {
        students.add(student);
    }

    @Override
    public boolean existStudentWithEmail(String email) {
        return students.stream()
                .allMatch(student -> student.getEmail().equals(email));
    }

    @Override
    public boolean existStudentWithId(Integer studentId) {
        return students.stream()
                .anyMatch(student -> student.getId().equals(studentId));
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        students.stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst()
                .ifPresent(students::remove);
    }

    @Override
    public void updateStudent(Student student) {
        students.add(student);
    }
}
