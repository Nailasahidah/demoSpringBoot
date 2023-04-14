package com.springboot.demospringboot_naila.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    List<Product> selectAllProducts();

    Optional<Product> selectProductById(Long id);

    void insertProduct(Product product);

//    boolean exitsProductWithBarcode(Long barcode);

    boolean exitsProductWithId(Long productId);

    void deleteProductById(Long productId);

    void updateProduct(Product update);

}
