package com.kedar.ecommerce.service;

import com.kedar.ecommerce.TO.Mapper;
import com.kedar.ecommerce.TO.ProductTO;
import com.kedar.ecommerce.domain.Product;
import com.kedar.ecommerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public ProductTO findById(Long productId){
        return Mapper.toProductTO(productRepository.findById(productId).get());
    }

    public List<ProductTO> findAll(){

        List<ProductTO> productList = new ArrayList<>();

        productRepository.findAll().forEach(product -> productList.add(Mapper.toProductTO(product)));

        return productList;
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
