package com.smart.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.smart.model.InputWrapper;
import com.smart.model.ProductCategory;
import com.smart.model.SubCategory;
import com.smart.repository.CategoryRepository;
import com.smart.repository.ProductCategoryRepository;

@Component
public class CategorySubCatDaoImpl
    implements CategorySubCatDao<InputWrapper, ProductCategory, SubCategory> {

  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  // @Autowired
  // private SubCategoryRepository subCategoryRepository;


  @Override
  public ProductCategory getCategoryOfSubCategory(InputWrapper input) {
    return null;
  }

  @Override
  public List<SubCategory> getSubCategoryByCategory(InputWrapper input) {
    // TODO FIx
    // Category category = categoryRepository.findByName(input.getCategory().getName());
    // ProductCategory c = productCategoryRepository.findById(category.getId());
    // Category c = categoryRepository.getCategoryByName(input.getCategory().getName());
    List<SubCategory> subCategory = new ArrayList<SubCategory>();
    // subCategory.add(c.getSubCategory());
    return subCategory;
  }

}
