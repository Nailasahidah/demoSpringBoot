package com.springboot.demospringboot_naila.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
    boolean existsProductById(Long id);
}
