package com.kedar.ecommerce.service;

import com.kedar.ecommerce.domain.Address;
import com.kedar.ecommerce.domain.Supplier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SupplierServiceTest {

    @Autowired
    SupplierService supplierService;

    @Autowired
    AddressService addressService;


    @Test
    public void saveSupplier(){

        String samplePostCode = "411021";
        List<Address> addressList = addressService.findByPostCode(samplePostCode);

        Supplier supplier = Supplier.builder()
                            .companyName("Random Co. Ltd")
                            .contactName("Harish")
                            .contactNumber("098765431")
                            .currency("INR")
                            .type(Supplier.SupplierType.COSMETICS)
                            .address(addressList.get(0)).build();

        Assertions.assertThat(supplierService.save(supplier).getId()).isNotNull();
    }

//    @Test
//    @Transactional
//    public void fetchSupplier(){
//        Long supplierId = 6L;
//
//        Supplier supplier = supplierService.findById(supplierId);
//
//        Assertions.assertThat(supplier.getProducts()).isNotEmpty();
//
//    }

}
