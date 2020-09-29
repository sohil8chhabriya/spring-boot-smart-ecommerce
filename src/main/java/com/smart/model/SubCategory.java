package com.smart.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SubCategory {
  // Mobile, Laptop, Tablet, Shorts, Tshirt, Table, Chair, Dumbles, Ring, YogaMat, HealthDrink,
  // Bandaid,
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String name;

  @OneToMany(mappedBy = "subCategory", fetch = FetchType.EAGER, orphanRemoval = true,
      cascade = CascadeType.ALL)
  private Set<ProductCategory> productCategory = new HashSet<>();

  @ElementCollection(fetch = FetchType.EAGER)
  private Set<String> attribute = new HashSet<String>();

  public SubCategory() {
    super();
  }

  public Set<String> getAttribute() {
    return attribute;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setAttribute(Set<String> attribute) {
    this.attribute.addAll(attribute);
  }

  public void setAttribute(String attribute) {
    this.attribute.add(attribute);
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
