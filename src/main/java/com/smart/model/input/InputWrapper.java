package com.smart.model.input;

import com.smart.model.Category;
import com.smart.model.Product;
import com.smart.model.SubCategory;

public class InputWrapper extends ApiWrapper {
  private Category category;
  private SubCategory subCategory;
  private Product product;

  public Category getCategory() {
    return category;
  }

  public SubCategory getSubCategory() {
    return subCategory;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public void setSubCategory(SubCategory subCategory) {
    this.subCategory = subCategory;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
