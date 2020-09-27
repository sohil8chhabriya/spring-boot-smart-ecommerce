package com.smart.dao;

import java.util.List;

public interface CategorySubCatDao<I, C, S> {
  C getCategoryOfSubCategory(I i);

  List<S> getSubCategoryByCategory(I i);
}
