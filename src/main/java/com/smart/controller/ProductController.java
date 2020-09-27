package com.smart.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.smart.model.InputWrapper;
import com.smart.model.Product;
import com.smart.model.SubCategory;
import com.smart.service.CategorySubCatService;
import com.smart.service.ProductService;

@RestController
@RequestMapping(headers = "Accept=application/json", produces = "application/json",
    path = "/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private CategorySubCatService categorySub;

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
    return productService.getAllProducts();
  }

  @GetMapping(value = {"/category/"})
  public List<Product> getProductsByCategory(@RequestBody InputWrapper category) {
    // List<Product> products = new ArrayList<Product>();
    // productService.getAllProductsByCategory(category).forEach(products::add);
    return productService.getAllProductsByCategory(category);
  }

  // @GetMapping(value = {"/attribute/"})
  // public List<Product> getProductsByAttribute(@RequestBody Map<String, String> attribute) {
  // List<Product> products = new ArrayList<Product>();
  // productService.getAllProductsByAttribute(attribute).forEach(products::add);
  // return products;
  // }

  @GetMapping(value = {"/subcat"})
  public List<SubCategory> getSubCategoryByCategory(@RequestBody InputWrapper input) {
    return categorySub.getSubCategoryByCategory(input);
  }

  @PutMapping(value = {"/{id}"})
  public Product updateProduct(@RequestBody Product product, @PathVariable("id") String id) {
    return productService.updateProduct(product, new Long(id));
  }

}
