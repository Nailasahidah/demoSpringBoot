package com.springboot.demospringboot_naila.Student;

public record StudentRegistrationRequest(
        String name,
        String email,
        String classroom,
        String address,
        Integer nim
) {
}
