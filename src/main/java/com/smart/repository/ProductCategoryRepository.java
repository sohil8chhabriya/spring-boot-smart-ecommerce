package com.smart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smart.model.Category;
import com.smart.model.ProductCategory;
import com.smart.model.SubCategory;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

  // Iterable<Product> getProductsByAttribute(Map<String, String> attribute);

  Iterable<ProductCategory> findAllByCategory(Category category);

  Iterable<ProductCategory> findAllBySubCategory(SubCategory subCategory);

  ProductCategory findBySubCategory(SubCategory subCategory);

}
