package com.smart.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {
  // Electronics, Apparel, Home, SportingGoods, MedicalHealth;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, updatable = false)
  private String name;

  @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, orphanRemoval = true,
      cascade = CascadeType.ALL)
  private Set<ProductCategory> productCategory = new HashSet<>();

  public Category() {
    super();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

}
