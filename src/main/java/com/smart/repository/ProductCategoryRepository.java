package com.smart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smart.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

  // // Iterable<Product> getProductsByAttribute(Map<String, String> attribute);
  //
  // Iterable<Product> getProductsByCategory(Category category);

  // ProductCategory findByName(String name);

  // ProductCategory getCategoryByName(String name);

  // @Query("SELECT pc. FROM ProductCategory pc JOIN pc.category_id cid WHERE cid = :id")
  // Iterable<Product> getProductCategoryById(@Param("id") long id);
}
