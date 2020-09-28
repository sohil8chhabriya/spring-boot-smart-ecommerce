package com.smart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smart.model.Product;
import com.smart.model.ProductCategory;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
  // Iterable<Product> getProductsByAttribute(Map<String, String> attribute);

  Iterable<Product> findAllByProductCategory(ProductCategory productCategory);
}
