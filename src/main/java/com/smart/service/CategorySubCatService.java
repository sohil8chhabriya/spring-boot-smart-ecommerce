package com.smart.service;

import java.util.List;
import org.springframework.validation.annotation.Validated;
import com.smart.model.InputWrapper;
import com.smart.model.SubCategory;

@Validated
public interface CategorySubCatService {
  List<SubCategory> getSubCategoryByCategory(InputWrapper input);
}
