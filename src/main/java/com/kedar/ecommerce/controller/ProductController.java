package com.kedar.ecommerce.controller;

import com.google.gson.Gson;
import com.kedar.ecommerce.Exception.DataValidationException;
import com.kedar.ecommerce.TO.ProductTO;
import com.kedar.ecommerce.domain.Product;
import com.kedar.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private ProductService productService;

    @Autowired
    ProductController(ProductService productService){
        this.productService = productService;
    }

    Gson gson = new Gson();

    @GetMapping(path = "/")
    public List<ProductTO> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ProductTO getproductById(@PathVariable Long id){
        return productService.findById(id);
    }


    @PostMapping("/add")
    public Product addproduct(@RequestBody String requestBody) throws DataValidationException {
        Product productToBeSaved = gson.fromJson(requestBody, Product.class);
        return productService.saveProduct(productToBeSaved);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProduct(@PathVariable Long id) throws DataValidationException {
        try{
            productService.deleteProduct(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
