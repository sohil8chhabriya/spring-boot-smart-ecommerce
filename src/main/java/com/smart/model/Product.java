package com.smart.model;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Product name is required.")
  @Basic(optional = false)
  @Size(max = 100, message = "Product name should be less than 100")
  private String name;

  @NotNull(message = "Product description is required.")
  @Basic(optional = false)
  @Size(max = 400, message = "Product description should be less than 400")
  private String description;

  private Double price;

  private String pictureUrl;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "product_category_id", nullable = false)
  private ProductCategory productCategory;

  @ElementCollection(fetch = FetchType.EAGER)
  private Map<String, String> attribute = new HashMap<String, String>();

  public Map<String, String> getAttribute() {
    return attribute;
  }

  public String getDescription() {
    return description;
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

  public ProductCategory getProductCategory() {
    return productCategory;
  }

  public void setAttribute(Map<String, String> attribute) {
    attribute.forEach((k, v) -> this.attribute.put(k, v));
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

  public void setProductCategory(ProductCategory productCategory) {
    this.productCategory = productCategory;
  }
}
