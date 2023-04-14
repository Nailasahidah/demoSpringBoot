package com.springboot.demospringboot_naila.Student;

public record StudentUpdateRequest (
        Integer nim,
        String name,
        String classroom,
        String email,
        String address
){
}
