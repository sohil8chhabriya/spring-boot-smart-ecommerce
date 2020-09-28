package com.smart.model.input;

public class ApiWrapper {
  private boolean forceAddAttribute;
  private boolean forceAddCategory;
  private boolean forceAddSubCategory;

  public boolean isForceAddAttribute() {
    return forceAddAttribute;
  }

  public boolean isForceAddCategory() {
    return forceAddCategory;
  }

  public boolean isForceAddSubCategory() {
    return forceAddSubCategory;
  }

  public void setForceAddAttribute(boolean forceAddAttribute) {
    this.forceAddAttribute = forceAddAttribute;
  }

  public void setForceAddCategory(boolean forceAddCategory) {
    this.forceAddCategory = forceAddCategory;
  }

  public void setForceAddSubCategory(boolean forceAddSubCategory) {
    this.forceAddSubCategory = forceAddSubCategory;
  }

}
