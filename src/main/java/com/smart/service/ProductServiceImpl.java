package com.smart.service;

import java.util.Map;
import javax.validation.constraints.Min;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.smart.exception.ResourceNotFoundException;
import com.smart.model.Category;
import com.smart.model.Product;
import com.smart.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public void deleteProduct(@Min(value = 1l, message = "Invalid product ID.") Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public Iterable<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Iterable<Product> getAllProductsByAttribute(Map<String, String> attribute) {
    return productRepository.getProductsByAttribute(attribute);
  }

  @Override
  public Iterable<Product> getAllProductsByCategory(Category category) {
    return productRepository.getProductsByCategory(category);
  }

  @Override
  public Product getProduct(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
  }

  @Override
  public Product updateProduct(Product product) {
    return productRepository.save(product);
  }
}
