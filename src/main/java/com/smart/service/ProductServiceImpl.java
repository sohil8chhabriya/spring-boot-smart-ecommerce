package com.smart.service;

import java.util.List;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.smart.dao.ProductDaoImpl;
import com.smart.model.InputWrapper;
import com.smart.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDaoImpl productDao;

  @Override
  public Product addProduct(Product product) {
    return productDao.save(product);
  }


  @Override
  public void deleteProduct(@Min(value = 1l, message = "Invalid product ID.") Long id) {
    productDao.delete(id);
  }

  @Override
  public List<Product> getAllProducts() {
    return productDao.getAll();
  }

  // @Override
  // public Iterable<Product> getAllProductsByAttribute(Map<String, String> attribute) {
  // return productRepository.getProductsByAttribute(attribute);
  // }

  @Override
  public List<Product> getAllProductsByCategory(InputWrapper input) {
    return productDao.getProductsByCategoryName(input);
  }

  @Override
  public Product getProduct(Long id) {
    return productDao.get(id);
  }

  @Override
  public Product updateProduct(Product product, long l) {
    return productDao.update(product, l);
  }
}
