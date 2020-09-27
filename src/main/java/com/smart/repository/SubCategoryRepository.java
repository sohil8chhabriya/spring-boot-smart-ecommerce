package com.smart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.smart.model.SubCategory;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
  SubCategory findByName(String name);
}
