package com.springboot.demospringboot_naila.Customer;

public record CustomerRegistrationRequest (
        String name,
        String email,
        Integer age
) {

}

