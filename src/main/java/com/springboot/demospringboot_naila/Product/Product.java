package com.springboot.demospringboot_naila.Product;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_seq"
    )
    private Long id;
    @Column(
            nullable = false,
            unique = true
    )
    private Long barcode;
    private String nameProduct;
    @Column(
            nullable = false
    )
    private Integer hargaBeli;
    private Integer hargaJual;
    private Date tglKadaluarsa;

    public Product() {
    }

    public Product(Long id, Long barcode, String nameProduct, Integer hargaBeli, Integer hargaJual, Date tglKadaluarsa) {
        this.id = id;
        this.barcode = barcode;
        this.nameProduct = nameProduct;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.tglKadaluarsa = tglKadaluarsa;
    }

    public Product(Long barcode, String nameProduct, Integer hargaBeli, Integer hargaJual, Date tglKadaluarsa) {
        this.barcode = barcode;
        this.nameProduct = nameProduct;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.tglKadaluarsa = tglKadaluarsa;
    }

    public Product(Long id, Long barcode, String nameProduct, Integer hargaBeli, Integer hargaJual) {
        this.id = id;
        this.barcode = barcode;
        this.nameProduct = nameProduct;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(Integer hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public Integer getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Integer hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Date getTglKadaluarsa() {
        return tglKadaluarsa;
    }

    public void setTglKadaluarsa(Date tglKadaluarsa) {
        this.tglKadaluarsa = tglKadaluarsa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(barcode, product.barcode) &&
                Objects.equals(nameProduct, product.nameProduct) && Objects.equals(hargaBeli, product.hargaBeli)
                && Objects.equals(hargaJual, product.hargaJual) && Objects.equals(tglKadaluarsa, product.tglKadaluarsa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, barcode, nameProduct, hargaBeli, hargaJual, tglKadaluarsa);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", barcode=" + barcode +
                ", nameProduct='" + nameProduct + '\'' +
                ", hargaBeli=" + hargaBeli +
                ", hargaJual=" + hargaJual +
                ", tglKadaluarsa=" + tglKadaluarsa +
                '}';
    }
}
