package com.smart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.smart.dao.CategorySubCatDaoImpl;
import com.smart.model.InputWrapper;
import com.smart.model.SubCategory;

@Service
@Transactional
public class CategorySubCatServiceImpl implements CategorySubCatService {
  @Autowired
  private CategorySubCatDaoImpl categorySubCatDao;

  @Override
  public List<SubCategory> getSubCategoryByCategory(InputWrapper input) {
    return categorySubCatDao.getSubCategoryByCategory(input);
  }

}
