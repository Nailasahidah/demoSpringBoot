package com.springboot.demospringboot_naila.Product;

import java.util.Date;

public record ProductRegistrationRequest(
        Long id,
        Long barcode,
        String nameProduct,
        Integer hargaBeli,
        Integer hargaJual,
        Date tglKadaluarsa
) {
}
