package com.smart.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.smart.exception.ResourceNotFoundException;
import com.smart.model.Category;
import com.smart.model.InputWrapper;
import com.smart.model.Product;
import com.smart.model.ProductCategory;
import com.smart.model.SubCategory;
import com.smart.repository.ProductCategoryRepository;
import com.smart.repository.ProductRepository;
import com.smart.repository.SubCategoryRepository;

@Component
public class ProductDaoImpl implements Dao<Product>, ProductCatDao<Product, InputWrapper> {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  @Autowired
  private SubCategoryRepository subCategoryRepository;

  // @Autowired
  // private CategoryRepository categoryRepository;

  @Autowired
  private CategoryDaoImpl categoryDao;

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

  @Override
  public Product save(Product product) {
    Category category = categoryDao.getByName(product.getProductCategory().getCategory().getName());
    SubCategory subCategory =
        subCategoryRepository.findByName(product.getProductCategory().getSubCategory().getName());

    if (subCategory == null) {
      subCategory = new SubCategory();
      subCategory.setName(product.getProductCategory().getSubCategory().getName());
      subCategory.setAttribute(product.getAttribute().keySet());
      subCategory = subCategoryRepository.save(subCategory);
    } else {
      subCategory.setAttribute(product.getAttribute().keySet());
    }


    if (category == null) {
      category = new Category();
      category.setName(product.getProductCategory().getCategory().getName());
      subCategory.setAttribute(product.getAttribute().keySet());
      category = categoryDao.save(product.getProductCategory().getCategory());
    }

    ProductCategory productCategory = new ProductCategory();
    productCategory.setCategory(category);
    productCategory.setSubCategory(subCategory);

    productCategory = productCategoryRepository.save(productCategory);
    product.setProductCategory(productCategory);
    product = productRepository.save(product);

    return product;
  }

  @Override
  public Product update(Product product, long l) {
    return productRepository.save(product);
  }
}
