package com.springboot.demospringboot_naila.Product;

import com.springboot.demospringboot_naila.Exception.DuplicateResourceException;
import com.springboot.demospringboot_naila.Exception.RequestValidationException;
import com.springboot.demospringboot_naila.Exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDao productDao;

    public ProductService(@Qualifier("jpaProduct") ProductDao productDao) {
        this.productDao = productDao;
    }
    public List<Product> getAllProducts() {
        return productDao.selectAllProducts();
    }
    public Product getProducts(Long id) {
        return productDao.selectProductById(id)
                .orElseThrow(() -> new ResourceNotFound(
                        "product with id [%l] not found".formatted(id)
                ));
    }
    public void addProduct(
            ProductRegistrationRequest productRegistrationRequest) {
        Long id = productRegistrationRequest.id();
        if (productDao.exitsProductWithId(productRegistrationRequest.id())) {
            throw new DuplicateResourceException(
                    "customer with email [%s] already exist".formatted(id)
            );
        }
        Product product = new Product(
                productRegistrationRequest.id(),
                productRegistrationRequest.barcode(),
                productRegistrationRequest.nameProduct(),
                productRegistrationRequest.hargaBeli(),
                productRegistrationRequest.hargaJual(),
                productRegistrationRequest.tglKadaluarsa()
        );
        productDao.insertProduct(product);
    }
    public void deleteProductById(Long productId) {
        if (!productDao.exitsProductWithId(productId)) {
            throw new ResourceNotFound(
                    "product with id [%l] not found".formatted(productId)
            );
        }

        productDao.deleteProductById(productId);
    }

    public void updateProduct(
            Long productId, ProductUpdateRequest updateRequest) {
        Product product = getProducts(productId);

        boolean changes = false;
        if(updateRequest.id() != null && !updateRequest.id().equals(product.getId())) {
            product.setId((updateRequest.id()));
            changes = true;
        }

        if(updateRequest.nameProduct() != null && !updateRequest.nameProduct().equals(product.getNameProduct())) {
            product.setNameProduct((updateRequest.nameProduct()));
            changes = true;
        }

        if(updateRequest.hargaBeli() != null && !updateRequest.hargaBeli().equals(product.getHargaBeli())) {
            product.setHargaBeli((updateRequest.hargaBeli()));
            changes = true;
        }

        if(updateRequest.hargaJual() != null && !updateRequest.hargaJual().equals(product.getHargaJual())) {
            product.setHargaJual((updateRequest.hargaJual() ));
            changes = true;
        }


        if(updateRequest.id() != null && !updateRequest.id().equals(product.getId())) {
            if (productDao.exitsProductWithId(updateRequest.id())) {
                throw new DuplicateResourceException(
                        "id already taken"
                );
            }
            product.setId(updateRequest.id());
            changes = true;
        }
        if (!changes) {
            throw new RequestValidationException(
                    "no data changes found"
            );
        }
        productDao.updateProduct(product);
    }

}
