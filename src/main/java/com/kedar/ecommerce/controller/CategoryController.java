package com.kedar.ecommerce.controller;

import com.google.gson.Gson;
import com.kedar.ecommerce.domain.Category;
import com.kedar.ecommerce.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody String body){
        Gson gson = new Gson();
        Category obj = gson.fromJson(body, Category.class);
        return categoryRepository.save(obj);
        //todo: exception handling
    }
}
