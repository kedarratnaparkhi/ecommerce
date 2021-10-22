package com.kedar.ecommerce.service;

import com.kedar.ecommerce.domain.Product;
import com.kedar.ecommerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Product findById(Long productId){
        return productRepository.findById(productId).get();
    }

    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
