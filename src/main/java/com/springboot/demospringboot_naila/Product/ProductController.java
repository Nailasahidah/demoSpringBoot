package com.springboot.demospringboot_naila.Product;


import com.springboot.demospringboot_naila.Student.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("{productId}")
    public Product getProduct(
            @PathVariable("productId") Long productId) {
        return productService.getProducts(productId);
    }

    @PostMapping
    public void registerProduct(
            @RequestBody ProductRegistrationRequest request) {
        productService.addProduct(request);
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(
            @PathVariable("productId") Long productId) {
        productService.deleteProductById(productId);
    }
    @PutMapping("{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestBody ProductUpdateRequest updateRequest
    ) {
        productService.updateProduct(productId, updateRequest);
    }
}
