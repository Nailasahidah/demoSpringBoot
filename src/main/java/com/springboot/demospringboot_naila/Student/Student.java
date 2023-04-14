package com.springboot.demospringboot_naila.Student;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Student {
    @Id
    @SequenceGenerator(
            name = "Student_id_sequence",
            sequenceName = "Student_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Student_id_seq"
    )
    private Long id;
    @Column(
            nullable = false
    )
    private Integer nim;
    @Column(
            nullable = false, unique = true
    )
    private String name;
    @Column(
            nullable = false
    )
    private String classroom;
    @Column(
            nullable = false
    )
    private String email;
    @Column(
            nullable = false, unique = true
    )
    private String address;

    public Student() {
    }

    public Student(Long id, Integer nim, String name, String classroom, String email, String address) {
        this.id = id;
        this.nim = nim;
        this.name = name;
        this.classroom = classroom;
        this.email = email;
        this.address = address;
    }

    public Student(Integer nim, String name, String classroom, String email, String address) {
        this.nim = nim;
        this.name = name;
        this.classroom = classroom;
        this.email = email;
        this.address = address;
    }

    public Student(String name, String classroom, String email, String address) {
        this.name = name;
        this.classroom = classroom;
        this.email = email;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(nim, student.nim) && Objects.equals(name, student.name) && Objects.equals(classroom, student.classroom) && Objects.equals(email, student.email) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nim, name, classroom, email, address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nim=" + nim +
                ", name='" + name + '\'' +
                ", classroom='" + classroom + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
