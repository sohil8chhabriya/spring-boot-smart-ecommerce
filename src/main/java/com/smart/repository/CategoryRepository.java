package com.smart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smart.model.Category;
import com.smart.model.ProductCategory;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
  Category findByName(String name);

  Category findByProductCategory(ProductCategory productCategory);
}
