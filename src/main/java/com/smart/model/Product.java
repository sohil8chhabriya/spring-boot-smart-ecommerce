package com.smart.model;

import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Product name is required.")
  @Basic(optional = false)
  @Size(max = 100, message = "product name should be less than 100")
  private String name;

  @NotNull(message = "Product description is required.")
  @Basic(optional = false)
  @Size(max = 400, message = "Product description should be less than 400")
  private String description;

  private Double price;

  private String pictureUrl;

  @Enumerated(EnumType.STRING)
  @Column(name = "category_type")
  private Category category;

  @Enumerated(EnumType.STRING)
  @Column(name = "sub_category_type")
  private SubCategory subCategory;

  @ElementCollection(targetClass = String.class)
  private Map<String, String> attribute;

  public Map<String, String> getAttribute() {
    return attribute;
  }

  public Category getCategory() {
    return category;
  }

  public String getDescription() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPictureUrl() {
    return pictureUrl;
  }

  public Double getPrice() {
    return price;
  }

  public SubCategory getSubCategory() {
    return subCategory;
  }

  public void setAttribute(Map<String, String> attribute) {
    this.attribute = attribute;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setSubCategory(SubCategory subCategory) {
    this.subCategory = subCategory;
  }
}
