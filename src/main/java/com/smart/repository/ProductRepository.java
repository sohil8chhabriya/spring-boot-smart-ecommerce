package com.smart.repository;

import java.util.Map;
import org.springframework.data.repository.CrudRepository;
import com.smart.model.Category;
import com.smart.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
  Iterable<Product> getProductsByAttribute(Map<String, String> attribute);

  Iterable<Product> getProductsByCategory(Category category);
}
