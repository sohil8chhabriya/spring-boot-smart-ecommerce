package com.smart.dao;

import java.util.Collection;
import java.util.Set;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CategorySubCatDao<I, C, S> {
  C getCategoryOfSubCategory(I i);

  Set<String> getSubCategoryAttributes(I i);

  Collection<S> getSubCategoryByCategory(I i);
}
