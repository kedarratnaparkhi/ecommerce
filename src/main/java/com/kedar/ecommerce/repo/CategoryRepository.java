package com.kedar.ecommerce.repo;

import com.kedar.ecommerce.domain.Category;
import com.kedar.ecommerce.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Product pr = Product.builder().build();
}
