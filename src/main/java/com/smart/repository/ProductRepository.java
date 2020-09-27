package com.smart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smart.model.Product;
import com.smart.model.ProductCategory;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
  // Iterable<Product> getProductsByAttribute(Map<String, String> attribute);

  // @Query("select p from Person p join fetch p.organisation o")
  // List<Person> findAll();
  // @Query("SELECT p FROM Product p JOIN p.productCategory.id pc WHERE pc = :id")
  // Iterable<Product> getProductsByCategory(@Param("id") long id);

  Iterable<Product> findAllByProductCategory(ProductCategory productCategory);
}
