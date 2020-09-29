package com.smart.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class ProductCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @OneToMany(mappedBy = "productCategory", fetch = FetchType.EAGER, orphanRemoval = true,
      cascade = CascadeType.ALL)
  private Set<Product> products = new HashSet<>();

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "sub_category_id", nullable = false)
  private SubCategory subCategory;

  public ProductCategory() {
    super();
  }

  public Product addProduct(Product product) {
    this.products.add(product);
    product.setProductCategory(this);
    return product;
  }

  public Category getCategory() {
    return category;
  }

  public Long getId() {
    return id;
  }


  public SubCategory getSubCategory() {
    return subCategory;
  }

  public void removeProduct(Product product) {
    product.setProductCategory(null);
    this.products.remove(product);
  }

  public void removeProducts() {
    Iterator<Product> iterator = this.products.iterator();

    while (iterator.hasNext()) {
      Product product = iterator.next();

      product.setProductCategory(null);
      iterator.remove();
    }
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setSubCategory(SubCategory subCategory) {
    this.subCategory = subCategory;
  }

}
