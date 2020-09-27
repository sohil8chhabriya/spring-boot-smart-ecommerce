package com.smart.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.smart.exception.ResourceNotFoundException;
import com.smart.model.Category;
import com.smart.repository.CategoryRepository;

@Component
public class CategoryDaoImpl implements Dao<Category> {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public void delete(long id) {
    categoryRepository.deleteById(id);

  }

  @Override
  public Category get(long id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
  }

  @Override
  public Collection<Category> getAll() {
    List<Category> category = new ArrayList<Category>();
    categoryRepository.findAll().forEach(category::add);
    return category;
  }


  public Category getByName(String name) {
    return categoryRepository.findByName(name);
  }

  @Override
  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public Category update(Category category, long l) {
    Category c = categoryRepository.findById(l).orElse(category);
    return categoryRepository.save(c);
  }

}
