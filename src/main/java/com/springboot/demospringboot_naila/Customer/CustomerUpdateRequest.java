package com.springboot.demospringboot_naila.Customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}
