package com.smart.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.smart.exception.ResourceNotFoundException;
import com.smart.model.SubCategory;
import com.smart.repository.SubCategoryRepository;

@Component
public class SubCategoryDaoImpl implements Dao<SubCategory> {

  @Autowired
  private SubCategoryRepository subCategoryRepository;

  @Override
  public void delete(long id) {
    subCategoryRepository.deleteById(id);
  }

  @Override
  public SubCategory get(long id) {
    return subCategoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Sub Category not found"));
  }

  @Override
  public Collection<SubCategory> getAll() {
    List<SubCategory> subCategory = new ArrayList<SubCategory>();
    subCategoryRepository.findAll().forEach(subCategory::add);
    return subCategory;
  }


  public SubCategory getByName(String name) {
    return subCategoryRepository.findByName(name);
  }

  @Override
  public SubCategory save(SubCategory subCategory) {
    return subCategoryRepository.save(subCategory);
  }

  @Override
  public SubCategory update(SubCategory subCategory, long l) {
    SubCategory c = subCategoryRepository.findById(l).orElse(subCategory);
    return subCategoryRepository.save(c);
  }

}
