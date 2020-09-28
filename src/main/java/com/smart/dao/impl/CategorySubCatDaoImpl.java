package com.smart.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.smart.dao.api.CategorySubCatDao;
import com.smart.model.Category;
import com.smart.model.SubCategory;
import com.smart.model.input.InputWrapper;
import com.smart.repository.CategoryRepository;
import com.smart.repository.ProductCategoryRepository;
import com.smart.repository.SubCategoryRepository;

@Component
public class CategorySubCatDaoImpl
    implements CategorySubCatDao<InputWrapper, Category, SubCategory> {

  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  @Autowired
  private CategoryDaoImpl categoryDao;

  @Autowired
  private SubCategoryDaoImpl subCategoryDao;


  @Autowired
  private SubCategoryRepository subCategoryRepository;

  @Autowired
  private CategoryRepository categoryRepository;


  @Override
  public Category getCategoryOfSubCategory(InputWrapper input) {
    SubCategory subCategory = subCategoryDao.getByName(input.getSubCategory().getName());
    Category category = new Category();

    if (subCategory != null) {
      category = categoryRepository
          .findByProductCategory(productCategoryRepository.findBySubCategory(subCategory));
    }
    return category;
  }

  @Override
  public Set<String> getSubCategoryAttributes(InputWrapper input) {
    Set<String> attribute = getSubCategoryByCategory(input).get(0).getAttribute();
    return attribute;
  }

  @Override
  public List<SubCategory> getSubCategoryByCategory(InputWrapper input) {
    Category category = categoryDao.getByName(input.getCategory().getName());
    List<SubCategory> subCategory = new ArrayList<SubCategory>();

    if (category != null) {
      productCategoryRepository.findAllByCategory(category)
          .forEach(productCategory -> subCategoryRepository
              .findAllByProductCategory(productCategory).forEach(subCategory::add));
    }
    return subCategory;
  }

}
