package com.springboot.demospringboot_naila.Product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository("listProduct")
public class ProductListDataAccessService implements ProductDao {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
        Product wafer = new Product(
                1l,
                12023l,
                "nabati",
                4500,
                5000
        );
        products.add(wafer);

        Product susu = new Product(
                2l,
                22023l,
                "indomilk",
                3000,
                3500
        );
        products.add(susu);
    }

    @Override
    public List<Product> selectAllProducts() {
        return products;
    }
    @Override
    public Optional<Product> selectProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public void insertProduct(Product product) {
        products.add(product);
    }

    @Override
    public boolean exitsProductWithId(Long productId) {
        return products.stream()
                .allMatch(product -> product.getId().equals(productId));
    }

    @Override
    public void deleteProductById(Long productId) {
        products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .ifPresent(products::remove);
    }

    @Override
    public void updateProduct(Product product) {
        products.add(product);
    }
}
