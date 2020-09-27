package com.smart.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smart.dao.CategorySubCatDaoImpl;
import com.smart.model.Category;
import com.smart.model.InputWrapper;
import com.smart.model.SubCategory;

@RestController
@RequestMapping(headers = "Accept=application/json", produces = "application/json",
    path = "/api/find/")
public class CategorySubCatController {

  @Autowired
  private CategorySubCatDaoImpl categorySub;

  @GetMapping(value = {"/category"})
  public Category getCategoryBySubCategory(@RequestBody InputWrapper input) {
    return categorySub.getCategoryOfSubCategory(input);
  }

  @GetMapping(value = {"/subcategory/attributes"})
  public Set<String> getSubCategoryAttributes(@RequestBody InputWrapper input) {
    return categorySub.getSubCategoryAttributes(input);
  }

  @GetMapping(value = {"/subcategory"})
  public List<SubCategory> getSubCategoryByCategory(@RequestBody InputWrapper input) {
    return categorySub.getSubCategoryByCategory(input);
  }

}
