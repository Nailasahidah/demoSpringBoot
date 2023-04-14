package com.springboot.demospringboot_naila.Product;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpaProduct")
public class ProductJPADataAccessService implements ProductDao {
    public ProductJPADataAccessService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private final ProductRepository productRepository;

    @Override
    public List<Product> selectAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Optional<Product> selectProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void insertProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public boolean exitsProductWithId(Long productId) {
        return productRepository.existsProductById(productId);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void updateProduct(Product update) {
        productRepository.save(update);
    }
}
