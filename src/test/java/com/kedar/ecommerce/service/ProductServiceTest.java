package com.kedar.ecommerce.service;

import com.kedar.ecommerce.domain.Product;
import com.kedar.ecommerce.domain.Supplier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

//    @Test
//    public void saveProductTest(){
//        Product product = Product.builder()
//                                .category(Supplier.SupplierType.ELECTRONICS)
//                                .createDate(new Date())
//                                .description("THis is a test description")
//                                .name("Prod 1")
//                                .price(200.00)
//                                .stock(100)
//                                .suppliers(getExistingSupplier())
//                                .weight(20.99).build();
//
//        productService.saveProduct(product);
//    }

//    private List<Supplier> getExistingSupplier(){
//        List<Supplier> supplierList = new ArrayList<>();
//        supplierList.add(supplierService.findById(1L));
//        supplierList.add(supplierService.findById(2L));
//        supplierList.add(supplierService.findById(5L));
//        supplierList.add(supplierService.findById(6L));
//
//        return supplierList;
//    }

//    @Test
//    @Transactional
//    public void fetchProducts(){
//        Long productId = 1552L;
//
//        Product product = productService.findById(productId);
//
//        Assertions.assertThat(product.getSuppliers()).isNotEmpty();
//    }

}
