package com.smart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smart.model.Category;
import com.smart.model.Product;
import com.smart.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping(value = {"", "/"})
  public Product addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Object> delete(@PathVariable("id") String id) {
    productService.deleteProduct(new Long(id));
    return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public Product getProduct(@PathVariable("id") String id) {
    return productService.getProduct(new Long(id));
  }

  @GetMapping(value = {"", "/"})
  public List<Product> getProducts() {
    List<Product> products = new ArrayList<Product>();
    productService.getAllProducts().forEach(products::add);
    return products;
  }

  @GetMapping(value = {"/attribute/"})
  public List<Product> getProductsByAttribute(@RequestBody Map<String, String> attribute) {
    List<Product> products = new ArrayList<Product>();
    productService.getAllProductsByAttribute(attribute).forEach(products::add);
    return products;
  }

  @GetMapping(value = {"/category/"})
  public List<Product> getProductsByCategory(@RequestBody Category category) {
    List<Product> products = new ArrayList<Product>();
    productService.getAllProductsByCategory(category).forEach(products::add);
    return products;
  }


  @PutMapping(value = {"", "/"})
  public Product updateProduct(@RequestBody Product product) {
    return productService.updateProduct(product);
  }

}
