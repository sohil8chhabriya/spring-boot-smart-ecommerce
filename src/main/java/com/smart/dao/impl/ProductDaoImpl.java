package com.smart.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.smart.dao.api.Dao;
import com.smart.dao.api.ProductCatDao;
import com.smart.exception.ResourceNotFoundException;
import com.smart.model.Category;
import com.smart.model.Product;
import com.smart.model.ProductCategory;
import com.smart.model.SubCategory;
import com.smart.model.input.InputWrapper;
import com.smart.repository.ProductCategoryRepository;
import com.smart.repository.ProductRepository;

@Component
public class ProductDaoImpl
    implements Dao<Product, InputWrapper>, ProductCatDao<Product, InputWrapper> {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  @Autowired
  private SubCategoryDaoImpl subCategoryDao;

  @Autowired
  private CategoryDaoImpl categoryDao;

  // Add Attribute to subcategory
  private SubCategory addAttribute(SubCategory subCategory, Set<String> productAttributesKey,
      boolean forceAttribute) {
    if (forceAttribute) {
      // Add directly if forceAddAttribute is true
      subCategory.setAttribute(productAttributesKey);
    } else if (productAttributesKey != null && productAttributesKey.size() > 0) {
      // Don't Allow to add disAllowed Attributes unless forceAddAttribute is true
      Set<String> productAttr_temp = new HashSet<String>();
      productAttr_temp.addAll(productAttributesKey);
      productAttr_temp.removeAll(subCategory.getAttribute());
      if (productAttr_temp.size() > 0) {
        throw new ResourceNotFoundException("Attributes not Allowed " + productAttr_temp.toString()
            + ". Allowed Attributes: " + subCategory.getAttribute().toString()
            + ". To add new attribute to the subCategory " + subCategory.getName()
            + " use forceAddAttribute=true");
      }
    } else {
      throw new ResourceNotFoundException("Attributes not found. Required Attributes: ("
          + subCategory.getAttribute().toString() + ") To add new use forceAddAttribute=true");
    }

    return subCategory;
  }

  private Category addCategory(Product product, boolean forceCategory) {
    Category category = categoryDao.getByName(product.getProductCategory().getCategory().getName());

    if (forceCategory) {
      if (category == null) {
        category = new Category();
        category.setName(product.getProductCategory().getCategory().getName());
        category = categoryDao.save(product.getProductCategory().getCategory());
      }
    } else if (category == null) {
      throw new ResourceNotFoundException("Category not found. To add use forceAddCategory=true");
    }

    return category;
  }

  private ProductCategory addProductCategory(Category category, SubCategory subCategory) {
    ProductCategory productCategory = new ProductCategory();
    productCategory.setCategory(category);
    productCategory.setSubCategory(subCategory);

    productCategory = productCategoryRepository.save(productCategory);
    return productCategory;
  }

  private SubCategory addSubCategory(Product product, boolean forceSubCategory,
      boolean forceAttribute) {

    SubCategory subCategory =
        subCategoryDao.getByName(product.getProductCategory().getSubCategory().getName());

    if (forceSubCategory) {
      if (subCategory == null) {
        // if forceAddSubCategory = true, does not matter wither or not forceAddAttribute is true.
        subCategory = new SubCategory();
        subCategory.setName(product.getProductCategory().getSubCategory().getName());
        subCategory = addAttribute(subCategory, product.getAttribute().keySet(), true);
        subCategory = subCategoryDao.save(subCategory);
      } else {
        subCategory = addAttribute(subCategory, product.getAttribute().keySet(), forceAttribute);
      }
    } else if (subCategory == null) {
      throw new ResourceNotFoundException(
          "Sub Category not found. To add use forceAddSubCategory=true");
    } else {
      subCategory = addAttribute(subCategory, product.getAttribute().keySet(), forceAttribute);
    }

    return subCategory;
  }

  @Override
  public void delete(long id) {
    productRepository.deleteById(id);
  }

  @Override
  public Product get(long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
  }

  @Override
  public List<Product> getAll() {
    List<Product> products = new ArrayList<Product>();
    productRepository.findAll().forEach(products::add);
    return products;
  }


  @Override
  public List<Product> getProductsByCategoryName(InputWrapper input) {
    Category category = categoryDao.getByName(input.getCategory().getName());
    List<Product> products = new ArrayList<Product>();

    if (category != null) {
      productCategoryRepository.findAllByCategory(category)
          .forEach(p -> productRepository.findAllByProductCategory(p).forEach(products::add));
    }
    return products;
  }

  // Returns only those product attributes that are allowed in the subcategory.
  private Map<String, String> removeDisAllowedAttribute(Map<String, String> productAttribute,
      Set<String> categoryAttribute) {
    Map<String, String> productAttributeNew = new HashMap<String, String>();
    categoryAttribute.forEach(i -> productAttributeNew.put(i, productAttribute.get(i)));
    return productAttributeNew;
  }

  @Override
  public Product save(Product product) {
    InputWrapper input = new InputWrapper();
    input.setProduct(product);
    input.setForceAddAttribute(true);
    input.setForceAddCategory(true);
    input.setForceAddSubCategory(true);
    return saveWrapper(input);
  }

  @Override
  public Product saveWrapper(InputWrapper i) {

    SubCategory subCategory =
        addSubCategory(i.getProduct(), i.isForceAddSubCategory(), i.isForceAddAttribute());
    Category category = addCategory(i.getProduct(), i.isForceAddCategory());
    ProductCategory productCategory = addProductCategory(category, subCategory);

    i.getProduct().setProductCategory(productCategory);

    i.getProduct().setAttribute(
        removeDisAllowedAttribute(i.getProduct().getAttribute(), subCategory.getAttribute()));
    i.setProduct(productRepository.save(i.getProduct()));

    return i.getProduct();
  }

  @Override
  public Product update(Product product, long l) {
    return productRepository.save(product);
  }
}
