package com.smart.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.smart.dao.api.CategorySubCatDao;
import com.smart.dao.impl.CategorySubCatDaoImpl;
import com.smart.model.Category;
import com.smart.model.SubCategory;
import com.smart.model.input.InputWrapper;

@Service
@Transactional
public class CategorySubCatServiceImpl
    implements CategorySubCatDao<InputWrapper, Category, SubCategory> {
  @Autowired
  private CategorySubCatDaoImpl categorySubCatDao;

  @Override
  public Category getCategoryOfSubCategory(InputWrapper input) {
    return categorySubCatDao.getCategoryOfSubCategory(input);
  }

  @Override
  public Set<String> getSubCategoryAttributes(InputWrapper input) {
    return categorySubCatDao.getSubCategoryAttributes(input);
  }

  @Override
  public List<SubCategory> getSubCategoryByCategory(InputWrapper input) {
    return categorySubCatDao.getSubCategoryByCategory(input);
  }

}
